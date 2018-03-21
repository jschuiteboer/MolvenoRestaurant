package com.yacht.molvenorestaurant.business;

import com.yacht.molvenorestaurant.model.Order;
import java.util.ArrayList;

public class OrderManager {

    private ArrayList<Order> orders;

    public void addOrder(Order order){
        orders.add(order);
    }

    public void removeOrder(Order order){
        orders.remove(order);
    }

    public void updateOrder(Order order, Long ID){
        for (Order oldOrder : orders) {
            if (oldOrder.getID().equals(ID)) {
                orders.add(orders.indexOf(oldOrder), order);
            }
        }
    }

    public void markOrderComplete(Order order){
        order.setComplete(true);
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }
}
