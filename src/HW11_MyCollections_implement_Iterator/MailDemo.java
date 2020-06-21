package HW11_MyCollections_implement_Iterator;

import HW6.Dog;
import HW9_Search_in_MyCollectoin_and_Fibonachi.FibonacciNumber;

public class MailDemo {
    public static void main(String[] args) {
        Object o1 = new Dog("Blackie");
        Object o2 = 177;
        Object o3 = "LOL!";
        Object o4 = FibonacciNumber.getBySequenceNumber(15);
        Object[] objects = {o1, o2, o3, o4};

        MyArrayList arrayList = new MyArrayList(objects);
        arrayList.remove(177);
        System.out.println("Test Iterator from MyArrayList:");
        for (Object o : arrayList) {
            System.out.println(o);
        }

        System.out.println();

        MyStack stack = new MyStack(objects);
        System.out.println("Test Iterator from MyStack:");
        stack.remove("LOL!");
        for (Object o : stack) {
            System.out.println(o);
        }

        System.out.println();
        MyArrayList emptyArrayList = new MyArrayList();
        System.out.println("Test Iterator from empty MyArrayList:");
        for (Object o : emptyArrayList) {
            System.out.println(o);
        }

        System.out.println();

        MyStack emptyStack = new MyStack();
        System.out.println("Test Iterator from empty MyStack:");
        for (Object o : emptyStack) {
            System.out.println(o);
        }


    }
}
