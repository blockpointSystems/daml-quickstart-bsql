package com.daml.quickstart.iou;

import com.daml.ledger.javaapi.data.Contract;
import com.daml.ledger.javaapi.data.CreatedEvent;
import com.daml.ledger.javaapi.data.Identifier;
import com.daml.quickstart.model.iou.Iou;
import com.daml.quickstart.model.iou.IouTransfer;
import com.daml.quickstart.model.ioutrade.IouTrade;
import java.lang.IllegalArgumentException;
import java.util.HashMap;
import java.util.Optional;
import java.util.function.Function;

public class TemplateDecoder {
  private static HashMap<Identifier, Function<CreatedEvent, Contract>> decoders;

  static {
    decoders = new HashMap<Identifier, Function<CreatedEvent, Contract>>();
    decoders.put(IouTrade.TEMPLATE_ID, IouTrade.Contract::fromCreatedEvent);
    decoders.put(IouTransfer.TEMPLATE_ID, IouTransfer.Contract::fromCreatedEvent);
    decoders.put(Iou.TEMPLATE_ID, Iou.Contract::fromCreatedEvent);
  }

  public static Contract fromCreatedEvent(CreatedEvent event) throws IllegalArgumentException {
    Identifier templateId = event.getTemplateId();
    Function<CreatedEvent, Contract> decoderFunc = getDecoder(templateId).orElseThrow(() -> new IllegalArgumentException("No template found for identifier " + templateId));
    return decoderFunc.apply(event);
  }

  public static Optional<Function<CreatedEvent, Contract>> getDecoder(Identifier templateId) {
    return Optional.ofNullable(decoders.get(templateId));
  }
}
