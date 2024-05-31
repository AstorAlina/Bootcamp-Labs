package org.example;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static org.example.Chips.chipFlavors;
import static org.example.Drink.drinkFlavor;
import static org.example.Toppings.*;
//use indexes

public class Screens {

    //make sure to increment the counters on user input
    private static Orders orders = new Orders();
    static Scanner scanner = new Scanner(System.in);

    public static void homeScreen() {
        System.out.println("Welcome to Alina's Deli:");
        System.out.println("(1) New Order");
        System.out.println("(0) Exit");

        String input = scanner.nextLine();

        switch (input.toUpperCase()) {
            case "1":
                orderScreen();
                break;
            case "0":
                System.exit(0);
                break;
            default:
                System.out.println("Incorrect Input ≽^•⩊•^≼");
                homeScreen();
        }
    }

    public static void orderScreen() {
        while (true) {
            try {
                System.out.println("(1) Add Sandwich");
                System.out.println("(2) Add Drinks");
                System.out.println("(3) Add Chips");
                System.out.println("(4) Checkout");
                System.out.println("(0) Cancel Order"); //delete the order and go back to the home page

                String input2 = scanner.nextLine();

                switch (input2.toUpperCase()) {
                    case "1":
                        addSandwich();
                        break;
                    case "2":
                        addDrinks();
                        break;
                    case "3":
                        addChips();
                        break;
                    case "4":
                        userCheckout();
                        break;
                    case "0":
                        //delete the order and goes back to homescreen
                        homeScreen();
                        break;
                    default:
                        System.out.println("Incorrect Input ≽^•⩊•^≼");
                        homeScreen();
                }
            } catch (Exception e) {
                System.out.println("Thats not an option!");
            }
        }
    }

    public static void addSandwich() {
        while (true) {
            try {
                System.out.println("Please choose an option for bread:");
                int count = 1;
                for (Bread bread : Bread.values()) {
                    System.out.println("(" + count + ") " + bread.name());
                    count++;
                }
                int breadOption = Integer.parseInt(scanner.nextLine());
                Bread typeOfBread = Bread.values()[breadOption]; //<--------
                //set the option the user chose
                System.out.println("Please choose a size:");
                int counter = 1;
                for (SandwichSize sandwichSize : SandwichSize.values()) {
                    System.out.println("(" + counter + ") " + sandwichSize.name());
                    counter++;
                }
                String breadSize = scanner.nextLine();
                SandwichSize size = SandwichSize.values()[Integer.parseInt(breadSize) - 1];

                boolean isToasted = false;
                System.out.println("Would you like your sandwich toasted?");
                String toasted = scanner.nextLine();
                if (toasted.equalsIgnoreCase("yes")) {
                    isToasted = true;
                } else {
                    System.out.println("No toasting for you!");
                }
                Sandwich sandwich = new Sandwich(size, typeOfBread, isToasted); //<------
                addToppings(sandwich);
                orders.sandwiches.add(sandwich);
                System.out.println("--------------------------------------");
                break;
            } catch (Exception e) {
                System.out.println("Thats not an option!");
            }
        }
    }

    public static void addToppings(Sandwich sandwich) {
        boolean addTopping = true;
        while (addTopping) {
            try {
                System.out.println("Please choose toppings to add:");
                System.out.println("(1) Add Meat");
                System.out.println("(2) Add Cheese");
                System.out.println("(3) Add Veggies");
                System.out.println("(4) Add Sauces");
                System.out.println("(5) Order Screen");
                String input3 = scanner.nextLine();

                switch (input3.toUpperCase()) {
                    case "1":
                        addMeat(sandwich);
                        break;
                    case "2":
                        addCheese(sandwich);
                        break;
                    case "3":
                        addVeggies(sandwich);
                        break;
                    case "4":
                        addSauce(sandwich);
                        break;
                    case "5":
                        addTopping = false;
                        break;
                    default:
                        System.out.println("Incorrect Input ≽^•⩊•^≼");
                        homeScreen();
                }
            } catch (Exception e) {
                System.out.println("Not an option!");
            }

        }
    }

    public static void addMeat(Sandwich sandwich) {
        while (true) {
            try {
                System.out.println("Please select a meat:");
                displayWithNumbers(meat);
                int meatChoice = Integer.parseInt(scanner.nextLine());
                if (!((meatChoice - 1) > meat.size())) {

                    sandwich.addTopping(meat.get(meatChoice - 1));
                } else {
                    System.out.println("That's not an option!");
                    continue;
                }

                System.out.println("Would you like to add more meat?");
                String moreMeat = scanner.nextLine();
                if (moreMeat.equalsIgnoreCase("yes")) {
                    continue;
                }
                if (moreMeat.equalsIgnoreCase("no")) {
                    break;
                } else {
                    System.out.println("That's not a meat!");
                }
            } catch (Exception e) {
                System.out.println("That's not an option dawg!");
            }
        }
    }

