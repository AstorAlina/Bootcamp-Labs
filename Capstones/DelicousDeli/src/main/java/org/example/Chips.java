package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Chips implements Orderable {
    public static final List<String> chipFlavors = Arrays.asList("Lays Original", "Lays BBQ");
    private String type;
    private final double price = 1.5;

    public static void stringChips(){
        String chipFlavorsString = String.join(", ", chipFlavors);
    }

    public Chips(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Chips : flavor = " + chipFlavors.get(Integer.parseInt(type) - 1);
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public static List<String> getChipFlavors() {
        return chipFlavors;
    }
}
