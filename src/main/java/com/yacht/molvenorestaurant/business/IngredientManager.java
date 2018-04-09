package com.yacht.molvenorestaurant.business;

import com.yacht.molvenorestaurant.model.Ingredient;
import com.yacht.molvenorestaurant.repository.IIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IngredientManager {
    @Autowired
    private IIngredientRepository ingredientRepository;

    public boolean isOutOfStock(Ingredient ingredient)
    {        return ingredient.getQuantity() <= ingredient.getMinimumStock();    }

    public Iterable<Ingredient> getAll(){ return ingredientRepository.findAll();}

    public Ingredient getOne(Long id) {
        return ingredientRepository.findOne(id);
    }

    public Ingredient saveIngredient(Ingredient ingredient) {
        return this.ingredientRepository.save(ingredient);
    }

    public void deleteIngredient(Long id) {
        this.ingredientRepository.delete(id);
    }
}