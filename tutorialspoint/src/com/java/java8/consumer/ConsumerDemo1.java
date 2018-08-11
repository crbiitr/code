package com.java.java8.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Chetan Raj Bharti
 * @implNote Consumer interface does not return any thing. It has accept method which return void type.
 */
public class ConsumerDemo1 {
    public static void main(String[] args) {
        //Just printing some String using Consumer Interface
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("Chetan Raj Bharti");

        //Printing Student object using Consumer Interface
        List<Student> list = new ArrayList<>();
        populate(list);
        Consumer<Student> c = student-> {
            System.out.println("\nName: " + student.name);
            System.out.println("Age: " + student.age);
            System.out.println("Marks: " + student.marks);
        };

        for (Student s: list ){
            c.accept(s);
        }

        //Consumer chaining
        System.out.println("\nConsumer Chaining ====> ");
        Consumer<Student> consumer1 = student -> System.out.println("\nName: " + student.name);
        Consumer<Student> consumer2 = student -> System.out.println("Age: " + student.age);
        Consumer<Student> consumer3 = student -> System.out.println("Marks: " + student.marks);
        for (Student s: list ){
            consumer1.andThen(consumer2).andThen(consumer3).accept(s);
        }
    }

    public static void populate(List list) {
        list.add(new Student("Chetan", 25, 80));
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

