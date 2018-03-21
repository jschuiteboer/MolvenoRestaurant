package com.yacht.molvenorestaurant.model;

import java.util.List;

public class Guest {
    private int roomnumber;
    private String name;
    private List<Bill> bills;

    public Guest(int roomnumber, String name, List<Bill> bills) {
        this.roomnumber = roomnumber;
        this.name = name;
        this.bills = bills;
    }

    public Guest() {
    }

    public int getRoomnumber() {
        return roomnumber;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
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


}
