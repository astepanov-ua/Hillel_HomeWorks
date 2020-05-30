package HW1;

import java.util.Scanner;

public class PrimitiveCalculator {
    public static void main(String[] args) {
        double numberOne, numberTwo;
        boolean hasNotResult = false;
        String alert = "Please, input correct data";
        String firstNumber = "Please, input first number: ";
        String secondNumber = "Please input second number: ";

        System.out.println(firstNumber);
        Scanner scanner1 = new Scanner(System.in);
        if (!scanner1.hasNext()) scanner1.next();
        while (!scanner1.hasNextDouble()) {
            System.out.println(alert);
            scanner1.next();
        }
        numberOne = scanner1.nextDouble();
        System.out.println("You input " + numberOne + " as a first number");

        System.out.print(secondNumber);
        Scanner scanner2 = new Scanner(System.in);
        while (!scanner2.hasNextDouble()) {
            System.out.println(alert);
            scanner2.next();
        }
        numberTwo = scanner2.nextDouble();
        System.out.println("You input " + numberTwo + " as a second number");
        System.out.println("Input Math operation; ");
        Scanner scanner3 = new Scanner(System.in);
        do {
            String operation = scanner3.next();
            switch (operation) {
                case "+": {
                    System.out.println("Sum  is: " + (numberOne + numberTwo));
                    break;
                }
                case "-": {
                    System.out.println("Diff is: " + (numberOne - numberTwo));
                    break;
                }
                case "*": {
                    System.out.println("Mult is: " + (numberOne * numberTwo));
                    break;
                }
                case "/": {
                    System.out.println("Div  is: " + (numberOne / numberTwo));
                    break;
                }
                default: {
                    System.out.println(alert);
                    hasNotResult = true;
                }
            }
        }
        while (hasNotResult);
    }
}
