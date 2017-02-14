package com.java.collections.set;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by user on 12/17/16.
 */
public class HashSetDemo1 {
    public static void main(String[] args) {
        Student s1 = new Student(1,"chetan");
        Student s2 = new Student(1,"chetan");

        Set  s = new HashSet();
        s.add(s1);
        s.add(s2);

        System.out.println("Size : " + s.size());
        System.out.println("set:  " + s.toString());
    }
}

class Student {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
