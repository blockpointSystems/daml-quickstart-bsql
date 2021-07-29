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

public class Iou_AddObserver {
  public static final String _packageId = "69fde1e558cfcfe65c62dd712d6031dba68f6037a0212afa571a9a4305bfcb6a";

  public final String newObserver;

  public Iou_AddObserver(String newObserver) {
    this.newObserver = newObserver;
  }

  public static Iou_AddObserver fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 1) {
      throw new IllegalArgumentException("Expected 1 arguments, got " + numberOfFields);
    }
    String newObserver = fields$.get(0).getValue().asParty().orElseThrow(() -> new IllegalArgumentException("Expected newObserver to be of type com.daml.ledger.javaapi.data.Party")).getValue();
    return new com.daml.quickstart.model.iou.Iou_AddObserver(newObserver);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(1);
    fields.add(new Record.Field("newObserver", new Party(this.newObserver)));
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
    if (!(object instanceof Iou_AddObserver)) {
      return false;
    }
    Iou_AddObserver other = (Iou_AddObserver) object;
    return this.newObserver.equals(other.newObserver);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.newObserver);
  }

  @Override
  public String toString() {
    return String.format("com.daml.quickstart.model.iou.Iou_AddObserver(%s)", this.newObserver);
  }
}
