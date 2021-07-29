package com.daml.quickstart.model.da.validation.types.validation;

import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.Variant;
import com.daml.quickstart.model.da.nonempty.types.NonEmpty;
import com.daml.quickstart.model.da.validation.types.Validation;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.function.Function;

public class Errors<errs, a> extends Validation<errs, a> {
  public static final String _packageId = "99a2705ed38c1c26cbb8fe7acf36bbf626668e167a33335de932599219e0a235";

  public final NonEmpty<errs> nonEmptyValue;

  public Errors(NonEmpty<errs> nonEmptyValue) {
    this.nonEmptyValue = nonEmptyValue;
  }

  public Variant toValue(Function<errs, Value> toValueerrs) {
    return new Variant("Errors", this.nonEmptyValue.toValue(v$0 -> toValueerrs.apply(v$0)));
  }

  public static <errs, a> Errors<errs, a> fromValue(Value value$,
      Function<Value, errs> fromValueerrs) throws IllegalArgumentException {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected: Variant. Actual: " + value$.getClass().getName()));
    if (!"Errors".equals(variant$.getConstructor())) throw new IllegalArgumentException("Invalid constructor. Expected: Errors. Actual: " + variant$.getConstructor());
    Value variantValue$ = variant$.getValue();
    NonEmpty<errs> body = NonEmpty.<errs>fromValue(variantValue$, v$0 -> fromValueerrs.apply(v$0));
    return new Errors<errs, a>(body);
  }

  public Variant toValue(Function<errs, Value> toValueerrs, Function<a, Value> toValuea) {
    return new Variant("Errors", this.nonEmptyValue.toValue(v$0 -> toValueerrs.apply(v$0)));
  }

  public static <errs, a> Errors<errs, a> fromValue(Value value$,
      Function<Value, errs> fromValueerrs, Function<Value, a> fromValuea) throws
      IllegalArgumentException {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected: Variant. Actual: " + value$.getClass().getName()));
    if (!"Errors".equals(variant$.getConstructor())) throw new IllegalArgumentException("Invalid constructor. Expected: Errors. Actual: " + variant$.getConstructor());
    Value variantValue$ = variant$.getValue();
    NonEmpty<errs> body = NonEmpty.<errs>fromValue(variantValue$, v$0 -> fromValueerrs.apply(v$0));
    return new Errors<errs, a>(body);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof Errors<?, ?>)) {
      return false;
    }
    Errors<?, ?> other = (Errors<?, ?>) object;
    return this.nonEmptyValue.equals(other.nonEmptyValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.nonEmptyValue);
  }

  @Override
  public String toString() {
    return String.format("Errors(%s)", this.nonEmptyValue);
  }
}
