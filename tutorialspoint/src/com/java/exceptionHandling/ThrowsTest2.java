package com.java.exceptionHandling;

import java.io.IOException;

/**
 * Created by user on 2/3/17.
 * Rule: If you are calling a method that declares an exception, you must either caught or declare the exception.
 *
 * There are two cases:
 *        Case1:You caught the exception i.e. handle the exception using try/catch.
 *        Case2:You declare the exception i.e. specifying throws with the method.
 *
 * **This Example is for: Case1: You handle the exception
 */


class M {
    void method() throws IOException {
        throw new IOException("Device Error");
    }
}
public class ThrowsTest2 {
    public static void main(String[] args) {
        try {
            M m = new M();
            m.method();
        } catch (Exception e) {
            System.out.println("Exception Handled, Message-----> " + e.getMessage());
        }
        System.out.println("Normal Flow...");
    }
}
