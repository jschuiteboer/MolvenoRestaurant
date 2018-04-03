package com.yacht.molvenorestaurant.business;

import com.yacht.molvenorestaurant.model.Order;
import com.yacht.molvenorestaurant.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

@Component
public class OrderManager {
    @Autowired
    private IOrderRepository orderRepository;

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

  @PostConstruct
   private void createSomeTestData() {
        Random rand = new Random();

        for(int i = 0; i < 50; ++i) {
            Order order = new Order();
            order.setReady(rand.nextBoolean());
            order.setComment("Order " + i + " " + Integer.toHexString(order.hashCode()));

            this.saveOrder(order);
        }
  }
}
