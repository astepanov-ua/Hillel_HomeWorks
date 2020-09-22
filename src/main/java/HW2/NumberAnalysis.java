package HW2;

import java.util.Scanner;

public class NumberAnalysis {
    public static void main(String[] args) {
        int number, t;
        boolean isSimple = true;
        String alert = "Please, input correct data";

        System.out.println("Input a number");
        Scanner scanner1 = new Scanner(System.in);
        if (!scanner1.hasNext()) scanner1.next();
        while (!scanner1.hasNextInt()) {
            System.out.println(alert);
            scanner1.next();
        }
        number = scanner1.nextInt();

        //even/uneven
        if (number % 2 == 0) System.out.println("It's even");
        else System.out.println("It's uneven");

        //simple/not simple (composite)
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                isSimple = false;
                break;
            }
        }
        if (isSimple) System.out.println("It's simple");
        else System.out.println("It's not simple (composite)");

        //find simple multiples
        System.out.print("Its simple multiple (-s) is(are): ");
        for (int i = 2; i <= number; i++) {
            if (number % i == 0) {
                System.out.print(i + " ");
                do number /= i;
                while (number % i == 0);
                }
            }
        }
    }


