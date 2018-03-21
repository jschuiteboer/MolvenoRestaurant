package com.yacht.molvenorestaurant.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "order_") // renamed because sql is conflicting with the order keyword
public class Order {
    @Id
    private Long ID;
    //TODO: don't ignore this field
    @Transient
    private List<Dish> orderList;
    private String comment;
    private boolean isReady;

    public BigDecimal getTotalPrice()
    {
        BigDecimal totalPrice = new BigDecimal(0);

        for (Dish dish: orderList) {
            BigDecimal price = dish.getPrice();
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
