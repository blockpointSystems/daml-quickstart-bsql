package com.daml.quickstart.model.da.generics;

import com.daml.ledger.javaapi.data.DamlEnum;
import com.daml.ledger.javaapi.data.Value;
import java.lang.IllegalArgumentException;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;

public enum SourceStrictness {
  NOSOURCESTRICTNESS,

  SOURCELAZY,

  SOURCESTRICT;

  private static final DamlEnum[] __values$ = {new DamlEnum("NoSourceStrictness"), new DamlEnum("SourceLazy"), new DamlEnum("SourceStrict")};

  private static final Map<String, SourceStrictness> __enums$ = SourceStrictness.__buildEnumsMap$();

  private static final Map<String, SourceStrictness> __buildEnumsMap$() {
    Map<String, SourceStrictness> m = new HashMap<String, SourceStrictness>();
    m.put("NoSourceStrictness", NOSOURCESTRICTNESS);
    m.put("SourceLazy", SOURCELAZY);
    m.put("SourceStrict", SOURCESTRICT);
    return m;
  }

  public static final SourceStrictness fromValue(Value value$) {
    String constructor$ = value$.asEnum().orElseThrow(() -> new IllegalArgumentException("Expected DamlEnum to build an instance of the Enum SourceStrictness")).getConstructor();
    if (!SourceStrictness.__enums$.containsKey(constructor$)) throw new IllegalArgumentException("Expected a DamlEnum with SourceStrictness constructor, found " + constructor$);
    return (SourceStrictness) SourceStrictness.__enums$.get(constructor$);
  }

  public final DamlEnum toValue() {
    return SourceStrictness.__values$[ordinal()];
  }
}
