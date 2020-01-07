package ru.neustupov.ordermicroservice.service;

import io.eventuate.tram.events.ResultWithEvents;
import io.eventuate.tram.events.publisher.DomainEventPublisher;
import io.eventuate.tram.sagas.orchestration.SagaManager;
import java.util.Collections;
import java.util.Optional;
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

  @Autowired
  private DomainEventPublisher eventPublisher;

  public Order createOrder(OrderDetails orderDetails){
    ResultWithEvents<Order> orderAndEvents = Order.createOrder(orderDetails);
    Order order = orderAndEvents.result;
    orderRepository.save(order);

    eventPublisher.publish(Order.class, Long.toString(order.getId()), orderAndEvents.events);
    CreateOrderSagaState data = new CreateOrderSagaState(order.getId(), orderDetails);
    createOrderSagaManager.create(data, Order.class, order.getId());

    return order;
  }

  public void approveOrder(Long orderId){
    Optional orderOptional = orderRepository.findById(orderId);
    if (orderOptional.isPresent()){
      Order order = (Order)orderOptional.get();
      order.setApprove(true);
      orderRepository.save(order);
    }
  }

  public void rejectOrder(long orderId){
    orderRepository.deleteById(orderId);
  }
}
