package com.daml.quickstart.model.da.logic.types;

import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.Variant;
import java.lang.String;
import java.util.function.Function;

public abstract class Formula<a> {
  public static final String _packageId = "c1f1f00558799eec139fb4f4c76f95fb52fa1837a5dd29600baa1c8ed1bdccfd";

  public Formula() {
  }

  public abstract Value toValue(Function<a, Value> toValuea);

  public static <a> Formula<a> fromValue(Value value$, Function<Value, a> fromValuea) {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected Variant to build an instance of the Variant com.daml.quickstart.model.da.logic.types.Formula"));
    if ("Proposition".equals(variant$.getConstructor())) {
      return com.daml.quickstart.model.da.logic.types.formula.Proposition.fromValue(variant$, fromValuea);
    }
    if ("Negation".equals(variant$.getConstructor())) {
      return com.daml.quickstart.model.da.logic.types.formula.Negation.fromValue(variant$, fromValuea);
    }
    if ("Conjunction".equals(variant$.getConstructor())) {
      return com.daml.quickstart.model.da.logic.types.formula.Conjunction.fromValue(variant$, fromValuea);
    }
    if ("Disjunction".equals(variant$.getConstructor())) {
      return com.daml.quickstart.model.da.logic.types.formula.Disjunction.fromValue(variant$, fromValuea);
    }
    throw new IllegalArgumentException("Found unknown constructor variant$.getConstructor() for variant com.daml.quickstart.model.da.logic.types.Formula, expected one of [Proposition, Negation, Conjunction, Disjunction]");
  }
}
