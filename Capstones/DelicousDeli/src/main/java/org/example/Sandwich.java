package org.example;
import java.util.ArrayList;
import java.util.List;


public class Sandwich implements Orderable {
    private SandwichSize sandwichSize;
    private Bread bread;
    private Toppings toppings;
    private boolean isToasted;
    private List<String> customerToppings= new ArrayList<>();
    private int meatCounter = 0;
    private int cheeseCounter = 0;


    public Sandwich(SandwichSize sandwichSize, Bread bread, boolean isToasted) {
        this.sandwichSize = sandwichSize;
        this.bread = bread;
        this.toppings = toppings;
        this.isToasted = isToasted;



    }

    @Override
    public String toString() {
        return "Sandwich: size = '" + sandwichSize + "', bread = " + bread + ", isToasted = " + isToasted + ", All toppings = " + customerToppings;

    }



    public SandwichSize getSandwichSize() {
        return sandwichSize;
    }

    public void setSandwichSize(SandwichSize sandwichSize) {
        this.sandwichSize = sandwichSize;
    }

    public Bread getBread() {
        return bread;
    }

    public void setBread(Bread bread) {
        this.bread = bread;
    }

    public Toppings getToppings() {
        return toppings;
    }

    public void setToppings(Toppings toppings) {
        this.toppings = toppings;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public List<String> getCustomerToppings() {
        return customerToppings;
    }

    public void setCustomerToppings(List<String> customerToppings) {
        this.customerToppings = customerToppings;
    }

    @Override
    public double getPrice(){
        double sum = sandwichSize.basePrice;
        if(meatCounter >= 1 ){
            sum += sandwichSize.meat + (sandwichSize.extraMeat *(meatCounter - 1));
       }
        if(cheeseCounter >= 1){
            sum += sandwichSize.cheese + (sandwichSize.extraCheese *(cheeseCounter - 1));
        }

        //make sure to increment the counters on user input
        return sum;
    }
    public void addTopping(String toppingChoice) {
        //premium toppings
        //it was private
        if (Toppings.meat.contains(toppingChoice)) {
            meatCounter++;
        }
        else if(Toppings.cheese.contains(toppingChoice)) {
            cheeseCounter++;
        }

        this.customerToppings.add(toppingChoice);
    }


}



