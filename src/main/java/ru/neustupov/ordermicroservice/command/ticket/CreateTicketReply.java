package ru.neustupov.ordermicroservice.command.ticket;

import io.eventuate.tram.commands.common.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class CreateTicketReply implements Command {

  @Getter
  private Long ticketId;
}
