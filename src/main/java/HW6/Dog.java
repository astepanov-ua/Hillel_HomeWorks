package HW6;

public class Dog extends HomeAnimal {
    public Dog(String name) {
        setName(name);
    }

    @Override
    public void voice() {
        super.voice();
        System.out.print(" Woof!");
    }

}
