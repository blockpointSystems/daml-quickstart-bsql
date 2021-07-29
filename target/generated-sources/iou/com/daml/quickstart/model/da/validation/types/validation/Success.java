package com.daml.quickstart.model.da.validation.types.validation;

import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.Variant;
import com.daml.quickstart.model.da.validation.types.Validation;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.function.Function;

public class Success<errs, a> extends Validation<errs, a> {
  public static final String _packageId = "99a2705ed38c1c26cbb8fe7acf36bbf626668e167a33335de932599219e0a235";

  public final a aValue;

  public Success(a aValue) {
    this.aValue = aValue;
  }

  public Variant toValue(Function<a, Value> toValuea) {
    return new Variant("Success", toValuea.apply(this.aValue));
  }

  public static <errs, a> Success<errs, a> fromValue(Value value$, Function<Value, a> fromValuea)
      throws IllegalArgumentException {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected: Variant. Actual: " + value$.getClass().getName()));
    if (!"Success".equals(variant$.getConstructor())) throw new IllegalArgumentException("Invalid constructor. Expected: Success. Actual: " + variant$.getConstructor());
    Value variantValue$ = variant$.getValue();
    a body = fromValuea.apply(variantValue$);
    return new Success<errs, a>(body);
  }

  public Variant toValue(Function<errs, Value> toValueerrs, Function<a, Value> toValuea) {
    return new Variant("Success", toValuea.apply(this.aValue));
  }

  public static <errs, a> Success<errs, a> fromValue(Value value$,
      Function<Value, errs> fromValueerrs, Function<Value, a> fromValuea) throws
      IllegalArgumentException {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected: Variant. Actual: " + value$.getClass().getName()));
    if (!"Success".equals(variant$.getConstructor())) throw new IllegalArgumentException("Invalid constructor. Expected: Success. Actual: " + variant$.getConstructor());
    Value variantValue$ = variant$.getValue();
    a body = fromValuea.apply(variantValue$);
    return new Success<errs, a>(body);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof Success<?, ?>)) {
      return false;
    }
    Success<?, ?> other = (Success<?, ?>) object;
    return this.aValue.equals(other.aValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.aValue);
  }

  @Override
  public String toString() {
    return String.format("Success(%s)", this.aValue);
  }
}
