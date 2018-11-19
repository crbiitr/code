package com.java.selectiveQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 13/10/18
 */
public class Problem8 {

    public static void main(String[] args) {
        Predicate<Student> p1 = s -> s.stuName.startsWith("A");
        Predicate<Student> p2 = s -> s.stuAge < 40;
        Predicate<Student> p3 = s -> s.stuAge < 40 && s.stuName.startsWith("P");

        System.out.println(Student.getStudents().stream().anyMatch(p1));
        System.out.println(Student.getStudents().stream().anyMatch(p2));
        System.out.println(Student.getStudents().stream().anyMatch(p3));

    }

}
class Student {
    int stuId;
    int stuAge;
    String stuName;
    Student(int id, int age, String name) {
        this.stuId = id;
        this.stuAge = age;
        this.stuName = name;
    }

    public static List<Student> getStudents() {
        List<Student> list = new ArrayList<>();
        list.add(new Student(11, 28, "Lucy"));
        list.add(new Student(28, 27, "Tim"));
        list.add(new Student(32, 30, "Daniel"));
        list.add(new Student(49, 27, "Steve"));
        return list;
    }
}
