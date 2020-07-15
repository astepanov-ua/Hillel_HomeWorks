package HW_19_Indexes_of_two_ints_equal_some_value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainDemo {
    public static void main(String[] args) {
        int sum = 150;
        System.out.println(findIndexes(getListOfInts(sum), sum));
    }

    public static List getListOfInts(int size) {
        List list = new ArrayList();
        for (int i = 0; i < size; i++) {
            list.add(2 * i - 2);                   //можно поставить любую логику добавления int
        }
        return list;
    }

    public static String findIndexes(List list, int sum) {
        HashMap map = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            if (map.containsKey(list.get(i))) {
                return "indexes: [" + map.get(list.get(i)) + ", " + i + "]" + "\n" +
                        "values:  [" + list.get((int) map.get(list.get(i))) + ", " + list.get(i) + "]";
            } else {
                map.put(sum - (int) list.get(i), i);
            }
        }
        return "[-1,-1]";
    }
}
