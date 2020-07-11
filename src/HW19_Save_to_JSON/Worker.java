package HW19_Save_to_JSON;

public class Worker {
    private static int id = 0;
    private String name;
    private int age;
    private int workerID;

    public Worker(String name, int age) {
        this.name = name;
        this.age = age;
        this.workerID = ++id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", workerID=" + workerID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Worker worker = (Worker) o;

        if (age != worker.age) return false;
        if (workerID != worker.workerID) return false;
        return name.equals(worker.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        result = 31 * result + workerID;
        return result;
    }
}
