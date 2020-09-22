package HW27_Stream_Declarative;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Иванов"));
        students.add(new Student("Яготинский"));
        students.add(new Student("Попов-Зайцев"));
        students.add(new Student("Сидоров"));
        students.add(new Student("Дынин"));
        students.add(new Student("Ветровcкая"));
        students.add(new Student("Булгаков"));

        StudentFinder studentFinder = new StudentFinder(students);

        for (Student student : studentFinder.getStudents().get()) {
            System.out.println(student.getSurname());
        }
    }
}
