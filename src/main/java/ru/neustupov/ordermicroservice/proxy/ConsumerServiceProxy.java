package ru.neustupov.ordermicroservice.proxy;

import io.eventuate.tram.sagas.simpledsl.CommandEndpoint;
import io.eventuate.tram.sagas.simpledsl.CommandEndpointBuilder;
import ru.neustupov.ordermicroservice.channels.ConsumerServiceChannels;
import ru.neustupov.ordermicroservice.command.order.ValidateOrder;
import ru.neustupov.ordermicroservice.command.order.ValidateOrderReply;

public class ConsumerServiceProxy {

  public final CommandEndpoint<ValidateOrder> validateOrder =
      CommandEndpointBuilder
          .forCommand(ValidateOrder.class)
          .withChannel(ConsumerServiceChannels.consumerServiceChannel)
          .withReply(ValidateOrderReply.class)
          .build();
}
