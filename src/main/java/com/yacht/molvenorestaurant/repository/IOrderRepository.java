package com.yacht.molvenorestaurant.repository;

import com.yacht.molvenorestaurant.model.Order;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IOrderRepository extends PagingAndSortingRepository<Order, Long> {
}
