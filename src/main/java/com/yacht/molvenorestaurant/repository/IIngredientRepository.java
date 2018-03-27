package com.yacht.molvenorestaurant.repository;

import com.yacht.molvenorestaurant.model.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIngredientRepository extends CrudRepository<Ingredient, Long> {
}
