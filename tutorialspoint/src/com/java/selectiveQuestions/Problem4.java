package com.java.selectiveQuestions;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 13/10/18
 */
public class Problem4 {

    public static void main(String[] args) {
        Parent3 p3 = new Child3();
        p3.method1("Child");
    }
}
class Parent3 {

    protected void method1(String... args) {
        System.out.println("Parent method");
    }
}
class Child3 extends Parent3 {

    protected void method1(String arg) {
        System.out.println("Child method");
    }
}

