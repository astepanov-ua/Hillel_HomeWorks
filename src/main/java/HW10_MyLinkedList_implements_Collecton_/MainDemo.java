package HW10_MyLinkedList_implements_Collecton_;

import HW6.Cat;
import HW6.Dog;
import HW6.GuideDog;

public class MainDemo {
    public static void main(String[] args) {
        MyStack myPets = new MyStack();

        //test size()
        System.out.println();
        System.out.println("MyStack size is : " + myPets.size());
        System.out.println();


        //test isEmpty()
        System.out.println("is MyStack empty? - " + myPets.isEmpty());
        System.out.println();

        //test add()
        System.out.println("Add one element to MyStack ");
        myPets.add(new Dog("Billy"));
        System.out.println("is MyStack empty? - " + myPets.isEmpty());
        System.out.println("Add 3 more elements to MyStack ");
        myPets.add(new Dog("Bonnie"));
        myPets.add(new Cat("Clyde"));
        myPets.add(new Cat("Tomas"));
        System.out.println(myPets);
        System.out.println("MyStack size is : " + myPets.size());
        System.out.println("MyStack tail is: " + myPets.getTail());
        System.out.println();


        // test contains()
        System.out.println("Is cat Clyde my pet? - " + myPets.contains(new Cat("Clyde")));
        System.out.println("Is dog Clyde my pet? - " + myPets.contains(new Dog("Clyde")));
        System.out.println();

        // test remove()
        System.out.println("MyStack size is : " + myPets.size());
        myPets.remove(new Dog("Bonnie"));
        System.out.println("Bonnie removed");
        System.out.println("Now I Have: " + myPets);
        System.out.println("MyStack size is : " + myPets.size());
        myPets.remove(new Cat("Tomas"));
        System.out.println("Tomas removed");
        System.out.println("Now I Have: " + myPets);
        System.out.println("MyStack size is : " + myPets.size());
        System.out.println("MyStack tail is: " + myPets.getTail());
        System.out.println();


        // test removeAll()
        MyStack removePets = new MyStack();
        removePets.add(new Cat("Kyle"));
        removePets.add(new Dog("Billy"));
        System.out.println("I want remove these pets: " + removePets);
        myPets.removeAll(removePets);
        System.out.println("Now I Have: " + myPets);
        System.out.println("MyStack size is : " + myPets.size());
        System.out.println("MyStack tail is: " + myPets.getTail());
        System.out.println();


        //test clear()
        System.out.println("Clear!");
        myPets.clear();
        System.out.println("Now I Have: " + myPets);
        System.out.println("MyStack size is : " + myPets.size());
        System.out.println("MyStack tail is: " + myPets.getTail());
        System.out.println();


        //test addAll()
        System.out.println("Add few pets");
        MyStack newPets = new MyStack();
        myPets.add(new Cat("Zumba"));
        myPets.add(new Cat("Kyle"));
        newPets.addAll(removePets);
        newPets.add(new GuideDog("Guidy", true));
        myPets.addAll(newPets);
        System.out.println("Now I Have: " + myPets);
        System.out.println("MyStack size is : " + myPets.size());
        System.out.println("MyStack tail is: " + myPets.getTail());
        System.out.println();


        //test retainAll()
        MyStack retainPets = new MyStack();
        retainPets.addAll(removePets);
        System.out.println("I want retain these pets: " + retainPets);
        myPets.retainAll(retainPets);
        System.out.println("Now I Have: " + myPets);
        System.out.println("MyStack tail is: " + myPets.getTail());
        System.out.println();


        //test containsAll()
        System.out.println();
        MyStack containsPets = new MyStack();
        containsPets.addAll(myPets);
        containsPets.add(new Dog("Bonnie"));
        containsPets.remove(new Cat("Kyle"));
        System.out.println("Add two element to MyStack ");
        myPets.add(new Dog("Bonnie"));
        myPets.add(new Cat("Clyde"));
        System.out.println("MyStack size is : " + myPets.size());
        System.out.println("Now I Have: " + myPets);
        System.out.println("Do I have all these pets: " + containsPets + " - " + myPets.containsAll(containsPets));
        containsPets.add(new Cat("Simon"));
        System.out.println("Do I have all these pets: " + containsPets + " - " + myPets.containsAll(containsPets));
        System.out.println("MyStack tail is: " + myPets.getTail());
        System.out.println("Thank You!");

    }
}
