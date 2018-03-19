package com.yacht.molvenorestaurant.business;

import com.yacht.molvenorestaurant.model.RestaurantReservation;

import java.util.ArrayList;

public class ReservationManager {

    private ArrayList<RestaurantReservation> reservationList;

    public void addIngredient(RestaurantReservation ingredient) {
        reservationList.add(ingredient);
    }

    public void removeIngredient(RestaurantReservation ingredient){
        reservationList.remove(ingredient);
    }

    public void updateIngredient(RestaurantReservation ingredient, String guestName) {
        for (RestaurantReservation oldIngredient : reservationList) {
            if (oldIngredient.getGuestName().equals(guestName)) {
                reservationList.add(reservationList.indexOf(oldIngredient), ingredient);
            }
        }
    }
}
