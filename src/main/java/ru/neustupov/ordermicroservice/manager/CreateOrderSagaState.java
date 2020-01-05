package ru.neustupov.ordermicroservice.manager;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.neustupov.ordermicroservice.model.OrderDetails;

@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderSagaState {

  @Getter
  @Setter
  private Long orderId;

  private OrderDetails orderDetails;
  private Long ticketId;

  public CreateOrderSagaState(Long orderId,
      OrderDetails orderDetails) {
    this.orderId = orderId;
    this.orderDetails = orderDetails;
  }

  public void makeRejectOrderCommand(){}
}
