package HW27_Stream_Declarative;

public class Student implements Comparable<Student> {
    private String surname;

    public Student(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public int compareTo(Student otherStudent) {
        return surname.compareTo(otherStudent.getSurname());
    }

    public Student setSurnameAndReturnStudent(String newSurname) {
        surname = newSurname;
        return this;

    }
}
