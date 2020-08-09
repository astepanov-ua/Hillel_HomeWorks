package HW26_SimpleFunctions;

import java.util.ArrayList;
import java.util.List;

public class SimpleFunctions {
    static double avarage(List<Double> list) {
        ArrayList<Double> numbers = (ArrayList<Double>) list;
        int lastIndex = numbers.size() - 1;
        while (numbers.get(1) != null) {
            for (int i = 0; numbers.get(i) != null; i++) {
                if (i != lastIndex - i) {
                    numbers.set(i, numbers.get(i) + numbers.get(lastIndex - i));
                    numbers.set(lastIndex - i, null);
                }
            }
            lastIndex = list.indexOf(null) - 1;
        }
        return numbers.get(0) / numbers.size();
    }

    public static double method(List<Double> list) {
        double res = 0;
        ArrayList<Double> numbers = (ArrayList<Double>) list;

        // можно было бы и без этой переменной, но громозко и нечитаемо, ИМХО
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
