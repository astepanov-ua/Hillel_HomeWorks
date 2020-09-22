package HW13;

import java.util.Comparator;

public class IntComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {

        Integer int1 = (Integer)o1;
        Integer int2 = (Integer)o2;
        return int1.compareTo(int2);
    }
}
