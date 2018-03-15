package com.yacht.molvenorestaurant;

public class App {
    public static void main(String[] args) {
        int[][] twoD = { { 1, 2, 3} , { 4, 5, 6, 7}, { 8, 9, 10 } };
        System.out.print(twoD[1].length);
        System.out.print(twoD[2].getClass().isArray());
        System.out.print(twoD[1][2]);

    }
}
