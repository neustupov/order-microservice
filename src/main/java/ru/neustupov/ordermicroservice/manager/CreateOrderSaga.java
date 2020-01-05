package ru.neustupov.ordermicroservice.manager;

import io.eventuate.tram.sagas.orchestration.SagaDefinition;
import io.eventuate.tram.sagas.simpledsl.SimpleSaga;
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
        .withCompensation(orderService.reject, CreateOrderSagaState::makeRejectOrderCommand)
        .step()
        .invokeParticipant()
  }

  @Override
  public SagaDefinition<CreateOrderSagaState> getSagaDefinition() {
    return sagaDefinition;
  }
}
