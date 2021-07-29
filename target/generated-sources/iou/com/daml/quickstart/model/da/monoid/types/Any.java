package com.daml.quickstart.model.da.monoid.types;

import com.daml.ledger.javaapi.data.Bool;
import com.daml.ledger.javaapi.data.Record;
import com.daml.ledger.javaapi.data.Value;
import java.lang.Boolean;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Any {
  public static final String _packageId = "6c2c0667393c5f92f1885163068cd31800d2264eb088eb6fc740e11241b2bf06";

  public final Boolean getAny;

  public Any(Boolean getAny) {
    this.getAny = getAny;
  }

  public static Any fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 1) {
      throw new IllegalArgumentException("Expected 1 arguments, got " + numberOfFields);
    }
    Boolean getAny = fields$.get(0).getValue().asBool().orElseThrow(() -> new IllegalArgumentException("Expected getAny to be of type com.daml.ledger.javaapi.data.Bool")).getValue();
    return new com.daml.quickstart.model.da.monoid.types.Any(getAny);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(1);
    fields.add(new Record.Field("getAny", new Bool(this.getAny)));
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
    if (!(object instanceof Any)) {
      return false;
    }
    Any other = (Any) object;
    return this.getAny.equals(other.getAny);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getAny);
  }

  @Override
  public String toString() {
    return String.format("com.daml.quickstart.model.da.monoid.types.Any(%s)", this.getAny);
  }
}
