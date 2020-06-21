package HW12_MyArrayList_mplements_List;
import HW9_Search_in_MyCollectoin_and_Fibonachi.FibonacciNumber;
import java.util.ArrayList;

public class MainDemo {
    public static void main(String[] args) {
    MyArrayList myList = new MyArrayList();
    ArrayList toAdd = new ArrayList();
        toAdd.add(FibonacciNumber.getBySequenceNumber(102));
        toAdd.add(FibonacciNumber.getBySequenceNumber(5));
        toAdd.add("!");
        toAdd.add("!!");
    myList.addAll(toAdd);
    myList.remove("!");
    myList.remove(null);
        System.out.println(myList.toString());
        myList.addAll(5,toAdd);
        System.out.println(myList.toString());
        myList.addAll(1,toAdd);
        System.out.println(myList.toString());
        myList.clear();
        System.out.println(myList.toString());
    System.out.println(myList.size());
    }
}
