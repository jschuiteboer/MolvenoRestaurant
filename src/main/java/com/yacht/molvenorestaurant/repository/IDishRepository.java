package com.yacht.molvenorestaurant.repository;

import com.yacht.molvenorestaurant.model.Dish;
import org.springframework.data.repository.CrudRepository;

public interface IDishRepository extends CrudRepository<Dish, Long> {
}
