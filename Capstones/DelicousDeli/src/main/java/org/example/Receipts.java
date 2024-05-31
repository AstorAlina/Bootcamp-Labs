package org.example;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipts {

    public static void writeToFile(Orders orders){
        // Create a unique filename based on the current timestamp
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String timestamp = LocalDateTime.now().format(formatter);
        String filename = "src/main/" + timestamp + ".txt";

        // Create BufferedWriter to write to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for(Sandwich orders1 : orders.getSandwiches()){
                writer.write(orders1.toString());
                writer.newLine();
                writer.write("Price: ");
                writer.write(Double.toString(orders1.getPrice()));
                writer.newLine();

            }
            for(Chips chipOrder : orders.getChips()){
                writer.write(chipOrder.toString());
                writer.newLine();
                writer.write("Price: ");
                writer.write(Double.toString(chipOrder.getPrice()));
                writer.newLine();
            }
            for(Drink drinkOrder : orders.getDrinks()){
                writer.write(drinkOrder.toString());
                writer.newLine();
                writer.write("Price: ");
                writer.write(Double.toString(drinkOrder.getPrice()));

            };
        } catch (IOException e) {
            System.out.println("There's nothing in the order!");
        }

        System.out.println("Written to file: " + filename);


    }
}

