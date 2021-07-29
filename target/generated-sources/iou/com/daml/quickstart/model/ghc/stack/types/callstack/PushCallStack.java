package com.daml.quickstart.model.ghc.stack.types.callstack;

import com.daml.ledger.javaapi.data.Text;
import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.Variant;
import com.daml.quickstart.model.da.types.Tuple3;
import com.daml.quickstart.model.ghc.stack.types.CallStack;
import com.daml.quickstart.model.ghc.stack.types.SrcLoc;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

public class PushCallStack extends CallStack {
  public static final String _packageId = "d59f3145f3b2f6eb8a70001f630d9bdaeab79e45b8d5fd462a1ac9d30223aeb6";

  public final Tuple3<String, SrcLoc, CallStack> tuple3Value;

  public PushCallStack(Tuple3<String, SrcLoc, CallStack> tuple3Value) {
    this.tuple3Value = tuple3Value;
  }

  public Variant toValue() {
    return new Variant("PushCallStack", this.tuple3Value.toValue(v$0 -> new Text(v$0),v$1 -> v$1.toValue(),v$2 -> v$2.toValue()));
  }

  public static PushCallStack fromValue(Value value$) throws IllegalArgumentException {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected: Variant. Actual: " + value$.getClass().getName()));
    if (!"PushCallStack".equals(variant$.getConstructor())) throw new IllegalArgumentException("Invalid constructor. Expected: PushCallStack. Actual: " + variant$.getConstructor());
    Value variantValue$ = variant$.getValue();
    Tuple3<String, SrcLoc, CallStack> body = Tuple3.<java.lang.String, com.daml.quickstart.model.ghc.stack.types.SrcLoc, com.daml.quickstart.model.ghc.stack.types.CallStack>fromValue(variantValue$, v$0 -> v$0.asText().orElseThrow(() -> new IllegalArgumentException("Expected body to be of type com.daml.ledger.javaapi.data.Text")).getValue(), v$1 -> SrcLoc.fromValue(v$1), v$2 -> CallStack.fromValue(v$2));
    return new PushCallStack(body);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof PushCallStack)) {
      return false;
    }
    PushCallStack other = (PushCallStack) object;
    return this.tuple3Value.equals(other.tuple3Value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.tuple3Value);
  }

  @Override
  public String toString() {
    return String.format("PushCallStack(%s)", this.tuple3Value);
  }
}
