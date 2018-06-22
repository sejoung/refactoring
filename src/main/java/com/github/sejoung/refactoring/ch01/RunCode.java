package com.github.sejoung.refactoring.ch01;

import static com.github.sejoung.refactoring.ch01.Movie.NEW_RELEASE;

class RunCode {

    public static void main(String[] args) {
        Customer customer = new Customer("세중");
        Movie movie = new Movie("잼있는 놀이", NEW_RELEASE);
        Rental rental = new Rental(movie, 10);
        customer.addRentals(rental);
        System.out.println(customer.statement());
    }
}
