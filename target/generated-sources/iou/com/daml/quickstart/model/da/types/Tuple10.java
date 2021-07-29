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

public class Tuple10<t1, t2, t3, t4, t5, t6, t7, t8, t9, t10> {
  public static final String _packageId = "40f452260bef3f29dede136108fc08a88d5a5250310281067087da6f0baddff7";

  public final t1 _1;

  public final t2 _2;

  public final t3 _3;

  public final t4 _4;

  public final t5 _5;

  public final t6 _6;

  public final t7 _7;

  public final t8 _8;

  public final t9 _9;

  public final t10 _10;

  public Tuple10(t1 _1, t2 _2, t3 _3, t4 _4, t5 _5, t6 _6, t7 _7, t8 _8, t9 _9, t10 _10) {
    this._1 = _1;
    this._2 = _2;
    this._3 = _3;
    this._4 = _4;
    this._5 = _5;
    this._6 = _6;
    this._7 = _7;
    this._8 = _8;
    this._9 = _9;
    this._10 = _10;
  }

  public static <t1, t2, t3, t4, t5, t6, t7, t8, t9, t10> Tuple10<t1, t2, t3, t4, t5, t6, t7, t8, t9, t10> fromValue(
      Value value$, Function<Value, t1> fromValuet1, Function<Value, t2> fromValuet2,
      Function<Value, t3> fromValuet3, Function<Value, t4> fromValuet4,
      Function<Value, t5> fromValuet5, Function<Value, t6> fromValuet6,
      Function<Value, t7> fromValuet7, Function<Value, t8> fromValuet8,
      Function<Value, t9> fromValuet9, Function<Value, t10> fromValuet10) throws
      IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 10) {
      throw new IllegalArgumentException("Expected 10 arguments, got " + numberOfFields);
    }
    t1 _1 = fromValuet1.apply(fields$.get(0).getValue());
    t2 _2 = fromValuet2.apply(fields$.get(1).getValue());
    t3 _3 = fromValuet3.apply(fields$.get(2).getValue());
    t4 _4 = fromValuet4.apply(fields$.get(3).getValue());
    t5 _5 = fromValuet5.apply(fields$.get(4).getValue());
    t6 _6 = fromValuet6.apply(fields$.get(5).getValue());
    t7 _7 = fromValuet7.apply(fields$.get(6).getValue());
    t8 _8 = fromValuet8.apply(fields$.get(7).getValue());
    t9 _9 = fromValuet9.apply(fields$.get(8).getValue());
    t10 _10 = fromValuet10.apply(fields$.get(9).getValue());
    return new com.daml.quickstart.model.da.types.Tuple10<t1, t2, t3, t4, t5, t6, t7, t8, t9, t10>(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10);
  }

  public Record toValue(Function<t1, Value> toValuet1, Function<t2, Value> toValuet2,
      Function<t3, Value> toValuet3, Function<t4, Value> toValuet4, Function<t5, Value> toValuet5,
      Function<t6, Value> toValuet6, Function<t7, Value> toValuet7, Function<t8, Value> toValuet8,
      Function<t9, Value> toValuet9, Function<t10, Value> toValuet10) {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(10);
    fields.add(new Record.Field("_1", toValuet1.apply(this._1)));
    fields.add(new Record.Field("_2", toValuet2.apply(this._2)));
    fields.add(new Record.Field("_3", toValuet3.apply(this._3)));
    fields.add(new Record.Field("_4", toValuet4.apply(this._4)));
    fields.add(new Record.Field("_5", toValuet5.apply(this._5)));
    fields.add(new Record.Field("_6", toValuet6.apply(this._6)));
    fields.add(new Record.Field("_7", toValuet7.apply(this._7)));
    fields.add(new Record.Field("_8", toValuet8.apply(this._8)));
    fields.add(new Record.Field("_9", toValuet9.apply(this._9)));
    fields.add(new Record.Field("_10", toValuet10.apply(this._10)));
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
    if (!(object instanceof Tuple10<?, ?, ?, ?, ?, ?, ?, ?, ?, ?>)) {
      return false;
    }
    Tuple10<?, ?, ?, ?, ?, ?, ?, ?, ?, ?> other = (Tuple10<?, ?, ?, ?, ?, ?, ?, ?, ?, ?>) object;
    return this._1.equals(other._1) && this._2.equals(other._2) && this._3.equals(other._3) && this._4.equals(other._4) && this._5.equals(other._5) && this._6.equals(other._6) && this._7.equals(other._7) && this._8.equals(other._8) && this._9.equals(other._9) && this._10.equals(other._10);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this._1, this._2, this._3, this._4, this._5, this._6, this._7, this._8, this._9, this._10);
  }

  @Override
  public String toString() {
    return String.format("com.daml.quickstart.model.da.types.Tuple10(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s)", this._1, this._2, this._3, this._4, this._5, this._6, this._7, this._8, this._9, this._10);
  }
}
