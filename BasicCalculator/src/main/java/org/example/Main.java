package org.example;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {


        System.out.println("Enter the first numbers:");
        Scanner scanner = new Scanner(System.in);
        float firstNumber = scanner.nextFloat();
        scanner.nextLine();

        System.out.println("Enter the second number:");
        float secondNumber = scanner.nextFloat();
        scanner.nextLine();


        System.out.println("Possible Calculations: (A)dd, (M)ultiply, (S)ubtract or (D)ivide:");
        String mathOption = scanner.nextLine();

        // block of code to be executed if the condition is true
        if (mathOption.equalsIgnoreCase ("A")){
            System.out.println(firstNumber + " + " + secondNumber + " = " +(firstNumber+secondNumber));

        }

        else if (mathOption.equalsIgnoreCase("M")){
            System.out.println(firstNumber + " + " + secondNumber + " = " +(firstNumber*secondNumber));
        }

        else if (mathOption.equalsIgnoreCase("D")){
            System.out.println(firstNumber + " + " + secondNumber + " = " +(firstNumber/secondNumber));
        }

        else if (mathOption.equalsIgnoreCase("S")){
            System.out.println(firstNumber + " + " + secondNumber + " = " +(firstNumber-secondNumber));
        }








    }

}