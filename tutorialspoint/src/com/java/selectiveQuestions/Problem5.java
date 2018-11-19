package com.java.selectiveQuestions;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 13/10/18
 */
public class Problem5 {

    static {
        System.out.println("First Static block");
        new Problem5().m1();
    }

    static int i = 10;

    public static void main(String[] args) {
        System.out.println("Main methodd");
        System.out.println("j: " + j);
    }

    private void m1() {
        System.out.println("i: " + i);
    }

    static {
        System.out.println("Second static block");
    }

    static int j = 10;

}
