package com.java.java8.predicates;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * @author Chetan Raj Bharti
 * @implNote This demo is showing the use of Predicate.isEqual STATIC method.
 */
public class Predicates_IsEqual_StaticMethod {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Karan", 25));

        Predicate<Student> isChetan = Predicate.isEqual(new Student("Chetan", 26));

        Student student1 = new Student("Aman", 26);
        System.out.println("This student1 is chetan: " + isChetan.test(student1));

        Student student2 = new Student("Chetan", 26);
        System.out.println("\nThis student2 is chetan: " + isChetan.test(student2));
    }
}

class Student {
    String name;
    int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getAge() == student.getAge() &&
                Objects.equals(getName(), student.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }

    @Override
    public String toString() {
        /*
        String s =  new String.format("(%s, %s)",name,age);
        return s;
        */

        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
