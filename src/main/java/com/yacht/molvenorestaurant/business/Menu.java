package com.yacht.molvenorestaurant.business;

import lombok.Data;

@Data
public class Menu {
    private String name;

    private Dish appetizer;

    private Dish main;

    private Dish dessert;

    private int price;
}
