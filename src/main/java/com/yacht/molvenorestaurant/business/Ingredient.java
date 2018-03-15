package com.yacht.molvenorestaurant.business;

public class Ingredient {
    private String name;
    private int minimumStock;
    private int stock;
    private EAllergy allergy;
    private Supplier Supplier;

    public boolean isOutOfStock()
    {
        return this.stock <= this.minimumStock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return Supplier;
    }

    public void setSupplier(Supplier supplier) {
        Supplier = supplier;
    }
}
