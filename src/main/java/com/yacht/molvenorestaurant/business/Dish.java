package com.yacht.molvenorestaurant.business;


import java.math.BigDecimal;
import java.util.List;


public class Dish {
    private String name;

    private BigDecimal price;

    private List<Ingredient> ingredientList;

    private String description;

    public BigDecimal getPrice() {
        return price;
    }
}
