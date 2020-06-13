package HW8;

import HW6.Cat;
import HW6.Dog;
import HW6.GuideDog;

public class MainDemo {
    public static void main(String[] args) {
        MyArrayList myPets = new MyArrayList();
        System.out.println("MyCollection size is : " + myPets.size());
        System.out.println("is MyCollection empty? - " + myPets.isEmpty());
        System.out.println("Add one element to MyCollection ");
        myPets.add(new Dog("Billy"));
        System.out.println("is MyCollection empty? - " + myPets.isEmpty());
        System.out.println("Add two element to MyCollection ");
        myPets.add(new Dog("Bonnie"));
        myPets.add(new Cat("Clyde"));
        myPets.add(new Cat("Tomas"));
        System.out.println(myPets);
        System.out.println("Is cat Clyde my pet? - " + myPets.contains(new Cat("Clyde")));
        System.out.println("Is dog Clyde my pet? - " + myPets.contains(new Dog("Clyde")));
        System.out.println("MyCollection size is : " + myPets.size());
        myPets.remove(new Dog("Bonnie"));
        System.out.println("Bonnie deleted");
        System.out.println("Now I Have: " + myPets);
        MyArrayList removePets = new MyArrayList();
        removePets.add(new Cat("Kyle"));
        removePets.add(new Dog("Billy"));
        System.out.println("I want remove these pets: " + removePets);
        myPets.removeAll(removePets);
        System.out.println("Now I Have: " + myPets);
        System.out.println("MyCollection size is : " + myPets.size());
        System.out.println("Clear!");
        myPets.clear();
        System.out.println("Now I Have: " + myPets);
        System.out.println("MyCollection size is : " + myPets.size());
        MyArrayList newPets = new MyArrayList();
        newPets.addAll(removePets);
        System.out.println("Add few pets");
        myPets.add(new GuideDog("Guidy", true));
        myPets.addAll(newPets);
        System.out.println(newPets);
        myPets.add(new Cat("Zumba"));
        myPets.add(new Cat("Kyle"));
        System.out.println("Now I Have: " + myPets);
        System.out.println("MyCollection size is : " + myPets.size());
        MyArrayList retainPets = new MyArrayList();
        retainPets.addAll(removePets);
        System.out.println("I want retain these pets: " + retainPets);
        myPets.retainAll(retainPets);
        System.out.println("Now I Have: " + myPets);
        System.out.println("MyCollection size is : " + myPets.size());
        MyArrayList containsPets = new MyArrayList();
        containsPets.addAll(myPets);
        containsPets.remove(new Cat("Kyle"));
        containsPets.add(new Dog("Bonnie"));
        System.out.println("Add two element to MyCollection ");
        myPets.add(new Dog("Bonnie"));
        myPets.add(new Cat("Clyde"));
        System.out.println("Now I Have: " + myPets);
        System.out.println("MyCollection size is : " + myPets.size());
        System.out.println("Do I have all these pets: " + containsPets + " - " + myPets.containsAll(containsPets));
        containsPets.add(new Cat("Simon"));
        System.out.println("Do I have all these pets: " + containsPets + " - " + myPets.containsAll(containsPets));
        System.out.println("Thank You!");
    }
}
