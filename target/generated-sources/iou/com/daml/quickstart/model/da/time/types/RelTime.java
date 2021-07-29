package com.daml.quickstart.model.da.time.types;

import com.daml.ledger.javaapi.data.Int64;
import com.daml.ledger.javaapi.data.Record;
import com.daml.ledger.javaapi.data.Value;
import java.lang.IllegalArgumentException;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RelTime {
  public static final String _packageId = "733e38d36a2759688a4b2c4cec69d48e7b55ecc8dedc8067b815926c917a182a";

  public final Long microseconds;

  public RelTime(Long microseconds) {
    this.microseconds = microseconds;
  }

  public static RelTime fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 1) {
      throw new IllegalArgumentException("Expected 1 arguments, got " + numberOfFields);
    }
    Long microseconds = fields$.get(0).getValue().asInt64().orElseThrow(() -> new IllegalArgumentException("Expected microseconds to be of type com.daml.ledger.javaapi.data.Int64")).getValue();
    return new com.daml.quickstart.model.da.time.types.RelTime(microseconds);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(1);
    fields.add(new Record.Field("microseconds", new Int64(this.microseconds)));
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
    if (!(object instanceof RelTime)) {
      return false;
    }
    RelTime other = (RelTime) object;
    return this.microseconds.equals(other.microseconds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.microseconds);
  }

  @Override
  public String toString() {
    return String.format("com.daml.quickstart.model.da.time.types.RelTime(%s)", this.microseconds);
  }
}
