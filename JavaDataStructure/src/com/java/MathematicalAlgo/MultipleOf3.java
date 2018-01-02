package com.java.MathematicalAlgo;

import java.util.Scanner;

/**
 * Created by chetan on 18/5/17.
 * Note: One more solution is : Sum of digits divisible by 3;
 * http://www.geeksforgeeks.org/write-an-efficient-method-to-check-if-a-number-is-multiple-of-3/
 * Time Complexity: O((logn)^2)
 */
public class MultipleOf3 {
    public static void main(String[] args) {
        System.out.println("Please Enter a digit: ");
        Scanner sc = new Scanner(System.in);

        long stime = System.currentTimeMillis();
        if(isMultipleOf3(sc.nextInt())) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        System.out.println("Bit Time: " + (System.currentTimeMillis()-stime));

        long start = System.currentTimeMillis();
        int x = 123456789%3;
        System.out.println("Modulo Time: " + (System.currentTimeMillis()-start));

    }

    public static boolean isMultipleOf3(int n) {
        //boolean isMultipleOf3 = false;
        int oddCount = 0;
        int evenCount = 0;
        if (n<0) n*=-1;
        if (n==0) return true;
        if (n==1) return false;

        while (n!=0) {
            if ((n&1)==1) {
                oddCount++;
            }
            n=n>>1;

            if ((n&1)==1) {
                evenCount++;
            }
            n=n>>1;
        }

        return isMultipleOf3(Math.abs(oddCount-evenCount));
    }
}
