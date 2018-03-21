package com.yacht.molvenorestaurant.model;

import java.util.function.Supplier;

public class Ingredient {
    private String ingredientName;
    private int minimumStock;
    private int stock;
    private EAllergy allergy;
    private Supplier supplier;

    public boolean isOutOfStock()
    {
        return this.stock <= this.minimumStock;
    }

    public Ingredient() {
    }

    public Ingredient(String ingredientName, int minimumStock, int stock, EAllergy allergy, Supplier supplier) {
        this.ingredientName = ingredientName;
        this.minimumStock = minimumStock;
        this.stock = stock;
        this.allergy = allergy;
        this.supplier = supplier;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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
        supplier = supplier;
    }
}
