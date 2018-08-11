package com.java.java8.Function;

import java.util.function.Function;

/**
 * @author Chetan Raj Bharti
 * @implNote Use of Function Interface
 */
public class FunctionDemo1 {

    public static void main(String[] args) {

        //Returning length of a String using Function Interface
        System.out.println("##############Returning length of a String using Function Interface##############");
        Function<String, Integer> function = s -> s.length();
        System.out.println("Length of Chetan is: " + function.apply("Chetan"));
        System.out.println("Length of Chetan Raj is: " + function.apply("Chetan Raj"));

        //Returning Square of a integer value using Function Interface
        System.out.println("\n##############Returning Square of a integer value using Function Interface##############");
        Function<Integer, Integer> squareFunction = I -> I * I;
        System.out.println("Square of 5 is: "+ squareFunction.apply(5));
        System.out.println("Square of 10 is: "+ squareFunction.apply(10));

        //Replacing all spaces using Function Interface
        System.out.println("\n##############Replacing all spaces using Function Interface##############");
        Function<String,String> replaceSpaceFunction = s -> s.replace(" ","");
        String s = "Chetan Raj Bharti ";
        System.out.println("Original String: "+ s);
        System.out.println("After replacing spaces: " + replaceSpaceFunction.apply(s));
    }
}
