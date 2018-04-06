package com.yacht.molvenorestaurant.controller;

import com.yacht.molvenorestaurant.business.DishManager;
import com.yacht.molvenorestaurant.business.IngredientManager;
import com.yacht.molvenorestaurant.model.Dish;
import com.yacht.molvenorestaurant.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/dishes")
public class DishController {

    @Autowired
    private DishManager dishManager;

    @Autowired
    private IngredientManager ingredientManager;

    @GetMapping()
    public Iterable<Dish> getAll() {
        return this.dishManager.getAll();
    }

    @GetMapping("{id}")
    public Dish getOne(@PathVariable long id) {
        return this.dishManager.getOne(id);
    }

    @GetMapping("/cat/{category}")
    public Iterable<Dish> getByCategory(@PathVariable String category) {
        return this.dishManager.getByCategory(category);
    }

    @PostMapping()
    public Dish saveDish (@RequestBody Dish dish){

        List<Ingredient> newIngredientList = new ArrayList<>();

        for(Ingredient ingredient : dish.getIngredientList()){
            newIngredientList.add(ingredientManager.getOne(ingredient.getId()));
        }

        dish.setIngredientList(newIngredientList);

        return this.dishManager.saveDish(dish);
    }

    @DeleteMapping("{id}")
    public void deleteDish(@PathVariable long id){
        this.dishManager.deleteDish(id);
    }
}
