package com.yacht.molvenorestaurant.controller;

import com.yacht.molvenorestaurant.business.DishManager;
import com.yacht.molvenorestaurant.model.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/dishes")
public class DishController {

    @Autowired
    private DishManager dishManager;

    @GetMapping()
    public Iterable<Dish> getAll() {
        return this.dishManager.getAll();
    }

    @GetMapping("{id}")
    public Dish getOne(@PathVariable long id) {
        return this.dishManager.getOne(id);
    }

    @PostMapping("save")
    public Dish saveDish (@RequestBody Dish dish){
        return this.dishManager.saveDish(dish);
    }

    @DeleteMapping("{id}")
    public void deleteDish(@PathVariable long id){
        this.dishManager.deleteDish(id);
    }
}
