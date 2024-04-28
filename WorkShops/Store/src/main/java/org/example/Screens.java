package org.example;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.io.IOException;
import java.util.Scanner;

public class Screens {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        homeScreen();
    }

    public static void homeScreen() throws IOException {
        System.out.println("Welcome to Alina's Store!:");
        System.out.println("(1) Display Products");
        System.out.println("(2) Display Cart");
        System.out.println("(3) Exit");

        String input = scanner.nextLine();

        switch (input) {
            case "1":
                FileManager.displayProducts();
                homeOptions();
                break;
            case "2":
                displayCart();
                break;
            case "3":
                System.exit(0);
                break;
            default:
                System.out.println("Incorrect Input");
        }
    }

    public static void homeOptions() throws IOException {
        System.out.println("Please select an option:");
        System.out.println("(1) Search Products");
        System.out.println("(2) Add To Cart");
        System.out.println("(3) Back To Home Screen");

        String input = scanner.nextLine();

        switch (input) {
            case "1":
                searchProducts();
                break;
            case "2":
                ShoppingCart.addToCart();
                homeScreen();
                break;
            case "3":
                homeScreen();
                break;
            default:
                System.out.println("Invalid");
        }
    }

    public static void searchProducts() throws IOException {
        System.out.println("How would you like to search?");
        System.out.println("(1) By product name");
        System.out.println("(2) By department");
        System.out.println("(3) By price");

        String input = scanner.nextLine();

        switch (input) {
            case "1":
                FileManager.searchByName();
                break;
            case "2":
                FileManager.searchByDepartment();
                break;
            case "3":
                FileManager.searchByPrice();
                break;
            default:
                System.out.println("Invalid");
                break;

        }
    }

    public static void ifAddToCart() throws IOException {
        System.out.println("Would you like to add one of these items to cart?");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("Yes")) {
            ShoppingCart.addToCart();
        }
    }

    public static void displayCart() throws IOException {
        ShoppingCart.inCart();

        System.out.println("(1) Check out");
        System.out.println("(2) Remove product from cart");
        System.out.println("(3) Home Screen");

        String input = scanner.nextLine();

        switch (input) {
            case "1":
                ShoppingCart.checkOut();
                break;
            case "2":
                ShoppingCart.removeFromCart();
                break;
            case "3":
                homeScreen();
                break;

            default:
                System.out.println("Invalid");
                break;
        }


    }
}