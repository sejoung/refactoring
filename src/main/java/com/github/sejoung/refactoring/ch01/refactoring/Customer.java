package com.github.sejoung.refactoring.ch01.refactoring;

import java.util.Vector;

public class Customer {
    private String _name;
    private Vector<Rental> _rentals = new Vector<Rental>();

    public Customer(String name) {
        _name = name;
    }

    public void addRetal(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {

        String result = "Rental Record for " + getName() + "\n";

        for (Rental each : _rentals) {
            // 이 대여에 대한 요금 계산 결과 표시
            result += "\t" + each.getMovie().getTitle() + "\t" +
                    String.valueOf(each.getCharge()) + "\n";
        }

        //footer 추가
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) +
                "frequent renter points";

        return result;
    }

    private double getTotalCharge() {

        double result = 0;

        for (Rental each : _rentals) {
            result += each.getCharge();
        }

        return result;
    }

    private int getTotalFrequentRenterPoints() {

        int result = 0;

        for (Rental each : _rentals) {
            result += each.getFrequentRenterPoints();
        }

        return result;
    }

}