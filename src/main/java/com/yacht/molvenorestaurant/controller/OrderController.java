package com.yacht.molvenorestaurant.controller;

import com.yacht.molvenorestaurant.business.OrderManager;
import com.yacht.molvenorestaurant.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class OrderController {
    private static final int PAGE_SIZE = 30;

    @Autowired
    private OrderManager orderManager;

    @GetMapping("/api/order/getOrderPage")
    public List<Order> getOrderPage(int pageNum) {
        PageRequest request = PageRequest.of(pageNum, PAGE_SIZE);
        Page<Order> page = this.orderManager.getOrders(request);
        return page.getContent();
    }

    @GetMapping("/api/order/createNewOrder")
    public Order createNewOrder() {
        return this.orderManager.createNewOrder();
    }

    @GetMapping("/api/order/updateOrder")
    public void updateOrder(Order order) {
        this.updateOrder(order);
    }

    @GetMapping("/api/order/removeOrder")
    public void removeOrder(Order order) {
        this.orderManager.removeOrder(order);
    }

    @GetMapping("/api/order/markOrderComplete")
    public void markOrderComplete(Order order) {
        order.setReady(true);
        this.updateOrder(order);
    }
}
