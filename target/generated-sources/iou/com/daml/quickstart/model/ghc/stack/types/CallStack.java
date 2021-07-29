package com.daml.quickstart.model.ghc.stack.types;

import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.Variant;
import java.lang.String;

public abstract class CallStack {
  public static final String _packageId = "d59f3145f3b2f6eb8a70001f630d9bdaeab79e45b8d5fd462a1ac9d30223aeb6";

  public CallStack() {
  }

  public abstract Value toValue();

  public static CallStack fromValue(Value value$) {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected Variant to build an instance of the Variant com.daml.quickstart.model.ghc.stack.types.CallStack"));
    if ("EmptyCallStack".equals(variant$.getConstructor())) {
      return com.daml.quickstart.model.ghc.stack.types.callstack.EmptyCallStack.fromValue(variant$);
    }
    if ("PushCallStack".equals(variant$.getConstructor())) {
      return com.daml.quickstart.model.ghc.stack.types.callstack.PushCallStack.fromValue(variant$);
    }
    if ("FreezeCallStack".equals(variant$.getConstructor())) {
      return com.daml.quickstart.model.ghc.stack.types.callstack.FreezeCallStack.fromValue(variant$);
    }
    throw new IllegalArgumentException("Found unknown constructor variant$.getConstructor() for variant com.daml.quickstart.model.ghc.stack.types.CallStack, expected one of [EmptyCallStack, PushCallStack, FreezeCallStack]");
  }
}
