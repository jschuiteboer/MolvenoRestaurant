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
        return dishManager.getAll();
    }

    @GetMapping()
    public Dish getOne(@PathVariable long id) {
        return dishManager.getOne(id)
    }

    @PostMapping("save")
    public Dish saveDish (@RequestBody Dish dish){
        return dishManager.saveDish(dish);
    }

    @DeleteMapping("{id}")
    public void deleteDish(@PathVariable long id){
        dishManager.deleteDish(id);
    }
}
