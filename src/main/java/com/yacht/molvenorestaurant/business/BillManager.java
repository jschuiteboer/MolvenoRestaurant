package com.yacht.molvenorestaurant.business;

import com.yacht.molvenorestaurant.model.Bill;

import java.util.ArrayList;
import java.util.List;

public class BillManager {
    private static List<Bill> bills = new ArrayList<>();

    public void markAsPaid(Bill bill) {
        bill.setPaid(true);

        // TODO: pass the bill to the repository
    }
}
