package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //scanner
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello welcome to Alina's Mortage Calculator!");

        System.out.println("Please enter your principle:");
        double principle = scanner.nextDouble();

        System.out.println("Please enter your interest rate:");
        double interest = scanner.nextDouble();

        System.out.println("Please enter your loan length:");
        double loanLength = scanner.nextDouble();


        double monthlyInterestRate = monthlyInterestRate(interest);
        double loanLengthToMonths = loanLengthToMonths(loanLength);
        double monthlyPayment = monthlyPayment(principle, monthlyInterestRate, loanLengthToMonths);
        double totalInterest = totalInterest(monthlyPayment, loanLengthToMonths, principle);
        System.out.printf("Here is your monthly payment: $%.2f\n", monthlyPayment);
        System.out.printf("Here is your total interest paid: $%.2f\n", totalInterest);
        System.out.printf("Here is your loan length in months: %.0f\n", loanLengthToMonths);



    }

    public static double monthlyInterestRate(double interest) {
        double monthlyInterestRate = (interest / 12) / 100;
        return monthlyInterestRate;
    }

    public static double loanLengthToMonths(double loanLength) {
        double loanLengthToMonths = loanLength * 12;
        return loanLengthToMonths;

    }

    public static double monthlyPayment(double principle, double monthlyInterestRate, double loanLengthToMonths) {
        double monthlyPayment = principle * (monthlyInterestRate * (Math.pow((1 + monthlyInterestRate), loanLengthToMonths) / (Math.pow(1 + monthlyInterestRate, loanLengthToMonths) - 1)));
        return monthlyPayment;
    }

    public static double totalInterest(double monthlyPayment, double loanLengthToMonths, double principle) {
        double totalInterest = (monthlyPayment * loanLengthToMonths) - principle;
        return totalInterest;
    }


}




