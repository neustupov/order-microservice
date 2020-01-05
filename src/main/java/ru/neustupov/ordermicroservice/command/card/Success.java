package ru.neustupov.ordermicroservice.command.card;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Success {

  @Getter
  private String cardNumber;
}
