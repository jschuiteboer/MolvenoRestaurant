package com.yacht.molvenorestaurant.business;

import com.yacht.molvenorestaurant.model.Ingredient;

import java.util.ArrayList;

public class IngredientManager {
    private ArrayList<Ingredient> ingredientList;

    public void addIngredient(Ingredient ingredient) {
        ingredientList.add(ingredient);
    }

    public void removeIngredient(Ingredient ingredient){
        ingredientList.remove(ingredient);
    }

    public void updateIngredient(Ingredient ingredient, String name) {
        for (Ingredient oldIngredient : ingredientList) {
            if (oldIngredient.getIngredientName().equals(name)) {
                ingredientList.add(ingredientList.indexOf(oldIngredient), ingredient);
            }
        }
    }
}