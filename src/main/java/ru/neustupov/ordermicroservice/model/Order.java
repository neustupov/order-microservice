package ru.neustupov.ordermicroservice.model;

import io.eventuate.tram.events.ResultWithEvents;
import io.eventuate.tram.events.common.DomainEvent;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order {

  @Id
  @GeneratedValue
  private Long id;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id")
  private OrderDetails orderDetails;

  private boolean isApprove;

  private Order(OrderDetails orderDetails) {
    this.orderDetails = orderDetails;
  }

  public static ResultWithEvents<Order> createOrder(OrderDetails orderDetails){
    return new ResultWithEvents<>(new Order(orderDetails), new DomainEvent(){});
  }
}
