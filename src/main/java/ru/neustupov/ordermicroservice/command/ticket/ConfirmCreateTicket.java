package ru.neustupov.ordermicroservice.command.ticket;

import io.eventuate.tram.commands.common.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ConfirmCreateTicket implements Command {

  @Getter
  private Long ticketId;
}
