package com.daml.quickstart.model.da.generics;

import com.daml.ledger.javaapi.data.DamlEnum;
import com.daml.ledger.javaapi.data.Value;
import java.lang.IllegalArgumentException;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;

public enum SourceUnpackedness {
  NOSOURCEUNPACKEDNESS,

  SOURCENOUNPACK,

  SOURCEUNPACK;

  private static final DamlEnum[] __values$ = {new DamlEnum("NoSourceUnpackedness"), new DamlEnum("SourceNoUnpack"), new DamlEnum("SourceUnpack")};

  private static final Map<String, SourceUnpackedness> __enums$ = SourceUnpackedness.__buildEnumsMap$();

  private static final Map<String, SourceUnpackedness> __buildEnumsMap$() {
    Map<String, SourceUnpackedness> m = new HashMap<String, SourceUnpackedness>();
    m.put("NoSourceUnpackedness", NOSOURCEUNPACKEDNESS);
    m.put("SourceNoUnpack", SOURCENOUNPACK);
    m.put("SourceUnpack", SOURCEUNPACK);
    return m;
  }

  public static final SourceUnpackedness fromValue(Value value$) {
    String constructor$ = value$.asEnum().orElseThrow(() -> new IllegalArgumentException("Expected DamlEnum to build an instance of the Enum SourceUnpackedness")).getConstructor();
    if (!SourceUnpackedness.__enums$.containsKey(constructor$)) throw new IllegalArgumentException("Expected a DamlEnum with SourceUnpackedness constructor, found " + constructor$);
    return (SourceUnpackedness) SourceUnpackedness.__enums$.get(constructor$);
  }

  public final DamlEnum toValue() {
    return SourceUnpackedness.__values$[ordinal()];
  }
}
