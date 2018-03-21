package com.yacht.molvenorestaurant.business;

import com.yacht.molvenorestaurant.model.Dish;

import java.util.*;

public class DishManager {
    private ArrayList<Dish> dishList;

    public void addDish(Dish dish){
        dishList.add(dish);
    }
    public void removeDish(Dish dish){
        dishList.remove(dish);
    }

    public ArrayList<Dish> getDishList() {
        return dishList;
    }

    public void updateDish(Dish dish, String name){
        for (Dish oldDish : dishList) {
            if (oldDish.getName().equals(name)) {
                dishList.add(dishList.indexOf(oldDish), dish);
            }
        }
    }
}
