package org.example;

public enum DrinkSize {
    Small(2),
    Medium(2.5),
    Large( 3.0),
   ;

    private final double price;
    DrinkSize(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
