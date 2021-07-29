package com.daml.quickstart.model.da.logic.types.formula;

import com.daml.ledger.javaapi.data.DamlCollectors;
import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.Variant;
import com.daml.quickstart.model.da.logic.types.Formula;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class Disjunction<a> extends Formula<a> {
  public static final String _packageId = "c1f1f00558799eec139fb4f4c76f95fb52fa1837a5dd29600baa1c8ed1bdccfd";

  public final List<Formula<a>> listValue;

  public Disjunction(List<Formula<a>> listValue) {
    this.listValue = listValue;
  }

  public Variant toValue(Function<a, Value> toValuea) {
    return new Variant("Disjunction", this.listValue.stream().collect(DamlCollectors.toDamlList(v$0 -> v$0.toValue(v$1 -> toValuea.apply(v$1)))));
  }

  public static <a> Disjunction<a> fromValue(Value value$, Function<Value, a> fromValuea) throws
      IllegalArgumentException {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected: Variant. Actual: " + value$.getClass().getName()));
    if (!"Disjunction".equals(variant$.getConstructor())) throw new IllegalArgumentException("Invalid constructor. Expected: Disjunction. Actual: " + variant$.getConstructor());
    Value variantValue$ = variant$.getValue();
    List<Formula<a>> body = variantValue$.asList()
            .map(v$0 -> v$0.toList(v$1 ->
                Formula.<a>fromValue(v$1, v$2 -> fromValuea.apply(v$2))
            ))
            .orElseThrow(() -> new IllegalArgumentException("Expected body to be of type com.daml.ledger.javaapi.data.DamlList"))
        ;
    return new Disjunction<a>(body);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof Disjunction<?>)) {
      return false;
    }
    Disjunction<?> other = (Disjunction<?>) object;
    return this.listValue.equals(other.listValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.listValue);
  }

  @Override
  public String toString() {
    return String.format("Disjunction(%s)", this.listValue);
  }
}
