package domain.enums;

public enum Taxes {
    FRUIT(0.05),
    BOOK(0.1);

    public final double TAX_PERCENTAGE;

    Taxes(double taxPercentage) {
        this.TAX_PERCENTAGE = taxPercentage;
    }
}
