package domain;

public class Fruit extends Product {
    private String expirationDate;

    public Fruit(String name, double price) {
        super(name, price);
    }

    @Override
    public double calculateTax() {
        return this.price * 0.05;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
