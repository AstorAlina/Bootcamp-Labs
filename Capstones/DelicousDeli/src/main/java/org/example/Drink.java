package org.example;

import java.util.Arrays;
import java.util.List;

public class Drink implements Orderable{
    public static final List<String> drinkFlavor = Arrays.asList("Cola","Pepsi");
    private DrinkSize size;
    private String flavor;

    public Drink(DrinkSize size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    @Override
    public String toString() {
        return "Drink : size = '" + size + "', flavor = " + drinkFlavor.get(Integer.parseInt(flavor) - 1);
    }

    public DrinkSize getSize() {
        return size;
    }

    public void setSize(DrinkSize size) {
        this.size = size;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public double getPrice(){
        return size.getPrice();
    }

}

