package com.yacht.molvenorestaurant.model;

public class Menu extends Dish {
    private Dish starter;
    private Dish main;
    private Dish dessert;

    public Menu() {
    }

    public Dish getStarter() {
        return starter;
    }

    public void setStarter(Dish starter) {
        this.starter = starter;
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

}
