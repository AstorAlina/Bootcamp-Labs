package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //scanner
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello welcome to Alina's Future Value Calculator!");

        System.out.println("Please enter your deposit amount:");
        double initialDeposit = scanner.nextDouble();

        System.out.println("Please enter your interest rate:");
        double annualInterest = scanner.nextDouble();

        System.out.println("Please enter the number of years:");
        double numberOfYears = scanner.nextDouble();

        //calling functions
        double dailyinterestRate = dailyinterestRate(annualInterest);
//        System.out.printf("Here is your daily interest rate: $%.2f\n", dailyinterestRate);

        double futureValue = futureValue(initialDeposit, annualInterest, numberOfYears);
        System.out.printf("Here is your future value: $%.2f\n", futureValue);

        double totalInterest = totalInterest(futureValue, initialDeposit);
        System.out.printf("Here is your total interest: $%.2f\n", totalInterest);


    }
    //functions
    public static double dailyinterestRate(double annualInterest) {
        double dailyinterestRate = (annualInterest / 365 / 100);
        return dailyinterestRate;
    }

    public static double futureValue(double initalDeposit, double annualInterest, double numberOfYears) {
        return Math.pow(1 + (annualInterest / 365 /100), (365 * numberOfYears)) * initalDeposit;


        //FV = initalDeposit((1 + (annualInterest/365))^(365*numberOfYears))

    }

    public static double totalInterest (double futureValue, double initialDeposit) {
        double totalInterest = futureValue - initialDeposit;
        return totalInterest;
    }
}

//end of program