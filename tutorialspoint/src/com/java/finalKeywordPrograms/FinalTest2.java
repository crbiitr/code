package com.java.finalKeywordPrograms;

/**
 * Created by user on 12/2/16.
 * For object handles, final means you can’t replace the reference with another object.  The object can still be modified.
 */
public class FinalTest2 {
    public static void main(String[] args) {
        final Person p = new Person("chetan");

        // Note: For object handles, final means you can’t replace the reference with another object.
        // The object can still be modified.
        p.setName("Ratan");
        p.printName();

        Person p1 = new Person("Karan");

        // final means you can’t replace the reference with another object
        // p=p1; // Error:(19, 9) java: cannot assign a value to final variable p
    }

}

class Person {

    String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public void printName() {
        System.out.println("Name: " + name);
    }

}

// Note
// Question: Where all we can initialize a final non-static global variable if it is not initialized at the time of declaration?
// Answer:  1. In all constructors or in any one of instance initialization blocks.
//          2. may be initialized in any one of IIB's, because while object creation, all IIBs are called

class Student {

    // Uninitialized final field is called Blank Final Field.
    // final global variable must get a value at the time of object creation.
    final String name;
    final String class_;
    // final int salary;
    // final int age; // Error:(48, 5) java: variable age might not have been initialized

    static {
    // salary = 22; // Error: variable age might not have been initialized
    }

    {
        class_ = "MCA";
    }

    public Student() {
        name = "chetan";
    }
}
