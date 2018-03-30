package com.yacht.molvenorestaurant.controller;

import com.yacht.molvenorestaurant.business.IngredientManager;
import com.yacht.molvenorestaurant.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/ingredients")
public class IngredientController {
    @Autowired
    private IngredientManager ingredientManager;

    @GetMapping()
    public Iterable<Ingredient> getAll() {
        return this.ingredientManager.getAll();
    }

    @GetMapping("{id}")
    public Ingredient getOne(@PathVariable long id) {
        return this.ingredientManager.getOne(id);
    }

    @PostMapping()
    public Ingredient saveIngredient(@RequestBody Ingredient ingredient) {
        return this.ingredientManager.saveIngredient(ingredient);
    }

    @DeleteMapping("{id}")
    public void deleteIngredient(@PathVariable long id) {
        this.ingredientManager.deleteIngredient(id);
    }
}
