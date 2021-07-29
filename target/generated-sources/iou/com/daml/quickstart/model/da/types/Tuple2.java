package com.daml.quickstart.model.da.types;

import com.daml.ledger.javaapi.data.Record;
import com.daml.ledger.javaapi.data.Value;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class Tuple2<t1, t2> {
  public static final String _packageId = "40f452260bef3f29dede136108fc08a88d5a5250310281067087da6f0baddff7";

  public final t1 _1;

  public final t2 _2;

  public Tuple2(t1 _1, t2 _2) {
    this._1 = _1;
    this._2 = _2;
  }

  public static <t1, t2> Tuple2<t1, t2> fromValue(Value value$, Function<Value, t1> fromValuet1,
      Function<Value, t2> fromValuet2) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 2) {
      throw new IllegalArgumentException("Expected 2 arguments, got " + numberOfFields);
    }
    t1 _1 = fromValuet1.apply(fields$.get(0).getValue());
    t2 _2 = fromValuet2.apply(fields$.get(1).getValue());
    return new com.daml.quickstart.model.da.types.Tuple2<t1, t2>(_1, _2);
  }

  public Record toValue(Function<t1, Value> toValuet1, Function<t2, Value> toValuet2) {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(2);
    fields.add(new Record.Field("_1", toValuet1.apply(this._1)));
    fields.add(new Record.Field("_2", toValuet2.apply(this._2)));
    return new Record(fields);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof Tuple2<?, ?>)) {
      return false;
    }
    Tuple2<?, ?> other = (Tuple2<?, ?>) object;
    return this._1.equals(other._1) && this._2.equals(other._2);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this._1, this._2);
  }

  @Override
  public String toString() {
    return String.format("com.daml.quickstart.model.da.types.Tuple2(%s, %s)", this._1, this._2);
  }
}
