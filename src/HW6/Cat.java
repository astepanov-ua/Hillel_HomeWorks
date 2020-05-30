package HW6;

public class Cat extends HomeAnimal {
    public Cat(String name) {
        setName(name);
    }

    @Override
    public void voice() {
        super.voice();
        System.out.print(" Meow!");
    }


}
