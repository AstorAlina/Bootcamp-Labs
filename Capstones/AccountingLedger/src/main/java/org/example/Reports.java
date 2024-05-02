package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import static org.example.Ledger.reader;

public class Reports {
    private static final Scanner scanner = new Scanner(System.in);
    static String fileName = "src/main/resources/transactions.csv";

    public static void monthToDate() {
        ArrayList<Transaction> transactions = reader();

        //From month to date, meaning month 5th to 1st date?
        //greater than or equal to the first day of the month, but no greater than today

        LocalDate today = LocalDate.now();
        LocalDate firstDayOfMonth = today.withDayOfMonth(1);
        System.out.println("Month to date:" + firstDayOfMonth);

        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transaction transaction = transactions.get(i);
            LocalDate transactionDate = transaction.getDateTime().toLocalDate();
            if (transactionDate.equals(firstDayOfMonth) || transactionDate.isAfter(firstDayOfMonth)) {
                System.out.println(transaction);
            }
        }

    }

    public static void previousMonth() throws IOException {
        ArrayList<Transaction> transactions = reader();

        LocalDate today = LocalDate.now();
        LocalDate previousMonth = today.minusMonths(1);
        LocalDate firstDayOfMonth = today.withDayOfMonth(1);

        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transaction transaction = transactions.get(i);
            LocalDate transactionDate = transaction.getDateTime().toLocalDate();
            if (transactionDate.isAfter(previousMonth) && transactionDate.isBefore(firstDayOfMonth)) {
                System.out.println(transaction);
            }
        }

    }

    public static void yearToDate() {
        ArrayList<Transaction> transactions = reader();

        LocalDate today = LocalDate.now();
        LocalDate firstDayOfYear = today.minusYears(1);

        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transaction transaction = transactions.get(i);
            LocalDate transactionDate = transaction.getDateTime().toLocalDate();
            if (transactionDate.equals(firstDayOfYear) || transactionDate.isAfter(firstDayOfYear)) {
                System.out.println(transaction);
            }

        }
    }

    public static void previousYear() {
        ArrayList<Transaction> transactions = reader();

        LocalDate today = LocalDate.now();
        LocalDate firstDayOfThisYear = today.withDayOfYear(1);
        LocalDate firstDayOfLastYear = today.withDayOfYear(1).minusYears(1);
        System.out.println("Last year:" + firstDayOfLastYear);
        System.out.println("This year" + firstDayOfThisYear);


        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transaction transaction = transactions.get(i);
            LocalDate transactionDate = transaction.getDateTime().toLocalDate();
            if (transactionDate.isAfter(firstDayOfLastYear) && transactionDate.isBefore(firstDayOfThisYear)) {
                System.out.println(transaction);
            }

        }
    }
    public static void searchByVendor(){
        ArrayList<Transaction> transactions = reader();

        System.out.println("Enter vendor name to search:");
        String keyword = scanner.nextLine();

        for (int i = transactions.size() - 1; i >= 0; i--) {
            if(transactions.get(i).getVendor().equalsIgnoreCase(keyword)){
                System.out.println(transactions.get(i));
            }
        }

    }
}




















