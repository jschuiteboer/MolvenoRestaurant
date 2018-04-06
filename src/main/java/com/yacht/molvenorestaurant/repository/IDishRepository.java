package com.yacht.molvenorestaurant.repository;

import com.yacht.molvenorestaurant.model.Dish;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IDishRepository extends CrudRepository<Dish, Long> {
    List<Dish> findByCategory(String category);
}
