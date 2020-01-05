package ru.neustupov.ordermicroservice.manager;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import ru.neustupov.ordermicroservice.command.card.Authorize;
import ru.neustupov.ordermicroservice.command.order.ApproveOrder;
import ru.neustupov.ordermicroservice.command.order.RejectOrder;
import ru.neustupov.ordermicroservice.command.order.ValidateOrder;
import ru.neustupov.ordermicroservice.command.ticket.CancelCreateTicket;
import ru.neustupov.ordermicroservice.command.ticket.ConfirmCreateTicket;
import ru.neustupov.ordermicroservice.command.ticket.CreateTicket;
import ru.neustupov.ordermicroservice.command.ticket.CreateTicketReply;
import ru.neustupov.ordermicroservice.model.OrderDetails;
import ru.neustupov.ordermicroservice.model.TicketDetails;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class CreateOrderSagaState {

  private Long orderId;
  private OrderDetails orderDetails;
  private Long ticketId;

  public CreateOrderSagaState(Long orderId,
      OrderDetails orderDetails) {
    this.orderId = orderId;
    this.orderDetails = orderDetails;
  }

  CreateTicket makeCreateTicketCommand(){
    return new CreateTicket(orderDetails.getRestaurantId(), getOrderId(), makeTicketDetails(orderDetails));
  }

  void handleCreateTicketReply(CreateTicketReply reply){
    log.debug("getTicketId {}", reply.getTicketId());
    setTicketId(reply.getTicketId());
  }

  CancelCreateTicket makeCancelCreateTicketCommand(){
    return new CancelCreateTicket(getTicketId());
  }

  RejectOrder makeRejectOrderCommand(){
    return new RejectOrder(getOrderId());
  }

  ValidateOrder makeValidateOrderByConsumerCommand(){
    return new ValidateOrder(getOrderId());
  }

  Authorize makeAuthorizeCommand(){
    return new Authorize();
  }

  ConfirmCreateTicket makeConfirmCreateTicketCommand(){
    return new ConfirmCreateTicket(getTicketId());
  }

  ApproveOrder makeApproveOrderCommand(){
    return new ApproveOrder(getOrderId());
  }

  private TicketDetails makeTicketDetails(OrderDetails orderDetails){
    return new TicketDetails();
  }
}
