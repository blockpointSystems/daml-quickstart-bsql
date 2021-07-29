package com.daml.quickstart.model.da.random;

import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.Variant;
import java.lang.String;

public abstract class Minstd {
  public static final String _packageId = "9cb44fe82cfef2b2e7d6de4a5ebbeb7cfdc208fc7a15d48095ae4a12d1a53cda";

  public Minstd() {
  }

  public abstract Value toValue();

  public static Minstd fromValue(Value value$) {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected Variant to build an instance of the Variant com.daml.quickstart.model.da.random.Minstd"));
    if ("Minstd".equals(variant$.getConstructor())) {
      return com.daml.quickstart.model.da.random.minstd.Minstd.fromValue(variant$);
    }
    throw new IllegalArgumentException("Found unknown constructor variant$.getConstructor() for variant com.daml.quickstart.model.da.random.Minstd, expected one of [Minstd]");
  }
}
