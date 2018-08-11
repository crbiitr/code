package com.java.java8.Function;

import java.util.function.Function;

/**
 * @author Chetan Raj Bharti
 * @implNote This demo is just showing use of Static method identity of Function interface
 */

public class IdentityInFunctionDemo {
    public static void main(String[] args) {
        Function<String, String> function = Function.identity();
        System.out.println(function.apply("Chetan"));
    }
}
