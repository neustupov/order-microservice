package ru.neustupov.ordermicroservice.command.ticket;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Success {

  @Getter
  private Long ticketId;
}
