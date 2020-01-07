package ru.neustupov.ordermicroservice.handlers;

import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withSuccess;

import io.eventuate.tram.commands.consumer.CommandHandlers;
import io.eventuate.tram.commands.consumer.CommandMessage;
import io.eventuate.tram.messaging.common.Message;
import io.eventuate.tram.sagas.participant.SagaCommandHandlersBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import ru.neustupov.ordermicroservice.command.order.ApproveOrder;
import ru.neustupov.ordermicroservice.command.order.RejectOrder;
import ru.neustupov.ordermicroservice.service.OrderService;

public class OrderCommandHandlers {

  @Autowired
  private OrderService orderService;

  public CommandHandlers commandHandlers(){
    return SagaCommandHandlersBuilder
        .fromChannel("orderService")
        .onMessage(ApproveOrder.class, this::approveOrder)
        .onMessage(RejectOrder.class, this::rejectOrder)
        .build();
  }

  public Message approveOrder(CommandMessage<ApproveOrder> cm){
    long orderId = cm.getCommand().getOrderId();
    orderService.approveOrder(orderId);
    return withSuccess();
  }

  public Message rejectOrder(CommandMessage<RejectOrder> cm){
    long orderId = cm.getCommand().getOrderId();
    orderService.rejectOrder(orderId);
    return withSuccess();
  }
}
