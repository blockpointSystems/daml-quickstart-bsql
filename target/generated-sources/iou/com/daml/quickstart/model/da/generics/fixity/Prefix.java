package com.daml.quickstart.model.da.generics.fixity;

import com.daml.ledger.javaapi.data.Unit;
import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.Variant;
import com.daml.quickstart.model.da.generics.Fixity;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

public class Prefix extends Fixity {
  public static final String _packageId = "9cb44fe82cfef2b2e7d6de4a5ebbeb7cfdc208fc7a15d48095ae4a12d1a53cda";

  public final Unit unitValue;

  public Prefix(Unit unitValue) {
    this.unitValue = unitValue;
  }

  public Variant toValue() {
    return new Variant("Prefix", Unit.getInstance());
  }

  public static Prefix fromValue(Value value$) throws IllegalArgumentException {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected: Variant. Actual: " + value$.getClass().getName()));
    if (!"Prefix".equals(variant$.getConstructor())) throw new IllegalArgumentException("Invalid constructor. Expected: Prefix. Actual: " + variant$.getConstructor());
    Value variantValue$ = variant$.getValue();
    Unit body = variantValue$.asUnit().orElseThrow(() -> new IllegalArgumentException("Expected body to be of type com.daml.ledger.javaapi.data.Unit"));
    return new Prefix(body);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof Prefix)) {
      return false;
    }
    Prefix other = (Prefix) object;
    return this.unitValue.equals(other.unitValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.unitValue);
  }

  @Override
  public String toString() {
    return String.format("Prefix(%s)", this.unitValue);
  }
}
