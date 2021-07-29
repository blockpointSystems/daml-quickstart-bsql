package com.daml.quickstart.model.ioutrade;

import com.daml.ledger.javaapi.data.CreateAndExerciseCommand;
import com.daml.ledger.javaapi.data.CreateCommand;
import com.daml.ledger.javaapi.data.CreatedEvent;
import com.daml.ledger.javaapi.data.ExerciseCommand;
import com.daml.ledger.javaapi.data.Identifier;
import com.daml.ledger.javaapi.data.Numeric;
import com.daml.ledger.javaapi.data.Party;
import com.daml.ledger.javaapi.data.Record;
import com.daml.ledger.javaapi.data.Template;
import com.daml.ledger.javaapi.data.Text;
import com.daml.ledger.javaapi.data.Value;
import com.daml.quickstart.model.da.internal.template.Archive;
import com.daml.quickstart.model.iou.Iou;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public final class IouTrade extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("69fde1e558cfcfe65c62dd712d6031dba68f6037a0212afa571a9a4305bfcb6a", "IouTrade", "IouTrade");

  public final String buyer;

  public final String seller;

  public final Iou.ContractId baseIouCid;

  public final String baseIssuer;

  public final String baseCurrency;

  public final BigDecimal baseAmount;

  public final String quoteIssuer;

  public final String quoteCurrency;

  public final BigDecimal quoteAmount;

  public IouTrade(String buyer, String seller, Iou.ContractId baseIouCid, String baseIssuer,
      String baseCurrency, BigDecimal baseAmount, String quoteIssuer, String quoteCurrency,
      BigDecimal quoteAmount) {
    this.buyer = buyer;
    this.seller = seller;
    this.baseIouCid = baseIouCid;
    this.baseIssuer = baseIssuer;
    this.baseCurrency = baseCurrency;
    this.baseAmount = baseAmount;
    this.quoteIssuer = quoteIssuer;
    this.quoteCurrency = quoteCurrency;
    this.quoteAmount = quoteAmount;
  }

  public CreateCommand create() {
    return new CreateCommand(IouTrade.TEMPLATE_ID, this.toValue());
  }

  public CreateAndExerciseCommand createAndExerciseIouTrade_Accept(IouTrade_Accept arg) {
    Value argValue = arg.toValue();
    return new CreateAndExerciseCommand(IouTrade.TEMPLATE_ID, this.toValue(), "IouTrade_Accept", argValue);
  }

  public CreateAndExerciseCommand createAndExerciseIouTrade_Accept(Iou.ContractId quoteIouCid) {
    return createAndExerciseIouTrade_Accept(new IouTrade_Accept(quoteIouCid));
  }

  public CreateAndExerciseCommand createAndExerciseArchive(Archive arg) {
    Value argValue = arg.toValue();
    return new CreateAndExerciseCommand(IouTrade.TEMPLATE_ID, this.toValue(), "Archive", argValue);
  }

  public CreateAndExerciseCommand createAndExerciseTradeProposal_Reject(TradeProposal_Reject arg) {
    Value argValue = arg.toValue();
    return new CreateAndExerciseCommand(IouTrade.TEMPLATE_ID, this.toValue(), "TradeProposal_Reject", argValue);
  }

  public CreateAndExerciseCommand createAndExerciseTradeProposal_Reject() {
    return createAndExerciseTradeProposal_Reject(new TradeProposal_Reject());
  }

  public static CreateCommand create(String buyer, String seller, Iou.ContractId baseIouCid,
      String baseIssuer, String baseCurrency, BigDecimal baseAmount, String quoteIssuer,
      String quoteCurrency, BigDecimal quoteAmount) {
    return new IouTrade(buyer, seller, baseIouCid, baseIssuer, baseCurrency, baseAmount, quoteIssuer, quoteCurrency, quoteAmount).create();
  }

  public static IouTrade fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 9) {
      throw new IllegalArgumentException("Expected 9 arguments, got " + numberOfFields);
    }
    String buyer = fields$.get(0).getValue().asParty().orElseThrow(() -> new IllegalArgumentException("Expected buyer to be of type com.daml.ledger.javaapi.data.Party")).getValue();
    String seller = fields$.get(1).getValue().asParty().orElseThrow(() -> new IllegalArgumentException("Expected seller to be of type com.daml.ledger.javaapi.data.Party")).getValue();
    Iou.ContractId baseIouCid = new Iou.ContractId(fields$.get(2).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected baseIouCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
    String baseIssuer = fields$.get(3).getValue().asParty().orElseThrow(() -> new IllegalArgumentException("Expected baseIssuer to be of type com.daml.ledger.javaapi.data.Party")).getValue();
    String baseCurrency = fields$.get(4).getValue().asText().orElseThrow(() -> new IllegalArgumentException("Expected baseCurrency to be of type com.daml.ledger.javaapi.data.Text")).getValue();
    BigDecimal baseAmount = fields$.get(5).getValue().asNumeric().orElseThrow(() -> new IllegalArgumentException("Expected baseAmount to be of type com.daml.ledger.javaapi.data.Numeric")).getValue();
    String quoteIssuer = fields$.get(6).getValue().asParty().orElseThrow(() -> new IllegalArgumentException("Expected quoteIssuer to be of type com.daml.ledger.javaapi.data.Party")).getValue();
    String quoteCurrency = fields$.get(7).getValue().asText().orElseThrow(() -> new IllegalArgumentException("Expected quoteCurrency to be of type com.daml.ledger.javaapi.data.Text")).getValue();
    BigDecimal quoteAmount = fields$.get(8).getValue().asNumeric().orElseThrow(() -> new IllegalArgumentException("Expected quoteAmount to be of type com.daml.ledger.javaapi.data.Numeric")).getValue();
    return new com.daml.quickstart.model.ioutrade.IouTrade(buyer, seller, baseIouCid, baseIssuer, baseCurrency, baseAmount, quoteIssuer, quoteCurrency, quoteAmount);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(9);
    fields.add(new Record.Field("buyer", new Party(this.buyer)));
    fields.add(new Record.Field("seller", new Party(this.seller)));
    fields.add(new Record.Field("baseIouCid", this.baseIouCid.toValue()));
    fields.add(new Record.Field("baseIssuer", new Party(this.baseIssuer)));
    fields.add(new Record.Field("baseCurrency", new Text(this.baseCurrency)));
    fields.add(new Record.Field("baseAmount", new Numeric(this.baseAmount)));
    fields.add(new Record.Field("quoteIssuer", new Party(this.quoteIssuer)));
    fields.add(new Record.Field("quoteCurrency", new Text(this.quoteCurrency)));
    fields.add(new Record.Field("quoteAmount", new Numeric(this.quoteAmount)));
    return new Record(fields);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof IouTrade)) {
      return false;
    }
    IouTrade other = (IouTrade) object;
    return this.buyer.equals(other.buyer) && this.seller.equals(other.seller) && this.baseIouCid.equals(other.baseIouCid) && this.baseIssuer.equals(other.baseIssuer) && this.baseCurrency.equals(other.baseCurrency) && this.baseAmount.equals(other.baseAmount) && this.quoteIssuer.equals(other.quoteIssuer) && this.quoteCurrency.equals(other.quoteCurrency) && this.quoteAmount.equals(other.quoteAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.buyer, this.seller, this.baseIouCid, this.baseIssuer, this.baseCurrency, this.baseAmount, this.quoteIssuer, this.quoteCurrency, this.quoteAmount);
  }

  @Override
  public String toString() {
    return String.format("com.daml.quickstart.model.ioutrade.IouTrade(%s, %s, %s, %s, %s, %s, %s, %s, %s)", this.buyer, this.seller, this.baseIouCid, this.baseIssuer, this.baseCurrency, this.baseAmount, this.quoteIssuer, this.quoteCurrency, this.quoteAmount);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<IouTrade> {
    public ContractId(String contractId) {
      super(contractId);
    }

    public ExerciseCommand exerciseIouTrade_Accept(IouTrade_Accept arg) {
      Value argValue = arg.toValue();
      return new ExerciseCommand(IouTrade.TEMPLATE_ID, this.contractId, "IouTrade_Accept", argValue);
    }

    public ExerciseCommand exerciseIouTrade_Accept(Iou.ContractId quoteIouCid) {
      return exerciseIouTrade_Accept(new IouTrade_Accept(quoteIouCid));
    }

    public ExerciseCommand exerciseArchive(Archive arg) {
      Value argValue = arg.toValue();
      return new ExerciseCommand(IouTrade.TEMPLATE_ID, this.contractId, "Archive", argValue);
    }

    public ExerciseCommand exerciseTradeProposal_Reject(TradeProposal_Reject arg) {
      Value argValue = arg.toValue();
      return new ExerciseCommand(IouTrade.TEMPLATE_ID, this.contractId, "TradeProposal_Reject", argValue);
    }

    public ExerciseCommand exerciseTradeProposal_Reject() {
      return exerciseTradeProposal_Reject(new TradeProposal_Reject());
    }
  }

  public static class Contract implements com.daml.ledger.javaapi.data.Contract {
    public final ContractId id;

    public final IouTrade data;

    public final Optional<String> agreementText;

    public final Set<String> signatories;

    public final Set<String> observers;

    public Contract(ContractId id, IouTrade data, Optional<String> agreementText,
        Set<String> signatories, Set<String> observers) {
      this.id = id;
      this.data = data;
      this.agreementText = agreementText;
      this.signatories = signatories;
      this.observers = observers;
    }

    public static Contract fromIdAndRecord(String contractId, Record record$,
        Optional<String> agreementText, Set<String> signatories, Set<String> observers) {
      ContractId id = new ContractId(contractId);
      IouTrade data = IouTrade.fromValue(record$);
      return new Contract(id, data, agreementText, signatories, observers);
    }

    @Deprecated
    public static Contract fromIdAndRecord(String contractId, Record record$) {
      ContractId id = new ContractId(contractId);
      IouTrade data = IouTrade.fromValue(record$);
      return new Contract(id, data, Optional.empty(), Collections.emptySet(), Collections.emptySet());
    }

    public static Contract fromCreatedEvent(CreatedEvent event) {
      return fromIdAndRecord(event.getContractId(), event.getArguments(), event.getAgreementText(), event.getSignatories(), event.getObservers());
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
        return true;
      }
      if (object == null) {
        return false;
      }
      if (!(object instanceof Contract)) {
        return false;
      }
      Contract other = (Contract) object;
      return this.id.equals(other.id) && this.data.equals(other.data) && this.agreementText.equals(other.agreementText) && this.signatories.equals(other.signatories) && this.observers.equals(other.observers);
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.id, this.data, this.agreementText, this.signatories, this.observers);
    }

    @Override
    public String toString() {
      return String.format("com.daml.quickstart.model.ioutrade.IouTrade.Contract(%s, %s, %s, %s, %s)", this.id, this.data, this.agreementText, this.signatories, this.observers);
    }
  }
}
