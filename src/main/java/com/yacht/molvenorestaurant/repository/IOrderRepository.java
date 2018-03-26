package com.yacht.molvenorestaurant.repository;

import com.yacht.molvenorestaurant.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface IOrderRepository extends CrudRepository<Order, Long> {
}
