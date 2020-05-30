package HW3;

import java.util.Scanner;

public class PointAndRectangle {
    public static void main(String[] args) {
        double x1;
        double y1;
        double x2;
        double y2;
        double xPoint;
        double yPoint;

        x1 = input(" X of 1st corner");
        y1 = input(" Y of 1st corner");

        do {
            x2 = input(" X of 2nd corner");
        }
        while (x1 == x2);

        do {
            y2 = input(" Y of 2nd corner");
        } while (y1 == y2);

        xPoint = input(" X of a point");
        yPoint = input(" Y of a point");
        if ((xPoint < x1 && xPoint > x2) || (xPoint < x2 && xPoint > x1) && ((yPoint < y1 && yPoint > y2) || (yPoint < y2 && yPoint > y1))) {
            System.out.println("point is inside");
        } else
            System.out.println("point is outside");
    }

    public static double input(String something) {
        System.out.println("Input " + something);
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNext()) {
            scanner.next();
        }
        while (!scanner.hasNextDouble()) {
            System.out.println("Mistake: wrong data. Try again, please");
            scanner.next();
        }
        return scanner.nextDouble();
    }
}
