package HW12_MyArrayList_Implements_List;

import HW6.Cat;
import HW6.Dog;
import HW6.GuideDog;

import java.util.Comparator;


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
        HW8.MyArrayList retainPets = new HW8.MyArrayList();
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
        Comparator byNameHomeAnimalComparator = new ByNameHomeAnimalComparator();
        myPets.sort(byNameHomeAnimalComparator);
        System.out.println("After sort Collection looks as: " + myPets);
        myPets.get(9);
        System.out.println("If get by index 2 receives: " + myPets.get(2));
        myPets.set(5, new Dog("Trump"));
        myPets.set(1, new Dog("Trump"));
        System.out.println("If set new HomeAnimal by index 1 Collection looks as: " + myPets);
        myPets.add(3, new Cat("Matroskin"));
        myPets.add(18, new Cat("Matroskin"));
        System.out.println("If add new HomeAnimal by index 3 Collection looks as: " + myPets);
        myPets.remove(4);
        myPets.remove(44);
        System.out.println("If remove by index 4 Collection looks as: " + myPets);
        System.out.println("IndexOf Matroskin is: " + myPets.indexOf(new Cat("Matroskin")));
        System.out.println("IndexOf Barbos is: " + myPets.indexOf(new Dog("Barbos")));
        myPets.add(3, myPets.get(3));
        System.out.println("Duplicate by index 3: " + myPets);
        System.out.println("LastIndexOf Matroskin is :" + myPets.lastIndexOf(new Cat("Matroskin")));
        System.out.println("SubList from 2 to 23 is: " + myPets.subList(2, 23));
        System.out.println("SubList from 2 to 4 is: " + myPets.subList(2, 4));
        System.out.println("SubList from 1 to 1 is: " + myPets.subList(1, 1));
        System.out.println("Thank You!");

    }
}
