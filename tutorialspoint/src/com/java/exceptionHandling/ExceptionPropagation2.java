package com.java.exceptionHandling;

import java.io.IOException;

/**
 * Created by user on 2/3/17.
 * Note: Program which describes that checked exceptions are not propagated
 */
public class ExceptionPropagation2 {
    void m() {
        // Commenting this line bcz it will throw compile time exception.
        // throw new IOException("Device Error"); // chacked exception
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
