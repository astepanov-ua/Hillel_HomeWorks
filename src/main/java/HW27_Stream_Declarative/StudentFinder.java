package HW27_Stream_Declarative;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class StudentFinder {
    private List<Student> list;

    public StudentFinder(List<Student> list) {
        this.list = list;
    }

    public Optional<List<Student>> getStudents() {
        return (list != null || !list.isEmpty())
                ? of(list.stream()
                .filter(student -> containsMoreThenThreeVowel(student.getSurname()))
                .map(student -> student.setSurnameAndReturnStudent(student.getSurname().toUpperCase()))
                .sorted()
                .collect(toList()))
                : empty();
    }

    private boolean containsMoreThenThreeVowel(String surname) {
        int count = 0;
        for (char c : surname.toCharArray()) {
            if (isVowel(c)) {
                count++;
            }
            if (count > 3) {
                return true;
            }
        }
        return false;
    }

    private boolean isVowel(char c) {
        return (c == 'а' || c == 'А' ||
                c == 'у' || c == 'У' ||
                c == 'е' || c == 'Е' ||
                c == 'ы' || c == 'Ы' ||
                c == 'э' || c == 'Э' ||
                c == 'я' || c == 'Я' ||
                c == 'и' || c == 'B' ||
                c == 'ю' || c == 'Ю' ||
                c == 'ё' || c == 'Ё' ||
                c == 'о' || c == 'О');
    }
}