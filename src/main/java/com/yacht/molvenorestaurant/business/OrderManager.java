package com.yacht.molvenorestaurant.business;

import com.yacht.molvenorestaurant.model.Order;
import com.yacht.molvenorestaurant.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    @PostConstruct
    public void initSomeTestData() {
        Random rand = new Random();

        for(int i = 1; i < 300; ++i) {
            orderRepository.save(new Order(null, new ArrayList<>(), "order " + i, rand.nextBoolean()));
        }
    }
}
