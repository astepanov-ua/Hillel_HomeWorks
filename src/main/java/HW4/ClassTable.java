package HW4;

import java.util.Arrays;
import java.util.Scanner;

public class ClassTable {

    public static void main(String[] args) {
        EducationPlan educationPlan = initialize();
        do {
            switch (selectAction()) {
                case 0: {
                    initialize();
                }
                case 1: {
                    educationPlan = add(educationPlan);
                    break;
                }
                case 2: {
                    if (contains(educationPlan, input("a surname to check containing")))
                        System.out.println("Yes, contains");
                    else
                        System.out.println("No, doesn't contain");
                    break;
                }
                case 3: {
                    educationPlan = setMark(educationPlan, input("surname to mark "), getInt("lesson number"), getInt("mark"));
                    break;
                }
                case 4: {
                    educationPlan = delete(educationPlan, input("surname to delete"));
                    break;
                }
                case 5: {
                    educationPlan = clear(educationPlan);
                    break;
                }
                case 6: {
                    //sort(students);
                    break;
                }
                case 7: {
                    printTable(educationPlan);
                    break;
                }
                default: {
                    System.out.println("Please, input correct data");
                }
            }
        }
        while (doNewAction());
        printTable(educationPlan);
    }

    public static EducationPlan initialize() {
        EducationPlan educationPlan = new EducationPlan();
        educationPlan.students = new Student[getInt("a number of students")];
        educationPlan.lessonNumber = getInt("a number of lessons");
        for (int i = 0; i < educationPlan.students.length; i++) {
            educationPlan.students[i] = new Student(input("surname of student "), educationPlan.lessonNumber);
        }
        return educationPlan;
    }

    public static EducationPlan add(EducationPlan educationPlan) {
        if (educationPlan.students != null) {
            EducationPlan newEducationPlan = new EducationPlan();
            newEducationPlan.students = new Student[educationPlan.students.length + 1];
            for (int i = 0; i < educationPlan.students.length; )
                newEducationPlan.students[i] = educationPlan.students[i++];
            newEducationPlan.students[newEducationPlan.students.length - 1] = new Student(input(" surname of student "), educationPlan.lessonNumber);
            return newEducationPlan;
        } else
            return initialize();
    }

    public static boolean contains(EducationPlan educationPlan, String string) {
        for (Student student : educationPlan.students)
            if (student.surname.equals(string)) {
                return true;
            }
        return false;
    }

    public static EducationPlan setMark(EducationPlan educationPlan, String studentSurname, int lessonNumber, int mark) {
        if (!contains(educationPlan, studentSurname)) {
            System.out.println("Surname doesn't exist!");
        } else {
            educationPlan.students[getIndexBySurname(educationPlan, studentSurname)].marks[lessonNumber - 1] = mark;
        }
        return educationPlan;
    }

    public static EducationPlan delete(EducationPlan educationPlan, String deleteSurname) {
        if (!contains(educationPlan, deleteSurname)) {
            System.out.println("Surname doesn't exist!");
            return educationPlan;
        } else {
            EducationPlan newEducationPlan = new EducationPlan();
            newEducationPlan.students = new Student[educationPlan.students.length - 1];
            for (int studentIndex = 0, j = 0; studentIndex < educationPlan.students.length; studentIndex++, j++) {
                if (educationPlan.students[studentIndex].surname.equals(deleteSurname)) {
                    j--;
                } else {
                    newEducationPlan.students[j] = educationPlan.students[studentIndex];
                }
            }
            return newEducationPlan;
        }
    }


    public static EducationPlan clear(EducationPlan educationPlan) {
        return new EducationPlan();
    }

    public static void sort(EducationPlan educationPlan) {

    }

    public static void printTable(EducationPlan educationPlan) {
        if (educationPlan.students != null) {
            System.out.println("HW4.Student\t\t\tMarks");
            for (Student student : educationPlan.students) {
                System.out.println(student.surname + "\t" +"\t" +"\t" + Arrays.toString(student.marks));
            }
        } else
            System.out.println("Empty Class Table");
    }

    public static boolean doNewAction() {
        return input(" \"Y\" to continue / anykey to finish").equalsIgnoreCase("Y");
    }

    public static String input(String something) {
        System.out.println("Please, input " + something);
        Scanner scanner1 = new Scanner(System.in);
        /*if (!scanner1.hasNext()) scanner1.next();
        while (!scanner1.hasNextLine()) {
            System.out.println("Mistake: wrong data. Try again, please");
            scanner1.next();
        }*/
        return scanner1.next();
    }

    public static int getInt(String something) {
        System.out.println("Input " + something);
        Scanner scanner1 = new Scanner(System.in);
        if (!scanner1.hasNext()) scanner1.next();
        while (!scanner1.hasNextInt()) {
            System.out.println("Mistake: wrong data. Try again, please");
            scanner1.next();
        }
        return scanner1.nextInt();
    }

    public static int getIndexBySurname(EducationPlan educationPlan, String surname) {
        for (int i = 0; i < educationPlan.students.length; i++) {
            if (educationPlan.students[i].surname.equalsIgnoreCase(surname)) {
                return i;
            }
        }
        return -1;
    }

    public static int selectAction() {
        System.out.println("Please, select an action:");
        System.out.println("0 - initialize ");
        System.out.println("1 - add student by surname");
        System.out.println("2 - check if the list contains a surname");
        System.out.println("3 - set mark to student for any lesson");
        System.out.println("4 - delete student by surname");
        System.out.println("5 - clear all");
        System.out.println("6 - sort the list by surname");
        System.out.println("7 - print all data");
        return getInt("a number of selected action");
    }
}
