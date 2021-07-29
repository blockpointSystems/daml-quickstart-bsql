package com.daml.quickstart.model.da.generics;

import com.daml.ledger.javaapi.data.DamlEnum;
import com.daml.ledger.javaapi.data.Value;
import java.lang.IllegalArgumentException;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;

public enum Associativity {
  LEFTASSOCIATIVE,

  RIGHTASSOCIATIVE,

  NOTASSOCIATIVE;

  private static final DamlEnum[] __values$ = {new DamlEnum("LeftAssociative"), new DamlEnum("RightAssociative"), new DamlEnum("NotAssociative")};

  private static final Map<String, Associativity> __enums$ = Associativity.__buildEnumsMap$();

  private static final Map<String, Associativity> __buildEnumsMap$() {
    Map<String, Associativity> m = new HashMap<String, Associativity>();
    m.put("LeftAssociative", LEFTASSOCIATIVE);
    m.put("RightAssociative", RIGHTASSOCIATIVE);
    m.put("NotAssociative", NOTASSOCIATIVE);
    return m;
  }

  public static final Associativity fromValue(Value value$) {
    String constructor$ = value$.asEnum().orElseThrow(() -> new IllegalArgumentException("Expected DamlEnum to build an instance of the Enum Associativity")).getConstructor();
    if (!Associativity.__enums$.containsKey(constructor$)) throw new IllegalArgumentException("Expected a DamlEnum with Associativity constructor, found " + constructor$);
    return (Associativity) Associativity.__enums$.get(constructor$);
  }

  public final DamlEnum toValue() {
    return Associativity.__values$[ordinal()];
  }
}
