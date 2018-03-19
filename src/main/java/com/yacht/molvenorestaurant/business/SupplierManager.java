package com.yacht.molvenorestaurant.business;

import java.util.ArrayList;

public class SupplierManager {

    private ArrayList<Supplier> supplierList;

    public void addSupplier(Supplier supplier) {
        supplierList.add(supplier);
    }

    public void removeSupplier(Supplier supplier){
        supplierList.remove(supplier);
    }

    public void updateSupplier(Supplier supplier, String name) {
        for (Supplier oldSupplier : supplierList) {
            if (oldSupplier.getSupplierName().equals(name)) {
                supplierList.add(supplierList.indexOf(oldSupplier), supplier);
            }
        }
    }