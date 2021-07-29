package com.daml.quickstart.model.da.date.types;

import com.daml.ledger.javaapi.data.DamlEnum;
import com.daml.ledger.javaapi.data.Value;
import java.lang.IllegalArgumentException;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;

public enum Month {
  JAN,

  FEB,

  MAR,

  APR,

  MAY,

  JUN,

  JUL,

  AUG,

  SEP,

  OCT,

  NOV,

  DEC;

  private static final DamlEnum[] __values$ = {new DamlEnum("Jan"), new DamlEnum("Feb"), new DamlEnum("Mar"), new DamlEnum("Apr"), new DamlEnum("May"), new DamlEnum("Jun"), new DamlEnum("Jul"), new DamlEnum("Aug"), new DamlEnum("Sep"), new DamlEnum("Oct"), new DamlEnum("Nov"), new DamlEnum("Dec")};

  private static final Map<String, Month> __enums$ = Month.__buildEnumsMap$();

  private static final Map<String, Month> __buildEnumsMap$() {
    Map<String, Month> m = new HashMap<String, Month>();
    m.put("Jan", JAN);
    m.put("Feb", FEB);
    m.put("Mar", MAR);
    m.put("Apr", APR);
    m.put("May", MAY);
    m.put("Jun", JUN);
    m.put("Jul", JUL);
    m.put("Aug", AUG);
    m.put("Sep", SEP);
    m.put("Oct", OCT);
    m.put("Nov", NOV);
    m.put("Dec", DEC);
    return m;
  }

  public static final Month fromValue(Value value$) {
    String constructor$ = value$.asEnum().orElseThrow(() -> new IllegalArgumentException("Expected DamlEnum to build an instance of the Enum Month")).getConstructor();
    if (!Month.__enums$.containsKey(constructor$)) throw new IllegalArgumentException("Expected a DamlEnum with Month constructor, found " + constructor$);
    return (Month) Month.__enums$.get(constructor$);
  }

  public final DamlEnum toValue() {
    return Month.__values$[ordinal()];
  }
}
