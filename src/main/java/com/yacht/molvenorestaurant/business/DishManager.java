package com.yacht.molvenorestaurant.business;

import com.yacht.molvenorestaurant.model.Dish;
import com.yacht.molvenorestaurant.repository.IDishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Random;

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

    @PostConstruct
    private void createSomeTestData() {
        Random rand = new Random();

        for(int i = 1; i <= 50; ++i) {
            Dish dish = new Dish();

            dish.setPrice(new BigDecimal(rand.nextInt(100)));
            if( i >= 0 && i < 10) {
                dish.setName("Dish #" + 0 + i);
            }else {
                dish.setName("Dish #" + i);
            }
            dish.setDescription("Order " + i + " " + Integer.toHexString(dish.hashCode()));

            this.saveDish(dish);
        }
    }
}

