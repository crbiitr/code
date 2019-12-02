package com.java.MathematicalAlgo;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 2019-11-19
 */
public class UglyNumber {
    public static void main(String[] args) {
        int uglyNumber = getNthUglyNumber(10);
        System.out.println(uglyNumber);
    }

    private static int getNthUglyNumber(int number) {
        int count = 1;
        int i = 1;

        while (count < number) {
            i++;
            if (isUgly(i) == 1) {
                System.out.println(" " + i);
                count++;
            }
        }
        return i;
    }

    private static int isUgly(int num) {
        num = maxDivide(num, 2);
        num = maxDivide(num, 3);
        num = maxDivide(num, 5);
        return (num == 1) ? 1 : 0;
    }

    private static int maxDivide(int a, int b) {
        if ((a % b) == 0) a = a / b;
        return a;
    }
}
