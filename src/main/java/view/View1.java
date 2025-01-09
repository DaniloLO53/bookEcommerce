package view;

import domain.Book;
import domain.Fruit;
import domain.Product;
import service.TaxCalculator;

public class View1 {
    public static void main(String[] args) {
        Book book = new Book("Calculus 1", 120.99);
        Product tomato1 = new Fruit("American Potato", 6.57); // polymorphism
        Fruit tomato2 = new Fruit("American Potato", 6.57); //

        // it does not work because tomato1 is of type Product, and Product, in turn, implements Tax
        // the compiler only sees the methods of Product (and its interfaces); it doesn't see the methods of Fruit
        // it means that compiler can't recognize the method overload of checkExpirationDate() without parameters
        // even though checkExpirationDate is default, it's still on the contract, so it needs to be used strictly in
        // the way is declared on the interface
        // a workaround could be overloading the method on the interface instead of the Fruit class
//        tomato1.checkExpirationDate();

        tomato2.checkExpirationDate(); // it works
        tomato1.calculateTax();

        TaxCalculator.generateTaxReport(book);
    }
}
