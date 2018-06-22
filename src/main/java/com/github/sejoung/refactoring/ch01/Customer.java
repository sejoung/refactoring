package com.github.sejoung.refactoring.ch01;

import java.util.Vector;

import static com.github.sejoung.refactoring.ch01.Movie.*;

class Customer {
    private final String name;
    private final Vector<Rental> rentals = new Vector<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRentals(Rental rental) {
        this.rentals.add(rental);
    }

    private String getName() {
        return name;
    }

    public String statement() {

        double totalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder result = new StringBuilder(this.getName() + " 고객님의 대여 기록 \n");

        for (Rental rental : this.rentals) {
            double thisAmount = 0;
            switch (rental.getMovie().getPriceCode()) {
                case REGULAR:
                    thisAmount += 2;
                    if (rental.getDaysRented() > 2)
                        thisAmount += (rental.getDaysRented() - 2) * 1.5;
                    break;
                case NEW_RELEASE:
                    thisAmount += rental.getDaysRented() * 3;
                    break;
                case CHILDRENS:
                    thisAmount += 1.5;
                    if (rental.getDaysRented() > 3)
                        thisAmount += (rental.getDaysRented() - 3) * 1.5;
                    break;
            }

            frequentRenterPoints++;

            if ((rental.getMovie().getPriceCode() == NEW_RELEASE) && rental.getDaysRented() > 1)
                frequentRenterPoints++;

            result.append("\t").append(rental.getMovie().getTitle()).append("\t").append(String.valueOf(thisAmount)).append("\n");

            totalAmount += thisAmount;
        }

        result.append("누적 대여료 : ").append(String.valueOf(totalAmount)).append("\n");
        result.append("적립 포인트 : ").append(String.valueOf(frequentRenterPoints));
        return result.toString();
    }


}
