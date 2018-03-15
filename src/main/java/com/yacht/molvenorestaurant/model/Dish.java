package com.yacht.molvenorestaurant.model;

import lombok.Data;

import java.util.List;

@Data
public class Dish {
    private String name;

    private int price;

    private List<Ingredient> ingredientList;

    private String description;
}