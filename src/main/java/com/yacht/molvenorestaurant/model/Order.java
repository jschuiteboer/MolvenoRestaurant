package com.yacht.molvenorestaurant.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "order_") // renamed because sql is conflicting with the order keyword
public class Order {
    @Id
    @GeneratedValue
    private Long ID;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Dish> orderList = new ArrayList<>();

    private String comment;

    private boolean isReady;

    public Order(Long ID, List<Dish> orderList, String comment, boolean isReady) {
        this.ID = ID;
        this.orderList = orderList;
        this.comment = comment;
        this.isReady = isReady;
    }

    public Order() {
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

    public BigDecimal getTotalPrice()
    {
        BigDecimal totalPrice = new BigDecimal(0);

        for (Dish dish : orderList) {
            BigDecimal price = dish.getPrice();
            if(price == null) continue;

            totalPrice = totalPrice.add(price);
        }

        return totalPrice;
    }
}
