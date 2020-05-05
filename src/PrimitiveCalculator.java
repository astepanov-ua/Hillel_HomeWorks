import java.util.Scanner;

public class PrimitiveCalculator {
    public static void main(String[] args) {
        double numberOne, numberTwo;
        Scanner scanner1 = new Scanner(System.in);
        do {
            System.out.println("Please input first number: ");
            scanner1.next();
        }
        while (!scanner1.hasNextDouble());
        numberOne = scanner1.nextDouble();

        System.out.println("You input " + numberOne + " as a first number");


        System.out.print("Please input second number: ");
        Scanner scanner2 = new Scanner(System.in);
        numberTwo = scanner2.nextDouble();
        System.out.println("You input " + numberTwo + " as a second number");


        System.out.println("Sum  is: " + (numberOne + numberTwo));
        System.out.println("Diff is: " + (numberOne - numberTwo));
        System.out.println("Mult is: " + (numberOne * numberTwo));
        System.out.println("Div  is: " + (numberOne / numberTwo));
    }
}
