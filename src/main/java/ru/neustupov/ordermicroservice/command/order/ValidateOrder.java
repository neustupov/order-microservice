package ru.neustupov.ordermicroservice.command.order;

import io.eventuate.tram.commands.common.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ValidateOrder implements Command {

  @Getter
  private Long orderId;
}
