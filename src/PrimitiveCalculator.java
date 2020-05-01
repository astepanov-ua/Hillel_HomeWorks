import java.util.Scanner;

public class PrimitiveCalculator {
    public static void main(String[] args) {
        System.out.println("For correct work, please, use '2,37' number format");

        System.out.print("Please input first number: ");
        Scanner scanner1 = new Scanner(System.in);
        double numberOne = scanner1.nextDouble();
        System.out.println("You input " + numberOne + " as a first number");

        System.out.print("Please input second number: ");
        Scanner scanner2 = new Scanner(System.in);
        double numberTwo = scanner2.nextDouble();
        System.out.println("You input " + numberTwo + " as a second number");

        System.out.println("Sum  is: " + (numberOne + numberTwo));
        System.out.println("Diff is: " + (numberOne - numberTwo));
        System.out.println("Mult is: " + (numberOne * numberTwo));
        System.out.println("Div  is: " + (numberOne / numberTwo));
    }
}
