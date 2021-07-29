// Copyright (c) 2021 Digital Asset (Switzerland) GmbH and/or its affiliates. All rights reserved.
// SPDX-License-Identifier: Apache-2.0

package com.daml.quickstart.iou;

import com.daml.ledger.javaapi.data.*;
import com.daml.ledger.rxjava.DamlLedgerClient;
import com.daml.ledger.rxjava.LedgerClient;
import com.daml.quickstart.model.iou.Iou;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.protobuf.Empty;
import io.reactivex.disposables.Disposable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Spark;

// SETTING UP the system
// Make sure to: daml codegen java
// and: mvn compile
// In a separate terminal run: daml sandbox .daml/dist/quickstart-0.0.1.dar to start the sandbox
// Run your java by using: mvn exec:java@run-quickstart in a separate terminal.
// Initialize some contracts: daml script --dar .daml/dist/quickstart-0.0.1.dar --script-name Main:initialize --ledger-host localhost --ledger-port 6865 --static-time
// Run the UI by running: daml navigator server
// This starts the UI on http://localhost:4000
// DAML docs on the project are located at https://docs.daml.com/app-dev/bindings-java/quickstart.html


public class IouMain {

  private static final Logger logger = LoggerFactory.getLogger(IouMain.class);

  // application id used for sending commands
  public static final String APP_ID = "IouApp";

  public static void main(String[] args) {
    // Extract host and port from arguments
    if (args.length < 4) {
      System.err.println("Usage: LEDGER_HOST LEDGER_PORT PARTY REST_PORT");
      System.exit(-1);
    }
    String ledgerhost = args[0];
    int ledgerport = Integer.valueOf(args[1]);
    String party = args[2];
    int restport = Integer.valueOf(args[3]);


    // Create a client object to access services on the ledger.
    DamlLedgerClient client = DamlLedgerClient.newBuilder(ledgerhost, ledgerport).build();

    // Connects to the ledger and runs initial validation.
    client.connect();

    Utils u = new Utils();
    Connection c = u.connect();

    String ledgerId = client.getLedgerId();

    logger.info("ledger-id: {}", ledgerId);

    TransactionFilter iouFilter = filterFor(Iou.TEMPLATE_ID, party);

    AtomicLong idCounter = new AtomicLong(0);
    ConcurrentHashMap<Long, Iou> contracts = new ConcurrentHashMap<>();
    BiMap<Long, Iou.ContractId> idMap = Maps.synchronizedBiMap(HashBiMap.create());
    AtomicReference<LedgerOffset> acsOffset =
        new AtomicReference<>(LedgerOffset.LedgerBegin.getInstance());

    client
        .getActiveContractSetClient()
        .getActiveContracts(iouFilter, true)
        .blockingForEach(
            response -> {
              response
                  .getOffset()
                  .ifPresent(offset -> acsOffset.set(new LedgerOffset.Absolute(offset)));
              response.getCreatedEvents().stream()
                  .map(Iou.Contract::fromCreatedEvent)
                  .forEach(
                      contract -> {
                        long id = idCounter.getAndIncrement();
                        contracts.put(id, contract.data);
                        idMap.put(id, contract.id);
                      });
            });

    Disposable ignore =
        client
            .getTransactionsClient()
            .getTransactions(acsOffset.get(), iouFilter, true)
            .forEach(
                t -> {
                  for (Event event : t.getEvents()) {
                    if (event instanceof CreatedEvent) {
                      CreatedEvent createdEvent = (CreatedEvent) event;
                      long id = idCounter.getAndIncrement();
                      Iou.Contract contract = Iou.Contract.fromCreatedEvent(createdEvent);
                      contracts.put(id, contract.data);
                      idMap.put(id, contract.id);
                      try {
                          addContract(c, contract, id);
                      } catch (Exception e) {
                          e.printStackTrace();
                          System.exit(1);
                      }
                    } else if (event instanceof ArchivedEvent) {
                      ArchivedEvent archivedEvent = (ArchivedEvent) event;
                      long id =
                          idMap.inverse().get(new Iou.ContractId(archivedEvent.getContractId()));
                      contracts.remove(id);
                      idMap.remove(id);
                      try {
                          archiveContract(c, archivedEvent, id);
                      } catch (SQLException e) {
                          e.printStackTrace();
                          System.exit(1);
                      }
                    }
                  }
                });

    Gson g = new Gson();
    Spark.port(restport);
    Spark.get("/iou", "application/json", (req, res) -> g.toJson(contracts));
    Spark.get(
        "/iou/:id",
        "application/json",
        (req, res) -> g.toJson(contracts.getOrDefault(Long.parseLong(req.params("id")), null)));
    Spark.put(
        "/iou",
        (req, res) -> {
          Iou iou = g.fromJson(req.body(), Iou.class);
          CreateCommand iouCreate = iou.create();
          submit(client, party, iouCreate);
          return "Iou creation submitted.";
        },
        g::toJson);
    Spark.post(
        "/iou/:id/transfer",
        "application/json",
        (req, res) -> {
          Map m = g.fromJson(req.body(), Map.class);
          Iou.ContractId contractId = idMap.get(Long.parseLong(req.params("id")));
          ExerciseCommand exerciseCommand =
              contractId.exerciseIou_Transfer(m.get("newOwner").toString());
          submit(client, party, exerciseCommand);
          return "Iou transfer submitted.";
        },
        g::toJson);

    // Run until user terminates.
    while (true)
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
  }

  private static Empty submit(LedgerClient client, String party, Command c) {
    return client
        .getCommandSubmissionClient()
        .submit(
            UUID.randomUUID().toString(),
            "IouApp",
            UUID.randomUUID().toString(),
            party,
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Collections.singletonList(c))
        .blockingGet();
  }

  private static TransactionFilter filterFor(Identifier templateId, String party) {
    InclusiveFilter inclusiveFilter = new InclusiveFilter(Collections.singleton(templateId));
    Map<String, Filter> filter = Collections.singletonMap(party, inclusiveFilter);
    return new FiltersByParty(filter);
  }



    static void addContract(Connection c, Iou.Contract contract, Long id) throws SQLException {
        try {
            Statement stmt = c.createStatement();
            String sql = String.format(
                    "INSERT iou.contracts VALUES(%d, \"%s\", \"%s\", \"%s\", \"%s\", %f);",
                    id,
                    contract.id.contractId,
                    contract.data.issuer,
                    contract.data.owner,
                    contract.data.currency,
                    contract.data.amount);
            stmt.execute(sql);
            c.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    static void archiveContract(Connection c, ArchivedEvent archivedEvent, Long id) throws SQLException {
        try {
            archivedEvent.getTemplateId().toString();
            Statement stmt = c.createStatement();
            String sql = String.format(
                    "DISCONTINUE iou.contracts (id) VALUES (%d)",
                    id);
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
