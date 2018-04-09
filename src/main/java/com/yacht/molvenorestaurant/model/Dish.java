package com.yacht.molvenorestaurant.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Dish {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private BigDecimal price;
    private String description;
    private String category;

    @OneToMany(cascade = CascadeType.ALL)
    private List<DishIngredientEntry> ingredientList = new ArrayList<>();

    public Dish() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<DishIngredientEntry> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<DishIngredientEntry> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
