package com.yacht.molvenorestaurant.model;

public class Ingredient {
    private String ingredientName;
    private int minimumStock;
    private int stock;
    private EAllergy allergy;
    private Supplier Supplier;

    public boolean isOutOfStock()
    {
        boolean boolsetter;

        if (this.stock<= this.minimumStock)
        {boolsetter = true;}
        else
        {boolsetter = false;};
        return boolsetter;
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
        return Supplier;
    }

    public void setSupplier(Supplier supplier) {
        Supplier = supplier;
    }
}
