package org.example;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        System.out.println("Enter the first numbers:");
        Scanner scanner = new Scanner(System.in);
        float firstNumber = scanner.nextFloat();

        System.out.println("Enter the second number:");
        float secondNumber = scanner.nextFloat();
        scanner.nextLine();


        System.out.println("Possible Calculations: (A)dd, (M)ultiply, (S)ubtract or (D)ivide:");
        String mathOption = scanner.nextLine();


        // block of code to be executed if the condition is true
        if (mathOption.equalsIgnoreCase("A")) {
            System.out.println(firstNumber + " + " + secondNumber + " = " + addTwoNumbers(firstNumber, secondNumber));

        } else if (mathOption.equalsIgnoreCase("S")) {
            System.out.println(firstNumber + " - " + secondNumber + " = " + subTwoNumbers(firstNumber, secondNumber));

        } else if (mathOption.equalsIgnoreCase("M")) {
            System.out.println(firstNumber + " * " + secondNumber + " = " + multiTwoNumbers(firstNumber, secondNumber));

        } else if (mathOption.equalsIgnoreCase("D")) {
            System.out.println(firstNumber + " / " + secondNumber + " = " + divTwoNumbers(firstNumber, secondNumber));
        }


    }

    // outside of main but inside your class
    public static float addTwoNumbers(float firstNumber, float secondNumber) {
        return firstNumber + secondNumber;

    }

    public static float subTwoNumbers(float firstNumber, float secondNumber) {
        return firstNumber - secondNumber;

    }

    public static float multiTwoNumbers(float firstNumber, float secondNumber) {
        return firstNumber * secondNumber;

    }

    public static float divTwoNumbers(float firstNumber, float secondNumber) {
        return firstNumber / secondNumber;
    }
}
//yay