package HW6;

public class WildAnimal extends Animal {
    private boolean isWild = true;

    public boolean isWild() {
        return isWild;
    }

    @Override
    public void voice() {
        super.voice();
        System.out.print(" I'm a wild animal");
    }
}
