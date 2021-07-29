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

public class Iou_RemoveObserver {
  public static final String _packageId = "69fde1e558cfcfe65c62dd712d6031dba68f6037a0212afa571a9a4305bfcb6a";

  public final String oldObserver;

  public Iou_RemoveObserver(String oldObserver) {
    this.oldObserver = oldObserver;
  }

  public static Iou_RemoveObserver fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 1) {
      throw new IllegalArgumentException("Expected 1 arguments, got " + numberOfFields);
    }
    String oldObserver = fields$.get(0).getValue().asParty().orElseThrow(() -> new IllegalArgumentException("Expected oldObserver to be of type com.daml.ledger.javaapi.data.Party")).getValue();
    return new com.daml.quickstart.model.iou.Iou_RemoveObserver(oldObserver);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(1);
    fields.add(new Record.Field("oldObserver", new Party(this.oldObserver)));
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
    if (!(object instanceof Iou_RemoveObserver)) {
      return false;
    }
    Iou_RemoveObserver other = (Iou_RemoveObserver) object;
    return this.oldObserver.equals(other.oldObserver);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.oldObserver);
  }

  @Override
  public String toString() {
    return String.format("com.daml.quickstart.model.iou.Iou_RemoveObserver(%s)", this.oldObserver);
  }
}
