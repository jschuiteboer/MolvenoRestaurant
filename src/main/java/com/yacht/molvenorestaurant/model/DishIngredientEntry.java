package com.yacht.molvenorestaurant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class DishIngredientEntry {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Ingredient ingredient;

    private Integer quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal quantity = BigDecimal.valueOf(this.getQuantity());
        BigDecimal ingredientPrice = this.getIngredientPrice();

        if(quantity != null && ingredientPrice != null) {
            return this.getIngredientPrice().multiply(quantity);
        }

        return null;
    }

    @JsonIgnore
    public BigDecimal getIngredientPrice() {
        return ingredient != null ? ingredient.getPrice() : null;
    }
}
