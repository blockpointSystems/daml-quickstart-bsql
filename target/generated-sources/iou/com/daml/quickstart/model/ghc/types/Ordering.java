package com.daml.quickstart.model.ghc.types;

import com.daml.ledger.javaapi.data.DamlEnum;
import com.daml.ledger.javaapi.data.Value;
import java.lang.IllegalArgumentException;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;

public enum Ordering {
  LT,

  EQ,

  GT;

  private static final DamlEnum[] __values$ = {new DamlEnum("LT"), new DamlEnum("EQ"), new DamlEnum("GT")};

  private static final Map<String, Ordering> __enums$ = Ordering.__buildEnumsMap$();

  private static final Map<String, Ordering> __buildEnumsMap$() {
    Map<String, Ordering> m = new HashMap<String, Ordering>();
    m.put("LT", LT);
    m.put("EQ", EQ);
    m.put("GT", GT);
    return m;
  }

  public static final Ordering fromValue(Value value$) {
    String constructor$ = value$.asEnum().orElseThrow(() -> new IllegalArgumentException("Expected DamlEnum to build an instance of the Enum Ordering")).getConstructor();
    if (!Ordering.__enums$.containsKey(constructor$)) throw new IllegalArgumentException("Expected a DamlEnum with Ordering constructor, found " + constructor$);
    return (Ordering) Ordering.__enums$.get(constructor$);
  }

  public final DamlEnum toValue() {
    return Ordering.__values$[ordinal()];
  }
}
