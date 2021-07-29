package com.daml.quickstart.model.da.validation.types;

import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.Variant;
import java.lang.String;
import java.util.function.Function;

public abstract class Validation<errs, a> {
  public static final String _packageId = "99a2705ed38c1c26cbb8fe7acf36bbf626668e167a33335de932599219e0a235";

  public Validation() {
  }

  public abstract Value toValue(Function<errs, Value> toValueerrs, Function<a, Value> toValuea);

  public static <errs, a> Validation<errs, a> fromValue(Value value$,
      Function<Value, errs> fromValueerrs, Function<Value, a> fromValuea) {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected Variant to build an instance of the Variant com.daml.quickstart.model.da.validation.types.Validation"));
    if ("Errors".equals(variant$.getConstructor())) {
      return com.daml.quickstart.model.da.validation.types.validation.Errors.fromValue(variant$, fromValueerrs, fromValuea);
    }
    if ("Success".equals(variant$.getConstructor())) {
      return com.daml.quickstart.model.da.validation.types.validation.Success.fromValue(variant$, fromValueerrs, fromValuea);
    }
    throw new IllegalArgumentException("Found unknown constructor variant$.getConstructor() for variant com.daml.quickstart.model.da.validation.types.Validation, expected one of [Errors, Success]");
  }
}
