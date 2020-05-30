package HW3;

public class Student {
    String surname;
    int[] marks;
    boolean[] presence;

    public Student(String surname, int lessonNumber) {
        this.surname = surname;
        marks = new int[lessonNumber];
        presence = new boolean[lessonNumber];
    }
}
