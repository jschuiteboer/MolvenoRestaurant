package com.yacht.molvenorestaurant.business;

import com.yacht.molvenorestaurant.model.Dish;
import com.yacht.molvenorestaurant.model.DishIngredientEntry;
import com.yacht.molvenorestaurant.repository.IDishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

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

        List<DishIngredientEntry> ingredientList = dish.getIngredientList();

        if(ingredientList != null) {
            for (DishIngredientEntry ingredientEntry : ingredientList) {
                BigDecimal entryTotalPrice = ingredientEntry.getTotalPrice();
                suggestion = suggestion.add(entryTotalPrice);
            }
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

