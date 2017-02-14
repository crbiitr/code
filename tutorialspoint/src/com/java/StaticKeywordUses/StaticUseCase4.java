package com.java.StaticKeywordUses;

/**
 * Created by user on 12/4/16.
 * Note: Java does not permit to declare a constructor as static
 */
public class StaticUseCase4 {
    static int y;
    int instanceVariable;

    public static void main(String[] args) {
        foo();

        // The static method can not use non static data member or call non-static method directly.
        // instanceVariable++; // Error


        // You can still access any non static variable inside any static method or block by
        // creating an instance of class in Java and using that instance to reference instance variable.
        StaticUseCase4 st4 = new StaticUseCase4();
        System.out.println("St4:: " + st4.instanceVariable);

    }

    // Java does not permit to declare a constructor as static
/*
    public static StaticUseCase4() {
        System.out.println("Hello");
    }
*/
    public static void foo() {

        // Inside the static method can not be created static variable
        // static int x = 1; // Error:(21, 9) java: illegal start of expression

        System.out.println("Y: " + y);
        System.out.println("In foo()");

        // The static method can not use non static data member or call non-static method directly.
        // foo1(); // Error:(28, 9) java: non-static method foo1() cannot be referenced from a static context
        // System.out.println("instanceVariable: " + instanceVariable); // Error:(31, 51) java: non-static variable instanceVariable cannot be referenced from a static context
    }

    public void foo1() {
        System.out.println("In foo1(), Non-static method");
    }
}
