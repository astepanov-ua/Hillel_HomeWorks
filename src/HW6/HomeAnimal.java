package HW6;

public class HomeAnimal extends Animal implements Comparable{
    private boolean isVaccinated;

    public String getName() {
        return name;
    }

    private String name;

    public boolean hasName() {
        return (name != null);
    }

    protected void setName(String name) {
        this.name = name;
    }

    @Override
    public void voice() {
        super.voice();
        if (hasName()) {
            System.out.print(" My name is " + name + ".");
        }
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HomeAnimal that = (HomeAnimal) o;

        return name.equals(that.name);
    }

    @Override
    public int compareTo(Object o) {
        HomeAnimal anotherHomeAnimal = (HomeAnimal) o;
        return name.compareTo(anotherHomeAnimal.name);
    }
}
