package com.yacht.molvenorestaurant.business;

import lombok.Data;

@Data
public class Ingredient {
    private String name;

    private int stock;

    private int minimumStock;
}
