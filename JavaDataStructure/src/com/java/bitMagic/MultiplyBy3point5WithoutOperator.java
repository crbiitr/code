package com.java.bitMagic;

/**
 * @author Chetan Raj
 * @implNote https://www.geeksforgeeks.org/multiply-an-integer-with-3-5/
 * @since : 11/01/19
 */
public class MultiplyBy3point5WithoutOperator {
    public static void main(String[] args) {
        System.out.println(multiplyWithoutOperator(2));
        System.out.println(multiplyWith3Point5(2));
    }

    /**
     * Multiply a given Integer with 3.5 without using multiply operator
     * @param x
     * @return
     */
    public static int multiplyWithoutOperator(int x) {
        return (x << 1) + x + (x >> 1);
    }

    /**
     * ANOTHER Method
     * Multiply a given Integer with 3.5 without using multiply operator
     * way of doing this could be (8*x – x)/2
     * @param x
     * @return
     */
    public static int multiplyWith3Point5(int x) {
        return ((x << 3) - x) >> 1;
    }
}
