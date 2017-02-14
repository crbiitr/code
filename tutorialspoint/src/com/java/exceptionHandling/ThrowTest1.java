package com.java.exceptionHandling;

/**
 * Created by user on 2/2/17.
 */
public class ThrowTest1 {
    public static void main(String[] args) {
        valid(13);
        System.out.println("Rest of the code...");

    }

    public static void valid(int age) {
        if (age<18) {
            throw new ArithmeticException("Not Valid");
        } else {
            System.out.println("Welcome to vote");
        }
    }
}
