package com.java.java8.stream;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Important Link: https://www.mkyong.com/java/java-how-to-print-an-array/
 * @author Chetan Raj
 * @implNote
 * @since : 07/03/19
 */
public class PrintArrayUsingDiffApproaches {
    public static void main(String[] args) {

        String[] strArray = new String[]{"John", "Mary", "Bob"};

        // #1
        Arrays.asList(strArray).stream().forEach(s -> System.out.println(s));

        // #2
        Stream.of(strArray).forEach(System.out::println);

        // #3
        Arrays.stream(strArray).forEach(System.out::println);


        // Simple Array:
        String[] array = new String[] {"John", "Mary", "Bob"};
        System.out.println(Arrays.toString(array));

        //Nested Array:
        String[][] deepArray = new String[][] {{"John", "Mary"}, {"Alice", "Bob"}};
        System.out.println(Arrays.toString(deepArray));
        // output: [[Ljava.lang.String;@106d69c, [Ljava.lang.String;@52e922]
        System.out.println(Arrays.deepToString(deepArray));
        //Output: [[John, Mary], [Alice, Bob]]


        // double Array:
        double[] doubleArray = { 7.0, 9.0, 5.0, 1.0, 3.0 };
        System.out.println(Arrays.toString(doubleArray));
        // Output: [7.0, 9.0, 5.0, 1.0, 3.0 ]


        // int Array:
        int[] intArray = { 7, 9, 5, 1, 3 };
        System.out.println(Arrays.toString(intArray));
        //Output: [7, 9, 5, 1, 3 ]
    }
}
