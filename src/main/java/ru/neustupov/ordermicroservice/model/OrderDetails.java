package ru.neustupov.ordermicroservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrderDetails {

  @Id
  @GeneratedValue
  private Long id;

  private Long restaurantId;
  private Long orderId;
}
