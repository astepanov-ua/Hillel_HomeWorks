package HW26_SimpleFunctions;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add((i + 0.5) / (i - 0.5));
            //list.add((double) i);
        }
        System.out.println(list.toString());
        System.out.println(SimpleFunctions.avarage(list));
        list.clear();

        List<Integer> listInt = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            //listInt.add((int) (Math.pow(-1, i + 1) * i));
            listInt.add((int) (Math.pow(-1, i) * i));
        }
        System.out.println(listInt.toString());
        System.out.println(SimpleFunctions.sumOfPositiveAndEvenSquaredNumbers(listInt));
    }
}
