package com.java.inheritance;

/**
 * Created by chetan on 26/2/17.
 * This is not related to Inheritance but it's important.
 */

class X {
    int a;
    X(int i) { a = i; }
}

class Y {
    int a;
    Y(int i) { a = i; }
}

public class InheritanceTest2 {
    public static void main(String args[]) {
        X x = new X(10);
        X x2;
        Y y = new Y(5);
        x2 = x; // OK, both of same type
        // x2 = y; // Error, not of same type

    }
}

