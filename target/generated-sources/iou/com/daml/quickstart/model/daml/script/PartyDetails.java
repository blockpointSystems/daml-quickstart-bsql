package com.daml.quickstart.model.daml.script;

import com.daml.ledger.javaapi.data.Bool;
import com.daml.ledger.javaapi.data.DamlOptional;
import com.daml.ledger.javaapi.data.Party;
import com.daml.ledger.javaapi.data.Record;
import com.daml.ledger.javaapi.data.Text;
import com.daml.ledger.javaapi.data.Value;
import java.lang.Boolean;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class PartyDetails {
  public static final String _packageId = "45b6aee043e63005ac98479d269e0259be3c3f223c2382189401cd3a948b5ad2";

  public final String party;

  public final Optional<String> displayName;

  public final Boolean isLocal;

  public PartyDetails(String party, Optional<String> displayName, Boolean isLocal) {
    this.party = party;
    this.displayName = displayName;
    this.isLocal = isLocal;
  }

  public static PartyDetails fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 3) {
      throw new IllegalArgumentException("Expected 3 arguments, got " + numberOfFields);
    }
    String party = fields$.get(0).getValue().asParty().orElseThrow(() -> new IllegalArgumentException("Expected party to be of type com.daml.ledger.javaapi.data.Party")).getValue();
    Optional<String> displayName = fields$.get(1).getValue().asOptional()
            .map(v$0 -> v$0.toOptional(v$1 ->
                v$1.asText().orElseThrow(() -> new IllegalArgumentException("Expected v$1 to be of type com.daml.ledger.javaapi.data.Text")).getValue()
            ))
            .orElseThrow(() -> new IllegalArgumentException("Expected displayName to be of type com.daml.ledger.javaapi.data.DamlOptional"))
                  ;
    Boolean isLocal = fields$.get(2).getValue().asBool().orElseThrow(() -> new IllegalArgumentException("Expected isLocal to be of type com.daml.ledger.javaapi.data.Bool")).getValue();
    return new com.daml.quickstart.model.daml.script.PartyDetails(party, displayName, isLocal);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(3);
    fields.add(new Record.Field("party", new Party(this.party)));
    fields.add(new Record.Field("displayName", DamlOptional.of(this.displayName.map(v$0 -> new Text(v$0)))));
    fields.add(new Record.Field("isLocal", new Bool(this.isLocal)));
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
    if (!(object instanceof PartyDetails)) {
      return false;
    }
    PartyDetails other = (PartyDetails) object;
    return this.party.equals(other.party) && this.displayName.equals(other.displayName) && this.isLocal.equals(other.isLocal);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.party, this.displayName, this.isLocal);
  }

  @Override
  public String toString() {
    return String.format("com.daml.quickstart.model.daml.script.PartyDetails(%s, %s, %s)", this.party, this.displayName, this.isLocal);
  }
}
