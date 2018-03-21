package com.yacht.molvenorestaurant.model;

import java.math.BigDecimal;
import java.util.List;

public class Bill {
    private boolean isPaid;
    private Table table = new Table();
    private Guest guest = new Guest();
    private List<Order> orderList;

    public Bill(boolean isPaid, Table table, Guest guest, List<Order> orderList) {
        this.isPaid = isPaid;
        this.table = table;
        this.guest = guest;
        this.orderList = orderList;
    }

    public Bill() {
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public List<Dish> getDishList() {
        return orderList;
    }

    public void setDishList(List<Dish> dishList) {
        this.orderList = dishList;
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

    public BigDecimal getTotalPrice(){
        BigDecimal total = new BigDecimal(0);
        for(Dish dish: orderList) {
            total = total.add(dish.getPrice());
        }
        return total;
    }
}