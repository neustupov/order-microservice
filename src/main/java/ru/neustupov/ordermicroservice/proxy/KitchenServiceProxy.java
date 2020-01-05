package ru.neustupov.ordermicroservice.proxy;

import io.eventuate.tram.sagas.simpledsl.CommandEndpoint;
import io.eventuate.tram.sagas.simpledsl.CommandEndpointBuilder;
import ru.neustupov.ordermicroservice.channels.KitchenServiceChannels;
import ru.neustupov.ordermicroservice.command.ticket.CancelCreateTicket;
import ru.neustupov.ordermicroservice.command.ticket.ConfirmCreateTicket;
import ru.neustupov.ordermicroservice.command.ticket.CreateTicket;
import ru.neustupov.ordermicroservice.command.ticket.CreateTicketReply;
import ru.neustupov.ordermicroservice.command.ticket.Success;

public class KitchenServiceProxy {

  public final CommandEndpoint<CreateTicket> create =
      CommandEndpointBuilder
      .forCommand(CreateTicket.class)
      .withChannel(KitchenServiceChannels.kitchenServiceChannel)
      .withReply(CreateTicketReply.class)
      .build();

  public final CommandEndpoint<ConfirmCreateTicket> confirm =
      CommandEndpointBuilder
      .forCommand(ConfirmCreateTicket.class)
      .withChannel(KitchenServiceChannels.kitchenServiceChannel)
      .withReply(Success.class)
      .build();

  public final CommandEndpoint<CancelCreateTicket> cancel =
      CommandEndpointBuilder
      .forCommand(CancelCreateTicket.class)
      .withChannel(KitchenServiceChannels.kitchenServiceChannel)
      .withReply(Success.class)
      .build();
}
