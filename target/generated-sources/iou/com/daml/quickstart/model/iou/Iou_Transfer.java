package com.daml.quickstart.model.iou;

import com.daml.ledger.javaapi.data.Party;
import com.daml.ledger.javaapi.data.Record;
import com.daml.ledger.javaapi.data.Value;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Iou_Transfer {
  public static final String _packageId = "69fde1e558cfcfe65c62dd712d6031dba68f6037a0212afa571a9a4305bfcb6a";

  public final String newOwner;

  public Iou_Transfer(String newOwner) {
    this.newOwner = newOwner;
  }

  public static Iou_Transfer fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 1) {
      throw new IllegalArgumentException("Expected 1 arguments, got " + numberOfFields);
    }
    String newOwner = fields$.get(0).getValue().asParty().orElseThrow(() -> new IllegalArgumentException("Expected newOwner to be of type com.daml.ledger.javaapi.data.Party")).getValue();
    return new com.daml.quickstart.model.iou.Iou_Transfer(newOwner);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(1);
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
    if (!(object instanceof Iou_Transfer)) {
      return false;
    }
    Iou_Transfer other = (Iou_Transfer) object;
    return this.newOwner.equals(other.newOwner);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.newOwner);
  }

  @Override
  public String toString() {
    return String.format("com.daml.quickstart.model.iou.Iou_Transfer(%s)", this.newOwner);
  }
}
