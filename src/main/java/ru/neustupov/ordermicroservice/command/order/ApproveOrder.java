package ru.neustupov.ordermicroservice.command.order;

import io.eventuate.tram.commands.common.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ApproveOrder implements Command {

  @Getter
  private Long orderId;
}
