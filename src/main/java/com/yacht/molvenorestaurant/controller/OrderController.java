package com.yacht.molvenorestaurant.controller;

import com.yacht.molvenorestaurant.business.OrderManager;
import com.yacht.molvenorestaurant.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/orders/")
public class OrderController {
    private static final int PAGE_SIZE = 30;

    @Autowired
    private OrderManager orderManager;

    @GetMapping("/page/{pageNum}")
    public Iterable<Order> getPage(@PathVariable int pageNum) {
        return this.orderManager.getOrders(new PageRequest(pageNum, PAGE_SIZE));
    }
}
