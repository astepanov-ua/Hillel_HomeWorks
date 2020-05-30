package HW6;

public class PredatorAnimal extends WildAnimal {
    private boolean isPredator = true;

    @Override
    public void voice() {
        super.voice();
        System.out.print(" and I'm angry!");
    }
}
