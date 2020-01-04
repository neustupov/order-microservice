package ru.neustupov.ordermicroservice.manager;

import io.eventuate.tram.sagas.orchestration.SagaInstance;
import io.eventuate.tram.sagas.orchestration.SagaManager;
import java.util.Optional;

public class CreateOrderSaga implements SagaManager {

  @Override
  public SagaInstance create(Object o) {
    return null;
  }

  @Override
  public SagaInstance create(Object o, Class aClass, Object o2) {
    return null;
  }

  @Override
  public SagaInstance create(Object o, Optional optional) {
    return null;
  }
}
