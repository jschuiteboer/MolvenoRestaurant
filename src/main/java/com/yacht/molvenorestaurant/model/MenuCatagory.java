package com.yacht.molvenorestaurant.model;

import java.util.List;

public class MenuCatagory {
    private String name;
    private List<Dish> dishList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }
}
