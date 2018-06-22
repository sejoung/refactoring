package com.github.sejoung.refactoring.ch01.refactoring;


import static com.github.sejoung.refactoring.ch01.refactoring.Movie.NEWRELEASE;

class RunCode {

    public static void main(String[] args) {
        Customer customer = new Customer("세중");
        Movie movie = new Movie("잼있는 놀이", NEWRELEASE);
        Rental rental = new Rental(movie, 10);
        customer.addRetal(rental);
        System.out.println(customer.statement());
    }
}
