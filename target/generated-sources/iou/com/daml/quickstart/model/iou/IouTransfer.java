package com.daml.quickstart.model.iou;

import com.daml.ledger.javaapi.data.CreateAndExerciseCommand;
import com.daml.ledger.javaapi.data.CreateCommand;
import com.daml.ledger.javaapi.data.CreatedEvent;
import com.daml.ledger.javaapi.data.ExerciseCommand;
import com.daml.ledger.javaapi.data.Identifier;
import com.daml.ledger.javaapi.data.Party;
import com.daml.ledger.javaapi.data.Record;
import com.daml.ledger.javaapi.data.Template;
import com.daml.ledger.javaapi.data.Value;
import com.daml.quickstart.model.da.internal.template.Archive;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public final class IouTransfer extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("69fde1e558cfcfe65c62dd712d6031dba68f6037a0212afa571a9a4305bfcb6a", "Iou", "IouTransfer");

  public final Iou iou;

  public final String newOwner;

  public IouTransfer(Iou iou, String newOwner) {
    this.iou = iou;
    this.newOwner = newOwner;
  }

  public CreateCommand create() {
    return new CreateCommand(IouTransfer.TEMPLATE_ID, this.toValue());
  }

  public CreateAndExerciseCommand createAndExerciseIouTransfer_Cancel(IouTransfer_Cancel arg) {
    Value argValue = arg.toValue();
    return new CreateAndExerciseCommand(IouTransfer.TEMPLATE_ID, this.toValue(), "IouTransfer_Cancel", argValue);
  }

  public CreateAndExerciseCommand createAndExerciseIouTransfer_Cancel() {
    return createAndExerciseIouTransfer_Cancel(new IouTransfer_Cancel());
  }

  public CreateAndExerciseCommand createAndExerciseIouTransfer_Reject(IouTransfer_Reject arg) {
    Value argValue = arg.toValue();
    return new CreateAndExerciseCommand(IouTransfer.TEMPLATE_ID, this.toValue(), "IouTransfer_Reject", argValue);
  }

  public CreateAndExerciseCommand createAndExerciseIouTransfer_Reject() {
    return createAndExerciseIouTransfer_Reject(new IouTransfer_Reject());
  }

  public CreateAndExerciseCommand createAndExerciseArchive(Archive arg) {
    Value argValue = arg.toValue();
    return new CreateAndExerciseCommand(IouTransfer.TEMPLATE_ID, this.toValue(), "Archive", argValue);
  }

  public CreateAndExerciseCommand createAndExerciseIouTransfer_Accept(IouTransfer_Accept arg) {
    Value argValue = arg.toValue();
    return new CreateAndExerciseCommand(IouTransfer.TEMPLATE_ID, this.toValue(), "IouTransfer_Accept", argValue);
  }

  public CreateAndExerciseCommand createAndExerciseIouTransfer_Accept() {
    return createAndExerciseIouTransfer_Accept(new IouTransfer_Accept());
  }

  public static CreateCommand create(Iou iou, String newOwner) {
    return new IouTransfer(iou, newOwner).create();
  }

  public static IouTransfer fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 2) {
      throw new IllegalArgumentException("Expected 2 arguments, got " + numberOfFields);
    }
    Iou iou = Iou.fromValue(fields$.get(0).getValue());
    String newOwner = fields$.get(1).getValue().asParty().orElseThrow(() -> new IllegalArgumentException("Expected newOwner to be of type com.daml.ledger.javaapi.data.Party")).getValue();
    return new com.daml.quickstart.model.iou.IouTransfer(iou, newOwner);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(2);
    fields.add(new Record.Field("iou", this.iou.toValue()));
    fields.add(new Record.Field("newOwner", new Party(this.newOwner)));
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
    if (!(object instanceof IouTransfer)) {
      return false;
    }
    IouTransfer other = (IouTransfer) object;
    return this.iou.equals(other.iou) && this.newOwner.equals(other.newOwner);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.iou, this.newOwner);
  }

  @Override
  public String toString() {
    return String.format("com.daml.quickstart.model.iou.IouTransfer(%s, %s)", this.iou, this.newOwner);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<IouTransfer> {
    public ContractId(String contractId) {
      super(contractId);
    }

    public ExerciseCommand exerciseIouTransfer_Cancel(IouTransfer_Cancel arg) {
      Value argValue = arg.toValue();
      return new ExerciseCommand(IouTransfer.TEMPLATE_ID, this.contractId, "IouTransfer_Cancel", argValue);
    }

    public ExerciseCommand exerciseIouTransfer_Cancel() {
      return exerciseIouTransfer_Cancel(new IouTransfer_Cancel());
    }

    public ExerciseCommand exerciseIouTransfer_Reject(IouTransfer_Reject arg) {
      Value argValue = arg.toValue();
      return new ExerciseCommand(IouTransfer.TEMPLATE_ID, this.contractId, "IouTransfer_Reject", argValue);
    }

    public ExerciseCommand exerciseIouTransfer_Reject() {
      return exerciseIouTransfer_Reject(new IouTransfer_Reject());
    }

    public ExerciseCommand exerciseArchive(Archive arg) {
      Value argValue = arg.toValue();
      return new ExerciseCommand(IouTransfer.TEMPLATE_ID, this.contractId, "Archive", argValue);
    }

    public ExerciseCommand exerciseIouTransfer_Accept(IouTransfer_Accept arg) {
      Value argValue = arg.toValue();
      return new ExerciseCommand(IouTransfer.TEMPLATE_ID, this.contractId, "IouTransfer_Accept", argValue);
    }

    public ExerciseCommand exerciseIouTransfer_Accept() {
      return exerciseIouTransfer_Accept(new IouTransfer_Accept());
    }
  }

  public static class Contract implements com.daml.ledger.javaapi.data.Contract {
    public final ContractId id;

    public final IouTransfer data;

    public final Optional<String> agreementText;

    public final Set<String> signatories;

    public final Set<String> observers;

    public Contract(ContractId id, IouTransfer data, Optional<String> agreementText,
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
      IouTransfer data = IouTransfer.fromValue(record$);
      return new Contract(id, data, agreementText, signatories, observers);
    }

    @Deprecated
    public static Contract fromIdAndRecord(String contractId, Record record$) {
      ContractId id = new ContractId(contractId);
      IouTransfer data = IouTransfer.fromValue(record$);
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
      return String.format("com.daml.quickstart.model.iou.IouTransfer.Contract(%s, %s, %s, %s, %s)", this.id, this.data, this.agreementText, this.signatories, this.observers);
    }
  }
}
