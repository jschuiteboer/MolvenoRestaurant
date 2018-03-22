package com.yacht.molvenorestaurant.business;

import com.yacht.molvenorestaurant.model.Order;
import com.yacht.molvenorestaurant.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class OrderManager {
    @Autowired
    private IOrderRepository orderRepository;

    public Page<Order> getOrders(PageRequest request) {
        return orderRepository.findAll(request);
    }

    public Iterable<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order createNewOrder() {
        return new Order();
    }

    public Order updateOrder(Order order) {
        return this.orderRepository.save(order);
    }

    public void removeOrder(Order order) {
        this.orderRepository.delete(order);
    }

    public Order saveOrder(Order order) {
        return this.orderRepository.save(order);
    }
}
