package HW12_MyArrayList_Implements_List;

import HW6.HomeAnimal;

import java.util.Comparator;

public class ByNameHomeAnimalComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        HomeAnimal pet1 = (HomeAnimal)o1;
        HomeAnimal pet2 = (HomeAnimal)o2;
        return pet1.compareTo(pet2);
    }
}
