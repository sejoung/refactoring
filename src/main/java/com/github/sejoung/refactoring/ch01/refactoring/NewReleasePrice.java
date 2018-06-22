package com.github.sejoung.refactoring.ch01.refactoring;

public class NewReleasePrice extends Price {

    public int getPriceCode() {
        return Movie.NEWRELEASE;

    }

    public double getCharge(int daysRented) {
        double result = 2;
        if (daysRented > 2)
            result += (daysRented - 2) * 1.5;
        return result;
    }

    public int getFrequentRenterPoints(int daysRented) {
        return (daysRented > 1) ? 2 : 1;
    }

}