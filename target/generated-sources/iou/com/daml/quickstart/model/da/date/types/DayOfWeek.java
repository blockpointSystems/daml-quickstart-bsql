package com.daml.quickstart.model.da.date.types;

import com.daml.ledger.javaapi.data.DamlEnum;
import com.daml.ledger.javaapi.data.Value;
import java.lang.IllegalArgumentException;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;

public enum DayOfWeek {
  MONDAY,

  TUESDAY,

  WEDNESDAY,

  THURSDAY,

  FRIDAY,

  SATURDAY,

  SUNDAY;

  private static final DamlEnum[] __values$ = {new DamlEnum("Monday"), new DamlEnum("Tuesday"), new DamlEnum("Wednesday"), new DamlEnum("Thursday"), new DamlEnum("Friday"), new DamlEnum("Saturday"), new DamlEnum("Sunday")};

  private static final Map<String, DayOfWeek> __enums$ = DayOfWeek.__buildEnumsMap$();

  private static final Map<String, DayOfWeek> __buildEnumsMap$() {
    Map<String, DayOfWeek> m = new HashMap<String, DayOfWeek>();
    m.put("Monday", MONDAY);
    m.put("Tuesday", TUESDAY);
    m.put("Wednesday", WEDNESDAY);
    m.put("Thursday", THURSDAY);
    m.put("Friday", FRIDAY);
    m.put("Saturday", SATURDAY);
    m.put("Sunday", SUNDAY);
    return m;
  }

  public static final DayOfWeek fromValue(Value value$) {
    String constructor$ = value$.asEnum().orElseThrow(() -> new IllegalArgumentException("Expected DamlEnum to build an instance of the Enum DayOfWeek")).getConstructor();
    if (!DayOfWeek.__enums$.containsKey(constructor$)) throw new IllegalArgumentException("Expected a DamlEnum with DayOfWeek constructor, found " + constructor$);
    return (DayOfWeek) DayOfWeek.__enums$.get(constructor$);
  }

  public final DamlEnum toValue() {
    return DayOfWeek.__values$[ordinal()];
  }
}
