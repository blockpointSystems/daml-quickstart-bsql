package com.daml.quickstart.model.iou;

import com.daml.ledger.javaapi.data.Numeric;
import com.daml.ledger.javaapi.data.Record;
import com.daml.ledger.javaapi.data.Value;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Iou_Split {
  public static final String _packageId = "69fde1e558cfcfe65c62dd712d6031dba68f6037a0212afa571a9a4305bfcb6a";

  public final BigDecimal splitAmount;

  public Iou_Split(BigDecimal splitAmount) {
    this.splitAmount = splitAmount;
  }

  public static Iou_Split fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 1) {
      throw new IllegalArgumentException("Expected 1 arguments, got " + numberOfFields);
    }
    BigDecimal splitAmount = fields$.get(0).getValue().asNumeric().orElseThrow(() -> new IllegalArgumentException("Expected splitAmount to be of type com.daml.ledger.javaapi.data.Numeric")).getValue();
    return new com.daml.quickstart.model.iou.Iou_Split(splitAmount);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(1);
    fields.add(new Record.Field("splitAmount", new Numeric(this.splitAmount)));
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
    if (!(object instanceof Iou_Split)) {
      return false;
    }
    Iou_Split other = (Iou_Split) object;
    return this.splitAmount.equals(other.splitAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.splitAmount);
  }

  @Override
  public String toString() {
    return String.format("com.daml.quickstart.model.iou.Iou_Split(%s)", this.splitAmount);
  }
}
