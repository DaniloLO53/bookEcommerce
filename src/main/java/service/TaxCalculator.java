package service;

import domain.Product;

public class TaxCalculator {
    public static void generateTaxReport(Product product) {
        System.out.println("Product name: " + product.getName());
        System.out.println("Product price: " + product.getPrice());
        System.out.println("Product tax: " + product.calculateTax());
    }
}
