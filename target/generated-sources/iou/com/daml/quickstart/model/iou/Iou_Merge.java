package com.daml.quickstart.model.iou;

import com.daml.ledger.javaapi.data.Record;
import com.daml.ledger.javaapi.data.Value;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Iou_Merge {
  public static final String _packageId = "69fde1e558cfcfe65c62dd712d6031dba68f6037a0212afa571a9a4305bfcb6a";

  public final Iou.ContractId otherCid;

  public Iou_Merge(Iou.ContractId otherCid) {
    this.otherCid = otherCid;
  }

  public static Iou_Merge fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 1) {
      throw new IllegalArgumentException("Expected 1 arguments, got " + numberOfFields);
    }
    Iou.ContractId otherCid = new Iou.ContractId(fields$.get(0).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected otherCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
    return new com.daml.quickstart.model.iou.Iou_Merge(otherCid);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(1);
    fields.add(new Record.Field("otherCid", this.otherCid.toValue()));
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
    if (!(object instanceof Iou_Merge)) {
      return false;
    }
    Iou_Merge other = (Iou_Merge) object;
    return this.otherCid.equals(other.otherCid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.otherCid);
  }

  @Override
  public String toString() {
    return String.format("com.daml.quickstart.model.iou.Iou_Merge(%s)", this.otherCid);
  }
}
