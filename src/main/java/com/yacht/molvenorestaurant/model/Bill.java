package com.yacht.molvenorestaurant.model;

import com.yacht.molvenorestaurant.model.Dish;

import java.math.BigDecimal;
import java.util.List;

public class Bill {
    private boolean isPaid;
    private Table table = new Table();
    private Guest guest = new Guest();
    private List<Order> orderList;

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal total = new BigDecimal(0);
        for (Order order : orderList) {
            total = total.add(order.getTotalPrice());
        }
        return total;
    }

}