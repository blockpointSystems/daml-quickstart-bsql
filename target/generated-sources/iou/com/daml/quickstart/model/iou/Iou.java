package com.daml.quickstart.model.iou;

import com.daml.ledger.javaapi.data.CreateAndExerciseCommand;
import com.daml.ledger.javaapi.data.CreateCommand;
import com.daml.ledger.javaapi.data.CreatedEvent;
import com.daml.ledger.javaapi.data.DamlCollectors;
import com.daml.ledger.javaapi.data.ExerciseCommand;
import com.daml.ledger.javaapi.data.Identifier;
import com.daml.ledger.javaapi.data.Numeric;
import com.daml.ledger.javaapi.data.Party;
import com.daml.ledger.javaapi.data.Record;
import com.daml.ledger.javaapi.data.Template;
import com.daml.ledger.javaapi.data.Text;
import com.daml.ledger.javaapi.data.Value;
import com.daml.quickstart.model.da.internal.template.Archive;
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

public final class Iou extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("69fde1e558cfcfe65c62dd712d6031dba68f6037a0212afa571a9a4305bfcb6a", "Iou", "Iou");

  public final String issuer;

  public final String owner;

  public final String currency;

  public final BigDecimal amount;

  public final List<String> observers;

  public Iou(String issuer, String owner, String currency, BigDecimal amount,
      List<String> observers) {
    this.issuer = issuer;
    this.owner = owner;
    this.currency = currency;
    this.amount = amount;
    this.observers = observers;
  }

  public CreateCommand create() {
    return new CreateCommand(Iou.TEMPLATE_ID, this.toValue());
  }

  public CreateAndExerciseCommand createAndExerciseIou_AddObserver(Iou_AddObserver arg) {
    Value argValue = arg.toValue();
    return new CreateAndExerciseCommand(Iou.TEMPLATE_ID, this.toValue(), "Iou_AddObserver", argValue);
  }

  public CreateAndExerciseCommand createAndExerciseIou_AddObserver(String newObserver) {
    return createAndExerciseIou_AddObserver(new Iou_AddObserver(newObserver));
  }

  public CreateAndExerciseCommand createAndExerciseIou_Split(Iou_Split arg) {
    Value argValue = arg.toValue();
    return new CreateAndExerciseCommand(Iou.TEMPLATE_ID, this.toValue(), "Iou_Split", argValue);
  }

  public CreateAndExerciseCommand createAndExerciseIou_Split(BigDecimal splitAmount) {
    return createAndExerciseIou_Split(new Iou_Split(splitAmount));
  }

  public CreateAndExerciseCommand createAndExerciseIou_RemoveObserver(Iou_RemoveObserver arg) {
    Value argValue = arg.toValue();
    return new CreateAndExerciseCommand(Iou.TEMPLATE_ID, this.toValue(), "Iou_RemoveObserver", argValue);
  }

  public CreateAndExerciseCommand createAndExerciseIou_RemoveObserver(String oldObserver) {
    return createAndExerciseIou_RemoveObserver(new Iou_RemoveObserver(oldObserver));
  }

  public CreateAndExerciseCommand createAndExerciseIou_Transfer(Iou_Transfer arg) {
    Value argValue = arg.toValue();
    return new CreateAndExerciseCommand(Iou.TEMPLATE_ID, this.toValue(), "Iou_Transfer", argValue);
  }

  public CreateAndExerciseCommand createAndExerciseIou_Transfer(String newOwner) {
    return createAndExerciseIou_Transfer(new Iou_Transfer(newOwner));
  }

  public CreateAndExerciseCommand createAndExerciseIou_Merge(Iou_Merge arg) {
    Value argValue = arg.toValue();
    return new CreateAndExerciseCommand(Iou.TEMPLATE_ID, this.toValue(), "Iou_Merge", argValue);
  }

  public CreateAndExerciseCommand createAndExerciseIou_Merge(ContractId otherCid) {
    return createAndExerciseIou_Merge(new Iou_Merge(otherCid));
  }

  public CreateAndExerciseCommand createAndExerciseArchive(Archive arg) {
    Value argValue = arg.toValue();
    return new CreateAndExerciseCommand(Iou.TEMPLATE_ID, this.toValue(), "Archive", argValue);
  }

  public static CreateCommand create(String issuer, String owner, String currency,
      BigDecimal amount, List<String> observers) {
    return new Iou(issuer, owner, currency, amount, observers).create();
  }

  public static Iou fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 5) {
      throw new IllegalArgumentException("Expected 5 arguments, got " + numberOfFields);
    }
    String issuer = fields$.get(0).getValue().asParty().orElseThrow(() -> new IllegalArgumentException("Expected issuer to be of type com.daml.ledger.javaapi.data.Party")).getValue();
    String owner = fields$.get(1).getValue().asParty().orElseThrow(() -> new IllegalArgumentException("Expected owner to be of type com.daml.ledger.javaapi.data.Party")).getValue();
    String currency = fields$.get(2).getValue().asText().orElseThrow(() -> new IllegalArgumentException("Expected currency to be of type com.daml.ledger.javaapi.data.Text")).getValue();
    BigDecimal amount = fields$.get(3).getValue().asNumeric().orElseThrow(() -> new IllegalArgumentException("Expected amount to be of type com.daml.ledger.javaapi.data.Numeric")).getValue();
    List<String> observers = fields$.get(4).getValue().asList()
            .map(v$0 -> v$0.toList(v$1 ->
                v$1.asParty().orElseThrow(() -> new IllegalArgumentException("Expected v$1 to be of type com.daml.ledger.javaapi.data.Party")).getValue()
            ))
            .orElseThrow(() -> new IllegalArgumentException("Expected observers to be of type com.daml.ledger.javaapi.data.DamlList"))
        ;
    return new com.daml.quickstart.model.iou.Iou(issuer, owner, currency, amount, observers);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(5);
    fields.add(new Record.Field("issuer", new Party(this.issuer)));
    fields.add(new Record.Field("owner", new Party(this.owner)));
    fields.add(new Record.Field("currency", new Text(this.currency)));
    fields.add(new Record.Field("amount", new Numeric(this.amount)));
    fields.add(new Record.Field("observers", this.observers.stream().collect(DamlCollectors.toDamlList(v$0 -> new Party(v$0)))));
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
    if (!(object instanceof Iou)) {
      return false;
    }
    Iou other = (Iou) object;
    return this.issuer.equals(other.issuer) && this.owner.equals(other.owner) && this.currency.equals(other.currency) && this.amount.equals(other.amount) && this.observers.equals(other.observers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.issuer, this.owner, this.currency, this.amount, this.observers);
  }

  @Override
  public String toString() {
    return String.format("com.daml.quickstart.model.iou.Iou(%s, %s, %s, %s, %s)", this.issuer, this.owner, this.currency, this.amount, this.observers);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<Iou> {
    public ContractId(String contractId) {
      super(contractId);
    }

    public ExerciseCommand exerciseIou_AddObserver(Iou_AddObserver arg) {
      Value argValue = arg.toValue();
      return new ExerciseCommand(Iou.TEMPLATE_ID, this.contractId, "Iou_AddObserver", argValue);
    }

    public ExerciseCommand exerciseIou_AddObserver(String newObserver) {
      return exerciseIou_AddObserver(new Iou_AddObserver(newObserver));
    }

    public ExerciseCommand exerciseIou_Split(Iou_Split arg) {
      Value argValue = arg.toValue();
      return new ExerciseCommand(Iou.TEMPLATE_ID, this.contractId, "Iou_Split", argValue);
    }

    public ExerciseCommand exerciseIou_Split(BigDecimal splitAmount) {
      return exerciseIou_Split(new Iou_Split(splitAmount));
    }

    public ExerciseCommand exerciseIou_RemoveObserver(Iou_RemoveObserver arg) {
      Value argValue = arg.toValue();
      return new ExerciseCommand(Iou.TEMPLATE_ID, this.contractId, "Iou_RemoveObserver", argValue);
    }

    public ExerciseCommand exerciseIou_RemoveObserver(String oldObserver) {
      return exerciseIou_RemoveObserver(new Iou_RemoveObserver(oldObserver));
    }

    public ExerciseCommand exerciseIou_Transfer(Iou_Transfer arg) {
      Value argValue = arg.toValue();
      return new ExerciseCommand(Iou.TEMPLATE_ID, this.contractId, "Iou_Transfer", argValue);
    }

    public ExerciseCommand exerciseIou_Transfer(String newOwner) {
      return exerciseIou_Transfer(new Iou_Transfer(newOwner));
    }

    public ExerciseCommand exerciseIou_Merge(Iou_Merge arg) {
      Value argValue = arg.toValue();
      return new ExerciseCommand(Iou.TEMPLATE_ID, this.contractId, "Iou_Merge", argValue);
    }

    public ExerciseCommand exerciseIou_Merge(ContractId otherCid) {
      return exerciseIou_Merge(new Iou_Merge(otherCid));
    }

    public ExerciseCommand exerciseArchive(Archive arg) {
      Value argValue = arg.toValue();
      return new ExerciseCommand(Iou.TEMPLATE_ID, this.contractId, "Archive", argValue);
    }
  }

  public static class Contract implements com.daml.ledger.javaapi.data.Contract {
    public final ContractId id;

    public final Iou data;

    public final Optional<String> agreementText;

    public final Set<String> signatories;

    public final Set<String> observers;

    public Contract(ContractId id, Iou data, Optional<String> agreementText,
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
      Iou data = Iou.fromValue(record$);
      return new Contract(id, data, agreementText, signatories, observers);
    }

    @Deprecated
    public static Contract fromIdAndRecord(String contractId, Record record$) {
      ContractId id = new ContractId(contractId);
      Iou data = Iou.fromValue(record$);
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
      return String.format("com.daml.quickstart.model.iou.Iou.Contract(%s, %s, %s, %s, %s)", this.id, this.data, this.agreementText, this.signatories, this.observers);
    }
  }
}
