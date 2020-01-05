package ru.neustupov.ordermicroservice.manager;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.neustupov.ordermicroservice.model.OrderDetails;

@Getter
@Setter
@AllArgsConstructor
public class CreateOrderSagaState {

  private Long id;
  private OrderDetails orderDetails;

}
