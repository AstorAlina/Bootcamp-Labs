package org.example;

public interface Orderable {

    public default double getPrice() {
        return 0;
    }

    //links all sellable items in the order
}
