package ru.neustupov.ordermicroservice.proxy;

import io.eventuate.tram.sagas.simpledsl.CommandEndpoint;
import io.eventuate.tram.sagas.simpledsl.CommandEndpointBuilder;
import ru.neustupov.ordermicroservice.channels.OrderServiceChannels;
import ru.neustupov.ordermicroservice.command.order.RejectOrder;
import ru.neustupov.ordermicroservice.command.order.Success;

public class OrderServiceProxy {

  public final CommandEndpoint<RejectOrder> reject =
      CommandEndpointBuilder
          .forCommand(RejectOrder.class)
          .withChannel(OrderServiceChannels.orderServiceChannel)
          .withReply(Success.class)
          .build();
}
