package com.yacht.molvenorestaurant.model;

import java.time.LocalDate;

public class RestaurantReservation {

    private Table table;
    private String guestName;
    private LocalDate date;
    private int numberOfPeople;

    public RestaurantReservation(Table table, String guestName, LocalDate date, int numberOfPeople) {
        this.table = table;
        this.guestName = guestName;
        this.date = date;
        this.numberOfPeople = numberOfPeople;
    }

    public RestaurantReservation() {
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }
}
