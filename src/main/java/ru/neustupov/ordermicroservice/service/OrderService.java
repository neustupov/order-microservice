package ru.neustupov.ordermicroservice.service;

import io.eventuate.tram.events.ResultWithEvents;
import io.eventuate.tram.events.publisher.DomainEventPublisher;
import io.eventuate.tram.sagas.orchestration.SagaManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.neustupov.ordermicroservice.manager.CreateOrderSagaState;
import ru.neustupov.ordermicroservice.model.Order;
import ru.neustupov.ordermicroservice.model.OrderDetails;
import ru.neustupov.ordermicroservice.repository.OrderRepository;

@Transactional
public class OrderService {

  @Autowired
  private SagaManager<CreateOrderSagaState> createOrderSagaManager;

  @Autowired
  private OrderRepository orderRepository;

  private DomainEventPublisher eventPublisher;

  public Order createOrder(OrderDetails orderDetails){

  }
}
