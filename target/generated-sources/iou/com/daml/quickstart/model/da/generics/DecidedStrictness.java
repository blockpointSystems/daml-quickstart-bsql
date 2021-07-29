package com.daml.quickstart.model.da.generics;

import com.daml.ledger.javaapi.data.DamlEnum;
import com.daml.ledger.javaapi.data.Value;
import java.lang.IllegalArgumentException;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;

public enum DecidedStrictness {
  DECIDEDLAZY,

  DECIDEDSTRICT,

  DECIDEDUNPACK;

  private static final DamlEnum[] __values$ = {new DamlEnum("DecidedLazy"), new DamlEnum("DecidedStrict"), new DamlEnum("DecidedUnpack")};

  private static final Map<String, DecidedStrictness> __enums$ = DecidedStrictness.__buildEnumsMap$();

  private static final Map<String, DecidedStrictness> __buildEnumsMap$() {
    Map<String, DecidedStrictness> m = new HashMap<String, DecidedStrictness>();
    m.put("DecidedLazy", DECIDEDLAZY);
    m.put("DecidedStrict", DECIDEDSTRICT);
    m.put("DecidedUnpack", DECIDEDUNPACK);
    return m;
  }

  public static final DecidedStrictness fromValue(Value value$) {
    String constructor$ = value$.asEnum().orElseThrow(() -> new IllegalArgumentException("Expected DamlEnum to build an instance of the Enum DecidedStrictness")).getConstructor();
    if (!DecidedStrictness.__enums$.containsKey(constructor$)) throw new IllegalArgumentException("Expected a DamlEnum with DecidedStrictness constructor, found " + constructor$);
    return (DecidedStrictness) DecidedStrictness.__enums$.get(constructor$);
  }

  public final DamlEnum toValue() {
    return DecidedStrictness.__values$[ordinal()];
  }
}
