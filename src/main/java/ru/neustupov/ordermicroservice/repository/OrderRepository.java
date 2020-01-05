package ru.neustupov.ordermicroservice.repository;

import org.springframework.data.repository.CrudRepository;
import ru.neustupov.ordermicroservice.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
