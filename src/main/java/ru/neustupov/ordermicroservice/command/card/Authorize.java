package ru.neustupov.ordermicroservice.command.card;

import io.eventuate.tram.commands.common.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Authorize implements Command {

  @Getter
  private String cardNumber;
}
