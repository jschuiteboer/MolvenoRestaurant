package com.yacht.molvenorestaurant.business;

import java.util.ArrayList;
import java.util.List;

public class Guest {
    private int roomnumber;
    private String name;
    return roomnumber;
    }

    public void setRoomnumber(int roomnumber) {
        this.roomnumber = roomnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void Guest(int roomnumber,String name){
        this.name = name;
        this.roomnumber = roomnumber;
    }
}
