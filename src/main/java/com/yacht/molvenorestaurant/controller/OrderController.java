package com.yacht.molvenorestaurant.controller;

import com.yacht.molvenorestaurant.business.OrderManager;
import com.yacht.molvenorestaurant.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/orders")
public class OrderController {
    private static final int PAGE_SIZE = 30;

    @Autowired
    private OrderManager orderManager;

    @GetMapping()
    public Iterable<Order> getAll() {
        return this.orderManager.getAll();
    }

    @GetMapping("page/{page}")
    public Iterable<Order> getPage(@PathVariable int page) {
        return this.orderManager.getOrders(new PageRequest(page, PAGE_SIZE));
    }

    @PostMapping("save")
    public Order saveOrder(@RequestBody Order order) {
        return this.orderManager.saveOrder(order);
    }
}