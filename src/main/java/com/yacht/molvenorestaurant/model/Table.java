package com.yacht.molvenorestaurant.model;

public class Table {

    private int tableID;
    private boolean isOccupied;
    private int numberOfSeats;

    public Table(int tableID, boolean isOccupied, int numberOfSeats) {
        this.tableID = tableID;
        this.isOccupied = isOccupied;
        this.numberOfSeats = numberOfSeats;
    }

    public Table() {
    }

    public int getTableID() {
        return tableID;
    }

    public void setTableID(int tableID) {
        this.tableID = tableID;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
