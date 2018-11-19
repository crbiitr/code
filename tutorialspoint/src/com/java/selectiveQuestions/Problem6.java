package com.java.selectiveQuestions;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 13/10/18
 */
public class Problem6 extends Problem5 {

    static int x = 10;

    static {
        new Problem6().m2();
        System.out.println("Derived class first static block");
    }

    public static void main(String[] args) {
        new Problem6().m2();
        System.out.println("Derived class main method");
    }

    private void m2() {
        System.out.println("y: " + y);
    }

    static {
        System.out.println("Derived second static block");
    }

    static int y = 200;

}
