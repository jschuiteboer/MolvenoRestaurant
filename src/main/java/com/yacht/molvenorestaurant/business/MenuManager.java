package com.yacht.molvenorestaurant.business;

import com.yacht.molvenorestaurant.model.MenuCategory;

import java.util.ArrayList;

public class MenuManager {

    public ArrayList<MenuCategory> getCategoriesList() {
        return categoriesList;
    }

    public void setCategoriesList(ArrayList<MenuCategory> categoriesList) {
        this.categoriesList = categoriesList;
    }

    private ArrayList<MenuCategory> categoriesList;

    public void addIngredient(MenuCategory ingredient) {
        getCategoriesList().add(ingredient);
    }

    public void removeIngredient(MenuCategory ingredient){
        getCategoriesList().remove(ingredient);
    }

    public void updateIngredient(MenuCategory ingredient, String name) {
        for (MenuCategory oldCategory : getCategoriesList()) {
            if (oldCategory.getName().equals(name)) {
                getCategoriesList().add(getCategoriesList().indexOf(oldCategory), ingredient);
            }
        }
    }
}
