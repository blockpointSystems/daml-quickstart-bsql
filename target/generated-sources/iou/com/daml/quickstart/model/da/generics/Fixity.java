package com.daml.quickstart.model.da.generics;

import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.Variant;
import java.lang.String;

public abstract class Fixity {
  public static final String _packageId = "9cb44fe82cfef2b2e7d6de4a5ebbeb7cfdc208fc7a15d48095ae4a12d1a53cda";

  public Fixity() {
  }

  public abstract Value toValue();

  public static Fixity fromValue(Value value$) {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected Variant to build an instance of the Variant com.daml.quickstart.model.da.generics.Fixity"));
    if ("Prefix".equals(variant$.getConstructor())) {
      return com.daml.quickstart.model.da.generics.fixity.Prefix.fromValue(variant$);
    }
    if ("Infix".equals(variant$.getConstructor())) {
      return com.daml.quickstart.model.da.generics.fixity.Infix.fromValue(variant$);
    }
    throw new IllegalArgumentException("Found unknown constructor variant$.getConstructor() for variant com.daml.quickstart.model.da.generics.Fixity, expected one of [Prefix, Infix]");
  }
}
