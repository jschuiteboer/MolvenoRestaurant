package com.yacht.molvenorestaurant.model;




public class Menu extends Dish {
    private String dishName;
    private Dish appetizer;
    private Dish main;
    private Dish dessert;
    private int dishPrice;

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public Dish getAppetizer() {
        return appetizer;
    }

    public void setAppetizer(Dish appetizer) {
        this.appetizer = appetizer;
    }

    public Dish getMain() {
        return main;
    }

    public void setMain(Dish main) {
        this.main = main;
    }

    public Dish getDessert() {
        return dessert;
    }

    public void setDessert(Dish dessert) {
        this.dessert = dessert;
    }

    public int getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(int dishPrice) {
        this.dishPrice = dishPrice;
    }
}
