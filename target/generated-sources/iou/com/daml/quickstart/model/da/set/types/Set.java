package com.daml.quickstart.model.da.set.types;

import com.daml.ledger.javaapi.data.DamlCollectors;
import com.daml.ledger.javaapi.data.Record;
import com.daml.ledger.javaapi.data.Unit;
import com.daml.ledger.javaapi.data.Value;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public class Set<k> {
  public static final String _packageId = "97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657";

  public final Map<k, Unit> map;

  public Set(Map<k, Unit> map) {
    this.map = map;
  }

  public static <k> Set<k> fromValue(Value value$, Function<Value, k> fromValuek) throws
      IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 1) {
      throw new IllegalArgumentException("Expected 1 arguments, got " + numberOfFields);
    }
    Map<k, Unit> map = fields$.get(0).getValue().asGenMap()
            .map(v$0 -> v$0.toMap(
                v$1 -> fromValuek.apply(v$1),
                v$1 -> v$1.asUnit().orElseThrow(() -> new IllegalArgumentException("Expected v$1 to be of type com.daml.ledger.javaapi.data.Unit"))
            ))
            .orElseThrow(() -> new IllegalArgumentException("Expected map to be of type com.daml.ledger.javaapi.data.DamlGenMap"))
                  ;
    return new com.daml.quickstart.model.da.set.types.Set<k>(map);
  }

  public Record toValue(Function<k, Value> toValuek) {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(1);
    fields.add(new Record.Field("map", this.map.entrySet().stream().collect(DamlCollectors.toDamlGenMap(v$0 -> toValuek.apply(v$0.getKey()), v$0 -> Unit.getInstance()))));
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
    if (!(object instanceof Set<?>)) {
      return false;
    }
    Set<?> other = (Set<?>) object;
    return this.map.equals(other.map);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.map);
  }

  @Override
  public String toString() {
    return String.format("com.daml.quickstart.model.da.set.types.Set(%s)", this.map);
  }
}
