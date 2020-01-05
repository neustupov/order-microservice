package ru.neustupov.ordermicroservice.command.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ValidateOrderReply {

  @Getter
  private Long orderId;
}
