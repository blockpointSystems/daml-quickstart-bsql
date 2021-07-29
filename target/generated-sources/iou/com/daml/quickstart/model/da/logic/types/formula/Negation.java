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

public class Negation<a> extends Formula<a> {
  public static final String _packageId = "c1f1f00558799eec139fb4f4c76f95fb52fa1837a5dd29600baa1c8ed1bdccfd";

  public final Formula<a> formulaValue;

  public Negation(Formula<a> formulaValue) {
    this.formulaValue = formulaValue;
  }

  public Variant toValue(Function<a, Value> toValuea) {
    return new Variant("Negation", this.formulaValue.toValue(v$0 -> toValuea.apply(v$0)));
  }

  public static <a> Negation<a> fromValue(Value value$, Function<Value, a> fromValuea) throws
      IllegalArgumentException {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected: Variant. Actual: " + value$.getClass().getName()));
    if (!"Negation".equals(variant$.getConstructor())) throw new IllegalArgumentException("Invalid constructor. Expected: Negation. Actual: " + variant$.getConstructor());
    Value variantValue$ = variant$.getValue();
    Formula<a> body = Formula.<a>fromValue(variantValue$, v$0 -> fromValuea.apply(v$0));
    return new Negation<a>(body);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof Negation<?>)) {
      return false;
    }
    Negation<?> other = (Negation<?>) object;
    return this.formulaValue.equals(other.formulaValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.formulaValue);
  }

  @Override
  public String toString() {
    return String.format("Negation(%s)", this.formulaValue);
  }
}
