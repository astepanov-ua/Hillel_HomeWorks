package HW26_SimpleFunctions;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Double> listDoubles = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            // можно поменить местами комментирование строк и протестить

            listDoubles.add((i + 0.5) / (i - 0.5));
            //list.add((double) i); //можно протестить на очевидном примере
        }
        System.out.println(listDoubles.toString());
        System.out.println(SimpleFunctions.avarage(listDoubles));


        List<Integer> listInt = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            // можно поменить местами комментирование строк и протестить

            //listInt.add((int) (Math.pow(-1, i + 1) * i));
            listInt.add((int) (Math.pow(-1, i) * i));
        }
        System.out.println(listInt.toString());
        System.out.println(SimpleFunctions.sumOfPositiveAndEvenSquaredNumbers(listInt));
    }
}
