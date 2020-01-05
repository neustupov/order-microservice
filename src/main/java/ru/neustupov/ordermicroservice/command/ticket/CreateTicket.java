package ru.neustupov.ordermicroservice.command.ticket;

import io.eventuate.tram.commands.common.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.neustupov.ordermicroservice.model.TicketDetails;

@AllArgsConstructor
@Getter
public class CreateTicket implements Command {

  private Long restaurantId;
  private Long orderId;
  private TicketDetails ticketDetails;
}
