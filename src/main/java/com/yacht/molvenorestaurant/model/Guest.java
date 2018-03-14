package com.yacht.molvenorestaurant.model;

import lombok.Data;

@Data
public class Guest {
    private int roomnumber;

    /**
     * First and last name
     */
    private String name;

    private boolean isFemale;
}