    public static void addCheese(Sandwich sandwich) {
        while (true) {
            try {
                System.out.println("Please select a cheese:");
                displayWithNumbers(cheese);
                int cheeseChoice = Integer.parseInt(scanner.nextLine());
                if (!((cheeseChoice - 1) > cheese.size())) {

                    sandwich.addTopping(cheese.get(cheeseChoice - 1));
                } else {
                    System.out.println("That's not an option!");
                    continue;
                }

                System.out.println("Would you like to add more cheese?");
                String moreCheese = scanner.nextLine();
                if (moreCheese.equalsIgnoreCase("yes")) {
                    continue;
                }
                if (moreCheese.equalsIgnoreCase("no")) {
                    break;
                } else {
                    System.out.println("That's not a cheese!");
                }
            } catch (Exception e) {
                System.out.println("That's not an option dawg!");
            }
        }
    }

    public static void addVeggies(Sandwich sandwich) {
        while (true) {
            try {
                System.out.println("Please select a veggie:");
                displayWithNumbers(veggies);
                int vegChoice = Integer.parseInt(scanner.nextLine());
                if (!((vegChoice - 1) > veggies.size())) {

                    sandwich.addTopping(veggies.get(vegChoice - 1));
                } else {
                    System.out.println("That's not an option!");
                    continue;
                }

                System.out.println("Would you like to add more veggie?");
                String moreVeg = scanner.nextLine();
                if (moreVeg.equalsIgnoreCase("yes")) {
                    continue;
                }
                if (moreVeg.equalsIgnoreCase("no")) {
                    break;
                } else {
                    System.out.println("That's not a veggie!");
                }
            } catch (Exception e) {
                System.out.println("That's not an option dawg!");
            }
        }
    }

    public static void addSauce(Sandwich sandwich) {
        while (true) {
            try {
                System.out.println("Please select a sauce:");
                displayWithNumbers(sauce);
                int meatChoice = Integer.parseInt(scanner.nextLine());
                if (!((meatChoice - 1) > sauce.size())) {

                    sandwich.addTopping(sauce.get(meatChoice - 1));
                } else {
                    System.out.println("That's not an option!");
                    continue;
                }

                System.out.println("Would you like to add more sauce?");
                String moreSauce = scanner.nextLine();
                if (moreSauce.equalsIgnoreCase("yes")) {
                    continue;
                }
                if (moreSauce.equalsIgnoreCase("no")) {
                    break;
                } else {
                    System.out.println("That's not a Sauce!");
                }
            } catch (Exception e) {
                System.out.println("That's not an option dawg!");
            }
        }
    }

    public static void addDrinks() {
        while (true) {
            try {
                System.out.println("Select Drink Size:");
                int count = 1;
                for (DrinkSize drinkSize : DrinkSize.values()) {
                    System.out.println("(" + count + ") " + drinkSize.name());
                    count++;
                }
                int input3 = Integer.parseInt(scanner.nextLine());
                System.out.println("---------------------");
                System.out.println("Select Drink Flavor:");
                int count2 = 1;
                for (String drinkFlavor : drinkFlavor) {
                    System.out.println("(" + count2 + ") " + drinkFlavor);
                    count2++;
                }
                //Orders orders = new Orders(); // <-- does this go here
                String drinkChose = scanner.nextLine();
                //System.out.println(drinkFlavor.get(Integer.parseInt(drinkChose)));
                Drink drink = new Drink(DrinkSize.values()[input3 - 1], drinkChose);
                orders.drinks.add(drink);
                orderScreen();
            } catch (Exception e) {
                System.out.println("That's not an option dawg!");
            }
        }
    }

    public static void addChips() {
        while (true) {
            try {
                System.out.println("Select Chip Flavor:");
                int count3 = 1;
                for (String chipFlavor : chipFlavors) {
                    System.out.println("(" + count3 + ") " + chipFlavor);
                    count3++;
                }
                String chipChose = scanner.nextLine();
                Chips chips = new Chips(chipChose);
                orders.chips.add(chips);
                orderScreen();
            } catch (Exception e) {
                System.out.println("That's not an option dawg!");
            }
        }
    }

    public static void userCheckout() {
        //- display the order details and the price
        //Confirm - create the receipt file and go back to the home screen
        // Cancel - delete order and go back to the home screen
        System.out.println("(1) Display Order");
        System.out.println("(2) Confirm Order");
        System.out.println("(3) Cancel Order");
        String input = scanner.nextLine();

        switch (input.toUpperCase()) {
            case "1":
                displayOrder();
                break;
            case "2":
                confirmOrder();
                break;
            case "3":
                cancelOrder();
                break;
            default:
                System.out.println("Incorrect Input ≽^•⩊•^≼");
                homeScreen();

        }
    }

    public static void displayOrder() {
        for(Sandwich orders : orders.getSandwiches()){
            System.out.println(orders);
            System.out.println(orders.getPrice());
        }
        for(Chips chipOrder : orders.getChips()){
            System.out.println(chipOrder);
            System.out.println(chipOrder.getPrice());
        }
        for(Drink drinkOrder : orders.getDrinks()){
            System.out.println(drinkOrder);
            System.out.println(drinkOrder.getPrice());

        };
    }
    public static void confirmOrder() {
        Receipts.writeToFile(orders);
        System.out.println("Order is completed!");
    }

    public static void cancelOrder(){
    orders = new Orders();
    homeScreen();
    }



    public static <T> void displayWithNumbers(List<T> list){
        for (int i = 0; i < list.size(); i++) {
            T item = list.get(i);
            System.out.println("("+ (i + 1) + ") " + item);
            }
        }
    }




