package HW6;

public class GuideDog extends Dog {
    private boolean isTrained;

    public GuideDog(String name, boolean isTrained) {
        super(name);
        this.isTrained = isTrained;
    }

    public void voice() {
        super.voice();
        if (isTrained) {
            System.out.print(" I can take you home!");
        }
    }

}
