package com.java.bitMagic;

/**
 * @author Chetan Raj
 * @implNote https://www.geeksforgeeks.org/count-strings-with-consecutive-1s/
 * Time : O(log n)
 * @since : 24/01/19
 */


public class CountStringWithConsecutive {
    /**
     * Solution by this formula: 2^n - fib(n+2)
     */
    public static void main(String[] args) {
        int n = 5;

        // 2^n - fib(n+2)
        System.out.println(Math.pow(2,5)-getFibonacci(n+2));
    }

    /**
     * Finding fibonacci number of a given position
     * @param n
     * @return
     */
    public static int getFibonacci(int n) {
        int []f= new int[n+1];
        f[0]= 0;
        f[1]= 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }
}
