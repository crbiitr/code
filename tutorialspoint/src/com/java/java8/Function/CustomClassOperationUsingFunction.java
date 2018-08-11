package com.java.java8.Function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class CustomClassOperationUsingFunction {
    public static void main(String[] args) {

        List<Student> list = new ArrayList<>();
        populate(list);

        Function<Student, String> function = student -> {
            int marks = student.marks;
            if (marks >= 80) return "A[Dictinction]";
            else if (marks >= 60) return "B[First Class]";
            else if (marks >= 50) return "B[Second Class]";
            else if (marks >= 35) return "C[Third Class]";
            else return "E[Failed]";
        };

        Predicate<Student> studentPredicate = student -> student.marks >= 60;
        for (Student student : list) {
            if (studentPredicate.test(student)) {
                System.out.println("\nName: " + student.name);
                System.out.println("Age: " + student.age);
                System.out.println("Marks: " + function.apply(student));
            }
        }
    }

    public static void populate(List list) {
        list.add(new Student("Chetan", 26, 80));
        list.add(new Student("Aman", 21, 60));
        list.add(new Student("Ratan", 29, 50));
        list.add(new Student("Chaman", 22, 40));
        list.add(new Student("Lakhan", 27, 20));
    }

}

class Student {
    String name;
    int age;
    int marks;

    public Student(String name, int age, int marks) {
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}


