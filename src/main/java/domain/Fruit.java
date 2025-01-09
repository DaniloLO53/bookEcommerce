package domain;

import domain.enums.Taxes;

public class Fruit extends Product {
    private String expirationDate;

    public Fruit(String name, double price) {
        super(name, price);
    }

    @Override
    public double calculateTax() {
        return this.price * Taxes.FRUIT.TAX_PERCENTAGE;
    }

    @Override
    public void checkExpirationDate(String name, String expirationDate) {
        super.checkExpirationDate(name, expirationDate);
    }

    // so that we don't need to pass "name" to checkExpirationDate
    public void checkExpirationDate() {
        checkExpirationDate(this.name, this.expirationDate);
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
