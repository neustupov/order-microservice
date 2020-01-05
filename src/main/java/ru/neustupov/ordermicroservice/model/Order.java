package ru.neustupov.ordermicroservice.model;

import io.eventuate.tram.events.ResultWithEvents;
import io.eventuate.tram.events.common.DomainEvent;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;

@Entity
public class Order {

  @Id
  @GeneratedValue
  @Getter
  private Long id;

  private OrderDetails orderDetails;

  private Order(OrderDetails orderDetails) {
    this.orderDetails = orderDetails;
  }

  public static ResultWithEvents<Order> createOrder(OrderDetails orderDetails){
    return new ResultWithEvents<>(new Order(orderDetails), new DomainEvent(){});
  }
}
