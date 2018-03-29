package com.yacht.molvenorestaurant.business;

import com.yacht.molvenorestaurant.model.EAllergy;
import com.yacht.molvenorestaurant.model.Ingredient;
import com.yacht.molvenorestaurant.repository.IIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Component
public class IngredientManager {
    @Autowired
    private IIngredientRepository ingredientRepository;

    public Iterable<Ingredient> getAll(){ return ingredientRepository.findAll();}

    public Ingredient getOne(Long id) {
        return ingredientRepository.findOne(id);
    }

    public Ingredient saveIngredient(Ingredient ingredient) {
        return this.ingredientRepository.save(ingredient);
    }

    public void deleteIngredient(Long id) {
        this.ingredientRepository.delete(id);
    }

    @PostConstruct
    private void createSomeTestData() {
        ArrayList<Ingredient> Inventory = new ArrayList<Ingredient>();
        EAllergy milkAllergy = (EAllergy.MILK);
        EAllergy glutenAllergy = (EAllergy.GLUTEN);

        Ingredient kaas = new Ingredient("Kaas", 30, 80,milkAllergy, null);
        Ingredient melk = new Ingredient("Melk", 20, 80, milkAllergy, null);
        Ingredient bloem = new Ingredient("Bloem", 50, 80,glutenAllergy,null);
        Ingredient boter = new Ingredient("Boter", 10, 40, milkAllergy,null);

        this.saveIngredient(kaas); this.saveIngredient(melk); this.saveIngredient(bloem); this.saveIngredient(boter);
    }
}

