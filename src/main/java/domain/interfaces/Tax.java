package domain.interfaces;

public interface Tax {
    double calculateTax();

    // With the default keyword we don't need to implement this method
    // In our case, we just need this method on Fruit class
    default void checkExpirationDate(String name, String expirationDate) {
        System.out.println("Checking tax for " + name);
        System.out.println(expirationDate);
    }
}
