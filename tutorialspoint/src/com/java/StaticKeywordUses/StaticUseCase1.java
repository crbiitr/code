package com.java.StaticKeywordUses;

/**
 * Created by user on 12/4/16.
 * http://javaconceptoftheday.com/static-members-java/
 * Note:  "static" keyword can be applied to instance variables and methods and not with classes and local variables.
 */
public class StaticUseCase1 {

    static String name;
    static {
        name = "Chetan";
    }

    public static void main(String[] args) {
        // Note: "static" keyword can not use with classes and local variables.
        // static int x; // Error:(14, 9) java: illegal start of expression
        System.out.println("Name: " + name);
        foo1();

        // Can't call none-static method in static method
        // foo2(); //Error:(20, 9) java: non-static method foo2() cannot be referenced from a static context

    }

    public static void foo1() {
        // static int y; // Error:(14, 9) java: illegal start of expression
        name = "Ratan";
        System.out.println("Name: " + name);

    }

    public void foo2() {
        // static int z; // Error:(14, 9) java: illegal start of expression
        System.out.println("Name: " + name);
    }

}

// Note: A class or a local variable cannot be static.
/*
static class NewClass { // Error:(41, 8) java: modifier static not allowed here

}
*/
