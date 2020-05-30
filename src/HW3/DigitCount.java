package HW3;

import java.util.Scanner;

public class DigitCount {
    public static void main(String[] args) {
        int digitSum = sumDigit(getInt(" a number to count its digit sum"), 0);
        System.out.println(digitSum);
    }

    public static int sumDigit(int number, int sum) {
        if (number - number % 10 == 0) {
            return sum += number;
        } else {
            sum += number % 10;
            number = number / 10;
            return sumDigit(number, sum);
        }
    }

    public static int getInt(String something) {
        System.out.println("Input " + something);
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNext()) scanner.next();
        while (!scanner.hasNextInt()) {
            System.out.println("Mistake: wrong data. Try again, please");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
