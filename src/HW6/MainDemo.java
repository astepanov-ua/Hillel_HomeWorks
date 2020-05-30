package HW6;

public class MainDemo {
    public static void main(String[] args) {
        Cat cat = new Cat("Tom");
        Crocodile crocodile = new Crocodile();
        Dog dog = new Dog("Hatiko");
        Fishy fishy = new Fishy();
        Giraffe giraffe = new Giraffe();
        GuideDog guideDogJim = new GuideDog("Jim", true);
        GuideDog giudeDogJack = new GuideDog("Jack", false);
        Humster humster = new Humster();
        Lion lion = new Lion();
        Wolf wolf = new Wolf();

        Animal[] animals = new Animal[]{cat, crocodile, dog, fishy, giraffe, guideDogJim, giudeDogJack, humster, lion, wolf};
        for (Animal animal : animals) {
            System.out.print(animal.getClass() + ": ");
            animal.voice();
            System.out.println("\n");
        }
    }
}
