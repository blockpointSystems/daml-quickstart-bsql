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

public class Tuple19<t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19> {
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

  public final t11 _11;

  public final t12 _12;

  public final t13 _13;

  public final t14 _14;

  public final t15 _15;

  public final t16 _16;

  public final t17 _17;

  public final t18 _18;

  public final t19 _19;

  public Tuple19(t1 _1, t2 _2, t3 _3, t4 _4, t5 _5, t6 _6, t7 _7, t8 _8, t9 _9, t10 _10, t11 _11,
      t12 _12, t13 _13, t14 _14, t15 _15, t16 _16, t17 _17, t18 _18, t19 _19) {
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
    this._11 = _11;
    this._12 = _12;
    this._13 = _13;
    this._14 = _14;
    this._15 = _15;
    this._16 = _16;
    this._17 = _17;
    this._18 = _18;
    this._19 = _19;
  }

  public static <t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19> Tuple19<t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19> fromValue(
      Value value$, Function<Value, t1> fromValuet1, Function<Value, t2> fromValuet2,
      Function<Value, t3> fromValuet3, Function<Value, t4> fromValuet4,
      Function<Value, t5> fromValuet5, Function<Value, t6> fromValuet6,
      Function<Value, t7> fromValuet7, Function<Value, t8> fromValuet8,
      Function<Value, t9> fromValuet9, Function<Value, t10> fromValuet10,
      Function<Value, t11> fromValuet11, Function<Value, t12> fromValuet12,
      Function<Value, t13> fromValuet13, Function<Value, t14> fromValuet14,
      Function<Value, t15> fromValuet15, Function<Value, t16> fromValuet16,
      Function<Value, t17> fromValuet17, Function<Value, t18> fromValuet18,
      Function<Value, t19> fromValuet19) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 19) {
      throw new IllegalArgumentException("Expected 19 arguments, got " + numberOfFields);
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
    t11 _11 = fromValuet11.apply(fields$.get(10).getValue());
    t12 _12 = fromValuet12.apply(fields$.get(11).getValue());
    t13 _13 = fromValuet13.apply(fields$.get(12).getValue());
    t14 _14 = fromValuet14.apply(fields$.get(13).getValue());
    t15 _15 = fromValuet15.apply(fields$.get(14).getValue());
    t16 _16 = fromValuet16.apply(fields$.get(15).getValue());
    t17 _17 = fromValuet17.apply(fields$.get(16).getValue());
    t18 _18 = fromValuet18.apply(fields$.get(17).getValue());
    t19 _19 = fromValuet19.apply(fields$.get(18).getValue());
    return new com.daml.quickstart.model.da.types.Tuple19<t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19>(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18, _19);
  }

  public Record toValue(Function<t1, Value> toValuet1, Function<t2, Value> toValuet2,
      Function<t3, Value> toValuet3, Function<t4, Value> toValuet4, Function<t5, Value> toValuet5,
      Function<t6, Value> toValuet6, Function<t7, Value> toValuet7, Function<t8, Value> toValuet8,
      Function<t9, Value> toValuet9, Function<t10, Value> toValuet10,
      Function<t11, Value> toValuet11, Function<t12, Value> toValuet12,
      Function<t13, Value> toValuet13, Function<t14, Value> toValuet14,
      Function<t15, Value> toValuet15, Function<t16, Value> toValuet16,
      Function<t17, Value> toValuet17, Function<t18, Value> toValuet18,
      Function<t19, Value> toValuet19) {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(19);
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
    fields.add(new Record.Field("_11", toValuet11.apply(this._11)));
    fields.add(new Record.Field("_12", toValuet12.apply(this._12)));
    fields.add(new Record.Field("_13", toValuet13.apply(this._13)));
    fields.add(new Record.Field("_14", toValuet14.apply(this._14)));
    fields.add(new Record.Field("_15", toValuet15.apply(this._15)));
    fields.add(new Record.Field("_16", toValuet16.apply(this._16)));
    fields.add(new Record.Field("_17", toValuet17.apply(this._17)));
    fields.add(new Record.Field("_18", toValuet18.apply(this._18)));
    fields.add(new Record.Field("_19", toValuet19.apply(this._19)));
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
    if (!(object instanceof Tuple19<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?>)) {
      return false;
    }
    Tuple19<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> other = (Tuple19<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?>) object;
    return this._1.equals(other._1) && this._2.equals(other._2) && this._3.equals(other._3) && this._4.equals(other._4) && this._5.equals(other._5) && this._6.equals(other._6) && this._7.equals(other._7) && this._8.equals(other._8) && this._9.equals(other._9) && this._10.equals(other._10) && this._11.equals(other._11) && this._12.equals(other._12) && this._13.equals(other._13) && this._14.equals(other._14) && this._15.equals(other._15) && this._16.equals(other._16) && this._17.equals(other._17) && this._18.equals(other._18) && this._19.equals(other._19);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this._1, this._2, this._3, this._4, this._5, this._6, this._7, this._8, this._9, this._10, this._11, this._12, this._13, this._14, this._15, this._16, this._17, this._18, this._19);
  }

  @Override
  public String toString() {
    return String.format("com.daml.quickstart.model.da.types.Tuple19(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)", this._1, this._2, this._3, this._4, this._5, this._6, this._7, this._8, this._9, this._10, this._11, this._12, this._13, this._14, this._15, this._16, this._17, this._18, this._19);
  }
}
