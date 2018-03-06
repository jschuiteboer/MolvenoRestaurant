package com.yacht.molvenorestaurant.business;

import lombok.Data;

import java.util.List;

@Data
public class Order {
    private Guest guest;

    private List<Dish> orderList;

    private boolean onAccount;

    private int tableNumber;

    private String comment;
}
