package ru.neustupov.ordermicroservice.command.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Success {

  @Getter
  private Long orderId;
}
