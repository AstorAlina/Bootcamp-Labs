package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileManager {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String filePath = "src/main/resources/products.csv";


    public static void displayProducts() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void searchByName () throws IOException {
        System.out.println("Enter product name to search:");
        String keyword = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // Skip header
            String line;

            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains(keyword)) {
                    System.out.println(line);
                }
            }
        } catch (IOException ex) {
        }
        Screens.ifAddToCart();
        Screens.homeScreen();

    }


    public static void searchByDepartment() throws IOException {
        System.out.println("Enter department to search:");
        String keyword = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // Skip header
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");

                if (data.length >= 4 && keyword.equalsIgnoreCase(data[3])) {
                    System.out.println("Sku: " + data[0] + " " + "Name: " + data[1] + " " + "Price: " + data[2] + " " + "Department: " + data[3]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public static void searchByPrice () {
            System.out.println("Enter the minimum price:");
            double minPrice = scanner.nextDouble();

            System.out.println("Enter the maximum price:");
            double maxPrice = scanner.nextDouble();

            scanner.nextLine(); // Consume newline

            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                br.readLine(); // Skip header
                String line;

                while ((line = br.readLine()) != null) {
                    String[] data = line.split("\\|");
                    if (data.length >= 3) {
                        double price = Double.parseDouble(data[2]);
                        if (price >= minPrice && price <= maxPrice) {
                            System.out.println("Product: " + data[1] + " Price: " + data[2]);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;


        }

}

