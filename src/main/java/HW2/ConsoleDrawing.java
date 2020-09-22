package HW2;

import java.util.Scanner;

public class ConsoleDrawing {
    public static void main(String[] args) {
        int x, y;

        System.out.println("Введите ширину прямоугольника");
        Scanner scanner1 = new Scanner(System.in);
        if (!scanner1.hasNext()) scanner1.next();
        while (!scanner1.hasNextInt()) {
            System.out.println("Введите целое число");
            scanner1.next();
        }
        x = scanner1.nextInt();

        System.out.println("Введите высоту прямоугольника");
        Scanner scanner2 = new Scanner(System.in);
        if (!scanner2.hasNext()) scanner2.next();
        while (!scanner2.hasNextInt()) {
            System.out.println("Введите целое число");
            scanner2.next();
        }
        y = scanner2.nextInt();

        //Envelope
        double pr = (double) x / y;
        System.out.println(pr);
        for (int j = 0; j < y; j++) {
            for (int i = 0; i < x; i++) {
                if (i == 0 || i == x - 1 || j == 0 || j == y - 1) {
                    System.out.print(" * ");
                } else if (i - j * pr < 0.5 && i - j * pr > -0.5) {
                    System.out.print(" * ");
                } else if (i - (y - 1 - j) * pr < 0.5 && i - (y - 1 - j) * pr > -0.50) {
                    System.out.print(" * ");
                } else
                    System.out.print("   ");
            }
            System.out.println();
        }

        //Rectangle
        for (int j = 0; j < y; j++) {
            for (int i = 0; i < x; i++) {
                if (i == 0 || i == x - 1 || j == 0 || j == y - 1) {
                    System.out.print(" * ");
                } else
                    System.out.print("   ");
            }
            System.out.println();
        }

        //Chess
        for (int j = 0; j < y; j++) {
            for (int i = 0; i < x; i++) {
                if ((i + j) % 2 == 0) {
                    System.out.print(" * ");
                } else
                    System.out.print("   ");
            }
            System.out.println();
        }
    }
}
