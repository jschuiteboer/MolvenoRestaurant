package com.yacht.molvenorestaurant.model;

import java.util.ArrayList;

public class MenuCategory {

    private String name;
    private ArrayList<Dish> dishList;

    public MenuCategory(String name, ArrayList<Dish> dishList) {
        this.name = name;
        this.dishList = dishList;
    }

    public MenuCategory() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(ArrayList<Dish> dishList) {
        this.dishList = dishList;
    }
}
