package org.example;

import java.text.BreakIterator;
import java.util.Scanner;

import static org.example.Screens.book;

public class Main {
    public static void main(String[] args) {
        //was a loop of homescreen
        Screens.setupBookInventory();
        homeScreen();
        }


        public static void homeScreen() {
            Scanner scanner = new Scanner(System.in);
//            Screens.setupBookInventory();

            System.out.println("Welcome to Alina's Library! Please select an option: ");
            System.out.println("(1) View Available Books");
            System.out.println("(2) View Checked-Out Books");
            System.out.println("(3) Exit");

            var input = scanner.nextLine();

            switch (input) {
                case "1":
                    Screens.showAvailableBooks();
                    break;
                case "2":
                    Screens.checkedOutBooks();

                case "3":
                    System.exit(0);
                    break;


                default:
                    System.out.println("Incorrect Input");
            }

        }
    }





