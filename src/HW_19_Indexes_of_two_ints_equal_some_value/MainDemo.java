package HW_19_Indexes_of_two_ints_equal_some_value;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MainDemo {
    public static void main(String[] args) {
        int sum = 1520;
        System.out.println(findIndexes(getListOfInts(sum),sum));
        }

    public static List getListOfInts (int size) {
        List l = new ArrayList();
        for (int i = 0; i < size; i++) {
            l.add(2*i-2);//можно поставить любую логику добавления int
        }
        return l;
    }

    //метод гарантирует возврат числа посредством TreeMap, т.е сложность не более log(n=list.size())
    public static String findIndexes (List list, int sum) {
        TreeMap map = new TreeMap();
        for (int i = 0; i < list.size(); i++) {
            if (map.containsKey(list.get(i))) {
                return "indexes: [" + map.get(list.get(i)) + ", " + i + "]"+"\n"+
                       "values:  [" + list.get((int)map.get(list.get(i))) + ", " + list.get(i) + "]";
            } else {
                map.put(sum - (int) list.get(i), i);
            }
        }
        return "[-1,-1]";
    }






}
