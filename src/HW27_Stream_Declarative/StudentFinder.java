package HW27_Stream_Declarative;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentFinder {
    public StudentFinder(List<Student> list) {
        this.list = list;
    }

    private List<Student> list;

    public Optional<List<Student>> getList() {
        if (list == null && list.isEmpty()) {
            return Optional.empty();
        }
        Stream<Student> stream = list.stream();
        List<Student> students = stream.filter(student -> containsMoreThenThreeVowel(student.getSurname()))
                .map(student -> student.setSurnameAndReturnStudent(student.getSurname().toUpperCase()))
                .sorted()
                .collect(Collectors.toList());
        return Optional.of(students);
    }

    private boolean containsMoreThenThreeVowel(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
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
