package HW2;

import java.util.Scanner;

public class BankCalculator {
    public static void main(String[] args) {
        double deposit, startDeposit, rate, interest;
        int period;
        String alert = "Please, input correct data";

        System.out.println("Input sum of deposit: ");
        Scanner scanner1 = new Scanner(System.in);
        if (!scanner1.hasNext()) scanner1.next();
        while (!scanner1.hasNextDouble()) {
            System.out.println(alert);
            scanner1.next();
        }
        deposit = scanner1.nextDouble();
        startDeposit = deposit;
        System.out.println("Input annual rate (%): ");
        Scanner scanner2 = new Scanner(System.in);
        if (!scanner2.hasNext()) scanner2.next();
        while (!scanner2.hasNextDouble()) {
            System.out.println(alert);
            scanner2.next();
        }
        rate = scanner2.nextDouble();

        System.out.println("Input period of deposit: ");
        Scanner scanner3 = new Scanner(System.in);
        if (!scanner3.hasNext()) scanner3.next();
        while (!scanner3.hasNextInt()) {
            System.out.println(alert);
            scanner3.next();
        }
        period = scanner3.nextInt();

        for (int i = 0; i < period; i++) {
            interest = deposit * rate / 100;
            deposit += interest;
            System.out.println("for year #" + (i + 1) + ": Interest is: " + interest + " and sum of deposit is: " + deposit);
        }
        System.out.println("Total earned 0interest is: " + (deposit - startDeposit));
    }
}
