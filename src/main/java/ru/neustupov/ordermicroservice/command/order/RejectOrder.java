package ru.neustupov.ordermicroservice.command.order;

import io.eventuate.tram.commands.common.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class RejectOrder implements Command {

  @Getter
  private Long orderId;
}
