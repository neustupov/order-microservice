package ru.neustupov.ordermicroservice.manager;

import io.eventuate.tram.sagas.orchestration.SagaDefinition;
import io.eventuate.tram.sagas.simpledsl.SimpleSaga;
import ru.neustupov.ordermicroservice.command.ticket.CreateTicketReply;
import ru.neustupov.ordermicroservice.proxy.AccountingServiceProxy;
import ru.neustupov.ordermicroservice.proxy.ConsumerServiceProxy;
import ru.neustupov.ordermicroservice.proxy.KitchenServiceProxy;
import ru.neustupov.ordermicroservice.proxy.OrderServiceProxy;

public class CreateOrderSaga implements SimpleSaga<CreateOrderSagaState> {

  private SagaDefinition<CreateOrderSagaState> sagaDefinition;

  public CreateOrderSaga(OrderServiceProxy orderService,
      ConsumerServiceProxy consumerService,
      KitchenServiceProxy kitchenService,
      AccountingServiceProxy accountingService){
    this.sagaDefinition =
        step()
        .withCompensation(orderService.reject,
            CreateOrderSagaState::makeRejectOrderCommand)
        .step()
        .invokeParticipant(consumerService.validateOrder,
            CreateOrderSagaState::makeValidateOrderByConsumerCommand)
        .step()
        .invokeParticipant(kitchenService.create,
            CreateOrderSagaState::makeCreateTicketCommand)
        .onReply(CreateTicketReply.class,
            CreateOrderSagaState::handleCreateTicketReply)
        .withCompensation(kitchenService.cancel,
            CreateOrderSagaState::makeCancelCreateTicketCommand)
        .step()
        .invokeParticipant(accountingService.authorize,
            CreateOrderSagaState::makeAuthorizeCommand)
        .step()
        .invokeParticipant(kitchenService.confirm,
            CreateOrderSagaState::makeConfirmCreateTicketCommand)
        .step()
        .invokeParticipant(orderService.approve,
            CreateOrderSagaState::makeApproveOrderCommand)
        .build();
  }

  @Override
  public SagaDefinition<CreateOrderSagaState> getSagaDefinition() {
    return sagaDefinition;
  }
}
