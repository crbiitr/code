package com.java.MathematicalAlgo;

import java.util.*;


/**
 * Created by chetan on 19/5/17.
 */
public class MultiplyTwoStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int i = 0; i < testCases; i++) {

            System.out.println(multiply(sc.next(),sc.next()));
        }
    }

    public static String multiply(String num1, String num2) {
        String result = null;

        List<String> myList = new ArrayList<String>(Arrays.asList(num1.split(",")));
        int number1 = Integer.parseInt(num1);
        int number2 = Integer.parseInt(num2);
        int result_ = number1*number2;
        result = result_ + "";
        return result;
    }
}
