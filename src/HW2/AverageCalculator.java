package HW2;

import java.util.Scanner;

public class AverageCalculator {
    public static void main(String[] args) {
        double nextNumber, sum = 0, average;
        int quantityOfNumber;
        String alert = "Please, input correct data";

        System.out.println("Input quantity of numbers");
        Scanner scanner1 = new Scanner(System.in);
        if (!scanner1.hasNext()) scanner1.next();
        while (!scanner1.hasNextInt()) {
            System.out.println(alert);
            scanner1.next();
        }
        quantityOfNumber = scanner1.nextInt();

        for (int i = 0; i < quantityOfNumber; i++) {
            System.out.println("Input next number");
            Scanner scanner2 = new Scanner(System.in);
            if (!scanner2.hasNext()) scanner2.next();
            while (!scanner2.hasNextDouble()) {
                System.out.println(alert);
                scanner2.next();
            }
            nextNumber = scanner2.nextDouble();
            sum += nextNumber;
        }
        System.out.println("Sum of " + quantityOfNumber + " is " + sum);
        System.out.println("Average of " + quantityOfNumber + " is " + (sum / quantityOfNumber));
    }
}
