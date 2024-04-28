package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String filePath = "src/main/resources/products.csv";

    //instantiating array list
    public static List<Product> cartItems = new ArrayList<>();

    public static void addToCart() throws IOException {

        System.out.println("What is the SKU of the item you want to add to cart?");
        String sku = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // Skip header
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");

                if (data.length >= 1 && sku.equalsIgnoreCase(data[0])) {
                    // Create a Product object using the data from the file
                    String productName = data[1];
                    double price = Double.parseDouble(data[2]);
                    String department = data[3];
                    Product newProduct = new Product(sku, productName, price, department);

                    // Add the new product to the cart
                    cartItems.add(newProduct);

                    // Provide feedback to the user
                    System.out.println("Product added to cart: " + line);
                    return;
                }
            }

            // If SKU not found
            System.out.println("Product with SKU " + sku + " not found.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void removeFromCart() throws IOException {
        System.out.println("What is the SKU of the item you want to remove to cart?");
        String sku = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // Skip header
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");

                if (data.length >= 1 && sku.equalsIgnoreCase(data[0])) {
                    String productName = data[1];
                    double price = Double.parseDouble(data[2]);
                    String department = data[3];
                    Product newProduct = new Product(sku, productName, price, department);

                    // Add the new product to the cart
                    cartItems.remove(newProduct);


                    System.out.println("Product removed from cart: " + line);
                    return;


                }
            }
        }
    }

    public static void inCart (){
            if (cartItems.isEmpty()) {
                System.out.println("The cart is empty.");
            } else {
                System.out.println("Items in the cart:");
                for (Product product : cartItems) {
                    System.out.printf("Sku: %s, Name: %s, Price: $%.2f, Department: %s\n",
                            product.getSku(), product.getProductName(), product.getPrice(), product.getDepartment());
                    //("ID: %d, Title: %s, ISBN: %s, Checked Out?: %b, Who Checked Out: %s\n",
                    //                        book.getId(), book.getTitle(), book.getIsbn(), book.CheckedOut(), book.checkedOutTo);


                }
            }
        }

    public static void checkOut (){
        System.out.println("Would you like to check out?");
        String input = scanner.nextLine();

        if(input.equalsIgnoreCase("Yes")){
            inCart();
            cartTotal();

            System.out.println("Thank you for shopping, goodbye!");

        }

    }

    public static void cartTotal (){
        double total = 0;

        for (Product product : cartItems) {

            total += product.getPrice();

        }

        System.out.printf("Total price of items in cart: $%.2f\n", total);
    }
}

