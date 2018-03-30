package com.yacht.molvenorestaurant.business;

import com.yacht.molvenorestaurant.model.Dish;
import com.yacht.molvenorestaurant.model.Order;
import com.yacht.molvenorestaurant.repository.IDishRepository;
import com.yacht.molvenorestaurant.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderManager {
    @Autowired
    private IOrderRepository orderRepository;

    @Autowired
    private IDishRepository dishRepository;

    public Iterable<Order> getAll() {
        return this.orderRepository.findAll();
    }

    public Order getOne(Long id) {
        return this.orderRepository.findOne(id);
    }

    public Order saveOrder(Order order) {
        return this.orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        this.orderRepository.delete(id);
    }

}
