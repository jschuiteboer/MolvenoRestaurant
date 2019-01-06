package com.yacht.molvenorestaurant.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.function.Supplier;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue
    private Long id;
    private String ingredientName;
    private int minimumStock;
    private int quantity;
    private BigDecimal price;
    private EAllergy allergy;
    private String unit;
    @Transient
    private Supplier supplier;

    public Ingredient() {
    }

    public Ingredient(String ingredientName, int minimumStock, int quantity, BigDecimal price, EAllergy allergy, String unit, Supplier supplier) {
        this.ingredientName = ingredientName;
        this.minimumStock = minimumStock;
        this.quantity = quantity;
        this.price = price;
        this.allergy = allergy;
        this.unit = unit;
        this.supplier = supplier;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getTotalWorth(){
        BigDecimal price = this.getPrice();

        if(price == null) return null;

        return price.multiply(BigDecimal.valueOf(this.getQuantity()));
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public int getMinimumStock() {
        return minimumStock;
    }

    public void setMinimumStock(int minimumStock) {
        this.minimumStock = minimumStock;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public EAllergy getAllergy() {
        return allergy;
    }

    public void setAllergy(EAllergy allergy) {
        this.allergy = allergy;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
