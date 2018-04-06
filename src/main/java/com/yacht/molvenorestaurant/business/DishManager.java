package com.yacht.molvenorestaurant.business;

import com.yacht.molvenorestaurant.model.Dish;
import com.yacht.molvenorestaurant.model.Ingredient;
import com.yacht.molvenorestaurant.repository.IDishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DishManager {

    @Autowired
    private IDishRepository dishRepository;

    /**
     * produces a suggested price from all the selected ingredients
     * by multiplying the price with the amount for each ingredient
     */
    public BigDecimal getSuggestedPrice(Dish dish){
        BigDecimal suggestion = new BigDecimal(0);

        for (Ingredient ingredient: dish.getIngredientList()) {
            BigDecimal ingredientPrice = (ingredient.getPrice()).multiply(BigDecimal.valueOf(ingredient.getQuantity()));
            suggestion = ingredientPrice.add(suggestion);
        }

        return suggestion;
    }

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

    public Iterable<Dish> getByCategory(String category) {
        return this.dishRepository.findByCategory(category);
    }
}

