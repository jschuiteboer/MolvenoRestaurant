package com.yacht.molvenorestaurant.business;

import com.yacht.molvenorestaurant.model.Dish;
import com.yacht.molvenorestaurant.model.Ingredient;
import com.yacht.molvenorestaurant.repository.IDishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DishManager {

    //produces a suggested price from all the selected ingredients
    //by myltiplying the price with the amount for eacht ingredient
    public BigDecimal getSuggestedPrice(Dish dish){
        BigDecimal suggestion = new BigDecimal(0);

        for (Ingredient ingredient: this.getIngredientList()) {
            BigDecimal ingredientPrice = (ingredient.getPrice)*quantity;
            suggestion = ingredientPrice.add(suggestion);
        }

        return suggestion;
    }
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

