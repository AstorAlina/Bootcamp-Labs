package org.example;
import java.util.Scanner;

public class MortageCalculator {

    //constructor
    public MortageCalculator () {
            //scanner
            Scanner scanner = new Scanner(System.in);
            System.out.println("Hello welcome to Alina's Mortage Calculator!");

            System.out.println("Please enter your principle:");
            this.principle = scanner.nextDouble();

            System.out.println("Please enter your interest rate:");
            this.interest = scanner.nextDouble(); //<-- this. refers to the copy that is being made

            System.out.println("Please enter your loan length:");
            this.loanLength = scanner.nextDouble();


        monthlyInterestRate = monthlyInterestRate(interest);
        loanLengthToMonths = loanLengthToMonths(loanLength);
    }
    //properties
    private double principle;
    private double interest;
    private double loanLength;
    double monthlyInterestRate;
    double loanLengthToMonths;
    //double monthlyPayments;
    // double totalInterest;

    //methods or methods
        public static double monthlyInterestRate(double interest) {
            double monthlyInterestRate = (interest / 12) / 100;
            return monthlyInterestRate;
        }

        public static double loanLengthToMonths(double loanLength) {
            double loanLengthToMonths = loanLength * 12;
            return loanLengthToMonths;

        }

        public double monthlyPayment() {
            double monthlyPayment = this.principle * (this.monthlyInterestRate * (Math.pow((1 + this.monthlyInterestRate), this.loanLengthToMonths) / (Math.pow(1 + this.monthlyInterestRate, this.loanLengthToMonths) - 1)));
            return monthlyPayment;
        }

        public double totalInterest() {
            double totalInterest = (this.monthlyPayment() * this.loanLengthToMonths) - this.principle;
            return totalInterest;
        }


//
//            //scanner
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Hello welcome to Alina's Mortage Calculator!");
//
//            System.out.println("Please enter your principle:");
//            double principle = scanner.nextDouble();
//
//            System.out.println("Please enter your interest rate:");
//            double interest = scanner.nextDouble();
//
//            System.out.println("Please enter your loan length:");
//            double loanLength = scanner.nextDouble();
//
//            //Method Invocation & Variable Assignment
//            double monthlyInterestRate = monthlyInterestRate(interest);
//            double loanLengthToMonths = loanLengthToMonths(loanLength);

//            double monthlyPayment = monthlyPayment(principle, monthlyInterestRate, loanLengthToMonths);
//            double totalInterest = totalInterest(monthlyPayment, loanLengthToMonths, principle);
//
//            //print statement
//            System.out.printf("Here is your monthly payment: $%.2f\n", monthlyPayment);
//            System.out.printf("Here is your total interest paid: $%.2f\n", totalInterest);
//            System.out.printf("Here is your loan length in months: %.0f\n", loanLengthToMonths);
//
//
//
//        }
//        //methods or methods
//        public static double monthlyInterestRate(double interest) {
//            double monthlyInterestRate = (interest / 12) / 100;
//            return monthlyInterestRate;
//        }
//
//        public static double loanLengthToMonths(double loanLength) {
//            double loanLengthToMonths = loanLength * 12;
//            return loanLengthToMonths;
//
//        }
//
//        public static double monthlyPayment(double principle, double monthlyInterestRate, double loanLengthToMonths) {
//            double monthlyPayment = principle * (monthlyInterestRate * (Math.pow((1 + monthlyInterestRate), loanLengthToMonths) / (Math.pow(1 + monthlyInterestRate, loanLengthToMonths) - 1)));
//            return monthlyPayment;
//        }
//
//        public static double totalInterest(double monthlyPayment, double loanLengthToMonths, double principle) {
//            double totalInterest = (monthlyPayment * loanLengthToMonths) - principle;
//            return totalInterest;
//        }
//
//





}
