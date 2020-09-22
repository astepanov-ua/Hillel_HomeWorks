package HW7;

import HW6.*;

public class MainDemo {
    public static void main(String[] args) {
        MyCollection myPets = new MyCollection();
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
        MyCollection removePets = new MyCollection();
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
        MyCollection newPets = new MyCollection();
        newPets.addAll(removePets);
        System.out.println("Add few pets");
        myPets.add(new GuideDog("Guidy", true));
        myPets.addAll(newPets);
        System.out.println(newPets);
        myPets.add(new Cat("Zumba"));
        myPets.add(new Cat("Kyle"));
        System.out.println("Now I Have: " + myPets);
        System.out.println("MyCollection size is : " + myPets.size());
        MyCollection retainPets = new MyCollection();
        retainPets.addAll(removePets);
        System.out.println("I want retain these pets: " + retainPets);
        myPets.retainAll(retainPets);
        System.out.println("Now I Have: " + myPets);
        System.out.println("MyCollection size is : " + myPets.size());
        MyCollection containsPets = new MyCollection();
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
