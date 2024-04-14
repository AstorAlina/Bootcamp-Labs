package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello weclome to Alina's present value calculator");

        System.out.println("What is your monthly payout?");
        double monthlyPayout = scanner.nextDouble();

        System.out.println("What is your expected interest rate?");
        double interestRate = scanner.nextDouble();

        System.out.println("What are the years to payout?");
        double yearstoPayout = scanner.nextDouble();

        double monthlyInterest = monthlyInterest(interestRate);
        System.out.printf("Here is your monthly interest: $%.8f\n", monthlyInterest);

        double monthlyPayments = monthlyPayments(yearstoPayout);
        System.out.printf("Here is your monthly payments: $%.2f\n", monthlyPayments);

        double presentValue = presentValue(monthlyPayout, monthlyInterest, monthlyPayments);
        System.out.printf("Here is your present value: $%.5f\n", presentValue);


    }

    //functions
    public static double monthlyInterest(double interestRate) {
        double monthlyInterest = (interestRate / 100) /12;
        return monthlyInterest;
    }

    public static double monthlyPayments (double yearstoPayout) {
        double monthlyPayements = yearstoPayout * 12;
        return monthlyPayements;
    }

    public static double presentValue (double monthlyPayout, double monthlyInterest, double monthlyPayments) {
        double presentValue =  (monthlyPayout * (1 - Math.pow(1 + monthlyInterest,-240))) / monthlyInterest;
        return presentValue;
    }


}

//Formula: PV = PMT × [(1 - (1 + r)^(-n)) / r]
    //        monthlyPayout * (1-(1+monthlyInterest)(-monthlyPayments))/monthyIntrest)
//
//Where:
//
//    PV is the present value of the annuity.
//    PMT is the monthly payout amount.
//    r is the monthly interest rate (annual interest rate divided by 12 and then divided by 100 to convert to a decimal).
//    n is the total number of monthly payments (number of years to pay out multiplied by 12).
//
//Accept the monthly payout amount (PMT), expected interest rate (r), and number of years to pay out (t) from the user as input.
//
//Calculate the monthly interest rate (r) by dividing the annual interest rate by 12 and then dividing by 100 to convert it to a decimal.
//
//Calculate the total number of monthly payments (n) by multiplying the number of years to pay out by 12.
//
//Use the formula to calculate the present value (PV) of the annuity.
//
//Display the present value of the annuity to the user.