package HW26_SimpleFunctions;

import java.util.ArrayList;
import java.util.List;

public class SimpleFunctions {
    static double avarage(List<Double> list) {
        double res = 0;
        ArrayList<Double> numbers = (ArrayList<Double>) list;
        for (int i = 0; numbers.get(i) != null; i++) {
            res += numbers.get(i);
            if (i != numbers.size() - 1 - i) {
                res += numbers.get(numbers.size() - 1 - i);
                numbers.set(numbers.size() - 1 - i, null);
            }
        }
        return res / numbers.size();
    }

    public static int sumOfPositiveAndEvenSquaredNumbers(List<Integer> list) {
        int res = 0;
        ArrayList<Integer> numbers = (ArrayList<Integer>) list;
        int lastIndex = numbers.size() - 1;
        for (int i = 0; numbers.get(i) != null; i++) {
            res += (numbers.get(i) % 2 != 1 && numbers.get(i) > 0) ?
                    numbers.get(i) * numbers.get(i) : 0;
            if (i != lastIndex - i) {
                res += (numbers.get(lastIndex - i) % 2 != 1 && numbers.get(lastIndex - i) > 0) ?
                        numbers.get(lastIndex - i) * numbers.get(lastIndex - i) : 0;
                numbers.set(lastIndex - i, null);
            }
        }
        return res;
    }
}
