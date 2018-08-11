package com.java.java8.Function;

import java.util.function.Function;

/**
 * @author Chetan Raj Bharti
 * @implNote
 * f1.andThen(f2):-> first apply f1 method then apply f2 method
 * f1.compose(f2):-> first apply f2 method then apply f1 method
 */
public class FunctionChainingDemo1 {
    public static void main(String[] args) {
        Function<Integer, Integer> plusFunction = x -> x + x;
        Function<Integer, Integer> qubeFunction = x -> x * x * x;

        System.out.println("Applying Plus Function on 2: " + plusFunction.apply(2));
        System.out.println("Applying Qube Function on 2: " + qubeFunction.apply(2));

        //andThen Demo
        System.out.println("plusFunction.andThen(qubeFunction).apply(2): " + plusFunction.andThen(qubeFunction).apply(2));

        //Compose Demo
        System.out.println("plusFunction.compose(qubeFunction).apply(2): " + plusFunction.compose(qubeFunction).apply(2));

        //andThen Demo
        System.out.println("\nqubeFunction.andThen(plusFunction.andThen(plusFunction)).apply(2): " + qubeFunction.andThen(plusFunction.andThen(plusFunction)).apply(2));
    }
}
