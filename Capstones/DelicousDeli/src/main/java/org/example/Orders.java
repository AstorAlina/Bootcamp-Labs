package org.example;
import java.util.ArrayList;
import java.util.List;

public class Orders {
    public List<Sandwich> sandwiches;
    public List<Drink> drinks;
    public List<Chips> chips;
    public double totalPrice;

        public Orders() {
            this.sandwiches = new ArrayList<>();
            this.drinks = new ArrayList<>();
            this.chips = new ArrayList<>();
            this.totalPrice = 0.0;
        }


    public void setSandwiches(List<Sandwich> sandwiches) {
        this.sandwiches = sandwiches;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

    public void setChips(List<Chips> chips) {
        this.chips = chips;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public List<Chips> getChips() {
        return chips;
    }

    public double getTotalPrice() {
            return totalPrice;
    }

    //
//        // Other methods...
//        public void addChips(Chips chips) {
//            this.chips.add(chips);
//            totalPrice += chips.getPrice();
//            System.out.println("Chips added to the order: " + chips.getType());
//        }
//
//        // Getter for totalPrice
//        public double getTotalPrice() {
//            return totalPrice;
//        }
    }

