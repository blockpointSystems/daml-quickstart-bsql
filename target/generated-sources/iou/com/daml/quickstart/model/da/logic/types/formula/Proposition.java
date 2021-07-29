package com.daml.quickstart.model.da.logic.types.formula;

import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.Variant;
import com.daml.quickstart.model.da.logic.types.Formula;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.function.Function;

public class Proposition<a> extends Formula<a> {
  public static final String _packageId = "c1f1f00558799eec139fb4f4c76f95fb52fa1837a5dd29600baa1c8ed1bdccfd";

  public final a aValue;

  public Proposition(a aValue) {
    this.aValue = aValue;
  }

  public Variant toValue(Function<a, Value> toValuea) {
    return new Variant("Proposition", toValuea.apply(this.aValue));
  }

  public static <a> Proposition<a> fromValue(Value value$, Function<Value, a> fromValuea) throws
      IllegalArgumentException {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected: Variant. Actual: " + value$.getClass().getName()));
    if (!"Proposition".equals(variant$.getConstructor())) throw new IllegalArgumentException("Invalid constructor. Expected: Proposition. Actual: " + variant$.getConstructor());
    Value variantValue$ = variant$.getValue();
    a body = fromValuea.apply(variantValue$);
    return new Proposition<a>(body);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof Proposition<?>)) {
      return false;
    }
    Proposition<?> other = (Proposition<?>) object;
    return this.aValue.equals(other.aValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.aValue);
  }

  @Override
  public String toString() {
    return String.format("Proposition(%s)", this.aValue);
  }
}
