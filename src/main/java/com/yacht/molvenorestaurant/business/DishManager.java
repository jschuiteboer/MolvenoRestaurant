package com.yacht.molvenorestaurant.business;

import com.yacht.molvenorestaurant.model.Dish;
import com.yacht.molvenorestaurant.repository.IDishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DishManager {

    @Autowired
    private IDishRepository dishRepository;

    public Iterable<Dish> getAll() {
        return this.dishRepository.findAll();
    }

    public Dish getOne(Long id){
        return this.dishRepository.findOne(id);
    }

    public Dish saveDish(Dish dish) {
        return this.dishRepository.save(dish);
    }

    public Dish updateDish(Dish dish){
        return this.dishRepository.save(dish);
    }

    public void deleteDish(Long id) {
        dishRepository.delete(id);
    }
}

