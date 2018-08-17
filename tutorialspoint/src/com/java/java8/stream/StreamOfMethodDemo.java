package com.java.java8.stream;

import java.util.stream.Stream;

/**
 * @author Chetan Raj Bharti
 * @implNote StreamOf(): We can also apply Stream for group of values & for arrays
 */
public class StreamOfMethodDemo {
    public static void main(String[] args) {
        System.out.println("Group of values");
        Stream<Integer> s = Stream.of(1, 3, 91, 847, 0);
        s.forEach(System.out::println);

        System.out.println("\nFor Arrays: ");
        Double[] d = {1.2, 1.3, 1.4, 1.5};
        Stream<Double> s1 = Stream.of(d);
        s1.forEach(System.out::println);
    }
}
