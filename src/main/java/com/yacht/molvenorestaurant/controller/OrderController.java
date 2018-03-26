package com.yacht.molvenorestaurant.controller;

import com.yacht.molvenorestaurant.business.OrderManager;
import com.yacht.molvenorestaurant.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/orders")
public class OrderController {
    @Autowired
    private OrderManager orderManager;

    @GetMapping()
    public Iterable<Order> getAll() {
        return this.orderManager.getAll();
    }

    @PostMapping("save")
    public Order saveOrder(@RequestBody Order order) {
        return this.orderManager.saveOrder(order);
    }
}
