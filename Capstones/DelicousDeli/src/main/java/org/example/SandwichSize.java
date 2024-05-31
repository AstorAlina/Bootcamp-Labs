package org.example;

public enum SandwichSize {
    Small(5.5, 1, .50, .75, .30),
    Medium(7.0, 2.0, 1.0, 1.5, .60),
    Large(8.5, 3.0, 1.5, 2.25, .90),
    ;

    double basePrice;
    double meat;
    double extraMeat;
    double cheese;
    double extraCheese;

    SandwichSize(double basePrice, double meat, double extraMeat, double cheese, double extraCheese) {
        this.basePrice = basePrice;
        this.meat = meat;
        this.extraMeat = extraMeat;
        this.cheese = cheese;
        this.extraCheese = extraCheese;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getMeat() {
        return meat;
    }

    public double getExtraMeat() {
        return extraMeat;
    }

    public double getCheese() {
        return cheese;
    }

    public double getExtraCheese() {
        return extraCheese;
    }
}

