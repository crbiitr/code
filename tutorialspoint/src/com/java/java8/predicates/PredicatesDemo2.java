package com.java.java8.predicates;

import java.util.function.Predicate;

/**
 * @author Chetan Raj Bharti
 * @implNote This example shows joining of 2 predicates
 */
public class PredicatesDemo2 {

    public static void main(String[] args) {

        int []array = {1,4,5,9,12,61,90,99,102};
        Predicate<Integer> evenPredicate = i -> (i % 2) == 0;
        Predicate<Integer> greaterPredicate = i -> i > 10;

        System.out.println("Numbers greater than or equal to 10 are: ");
        m1(greaterPredicate,array);

        System.out.println("Even numbers are: ");
        m1(evenPredicate,array);

        System.out.println("Odd numbers are: ");
        m1(evenPredicate.negate(),array);

        System.out.println("Numbers less than 10 are: ");
        m1(greaterPredicate.negate(),array);

        System.out.println("Numbers greater than 10 AND Even are:");
        m1(evenPredicate.and(greaterPredicate),array);

        System.out.println("Numbers greater than 10 OR Even are:");
        m1(evenPredicate.or(greaterPredicate),array);
    }

    /**
     *
     * @param p
     * @param array
     */
    public static void m1(Predicate p, int[] array) {
        for (int x : array) {
            if(p.test(x)) {
                System.out.println(x);
            }
        }
        System.out.println();
    }
}
