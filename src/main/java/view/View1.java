package view;

import domain.Book;
import service.TaxCalculator;

public class View1 {
    public static void main(String[] args) {
        Book book = new Book("Calculus 1", 120.99);

        TaxCalculator.generateTaxReport(book);
    }
}
