package com.java.dynamicProgramming;

/**
 * @author Chetan Raj
 * @implNote https://www.geeksforgeeks.org/count-number-binary-strings-without-consecutive-1s/
 *
 * NOTE: There is one more solution which is using fibonacci of (n+2)th number.
 * @since : 24/01/19
 */
public class BinaryStringWithoutConsecutive1s {
    public static void main(String[] args) {
        int n = 4;
        //DP solution
        System.out.println(getCount(n));

        // Using Fibonacci
        System.out.println(getFibonacci(n+2));

    }

    public static int getCount(int n) {
        int []a= new int[n];
        int []b= new int[n];

        a[0] = 1;
        b[0] =1;

        for (int i = 1; i < n; i++) {
            a[i] = a[i-1] + b[i-1];
            b[i] = a[i-1];
        }

        return a[n-1] + b[n-1];
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
