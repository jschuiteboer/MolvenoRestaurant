package com.yacht.molvenorestaurant.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


public class Order {
    private Long ID;
    private List<Dish> orderList;
    private String comment;
    private boolean isReady;

    public BigDecimal getTotalPrice()
    {
        BigDecimal totalPrice = new BigDecimal(0);

        for (Dish dish: orderList) {
            BigDecimal price = new BigDecimal(dish.getPrice());
            totalPrice = totalPrice.add(price);
        }

        return totalPrice;
    }

    public void addDish(Dish dish){
        orderList.add(dish);
    }

    public List<Dish> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Dish> orderList) {
        this.orderList = orderList;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isReady() {
        return isReady;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }
}
