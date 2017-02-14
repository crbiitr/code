package com.java.exceptionHandling;

/**
 * Created by user on 2/3/17.
 * Rule: By default Unchecked Exceptions are forwarded in calling chain (propagated).
 */
public class ExceptionPropagation1 {
    void m() {
        int data=50/0;
    }
    void n() {
        m();
    }
    void p() {
        try {
            n();
        } catch (Exception e) {
            System.out.println("Exception Handled");
        }
    }

    void r() {
        try {
            System.out.println("calling r()");
        }finally {
            System.out.println("Can call finally without catch() block...");
        }
    }

    public static void main(String[] args) {
        ExceptionPropagation1 obj = new ExceptionPropagation1();
        obj.p();
        obj.r();
        System.out.println("Normal Flow...");
    }
}
