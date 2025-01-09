package domain;

public class Book extends Product {
    public Book(String name, double price) {
        super(name, price);
    }

    @Override
    public double calculateTax() {
        return this.price * 0.1;
    }
}
