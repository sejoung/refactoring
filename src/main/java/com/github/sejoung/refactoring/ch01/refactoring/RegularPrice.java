package com.github.sejoung.refactoring.ch01.refactoring;

public class RegularPrice extends Price {

    public int getPriceCode() {
        return Movie.REGULAR;
    }

    public double getCharge(int daysRented) {
        return daysRented * 3;
    }

}