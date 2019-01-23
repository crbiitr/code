package com.java.bitMagic;

/**
 * @author Chetan Raj
 * @implNote https://www.geeksforgeeks.org/count-set-bits-in-an-integer/
 * @since : 23/01/19
 */
public class CountSetBits {
    public static final int NUM = 8;

    public static void main(String[] args) {
        System.out.println(countSetBits(NUM));
    }

    /**
     * Brian Kernighan’s Algorithm
     *
     * @param num
     * @return
     */
    public static int countSetBits(int num) {
        int count = 0;
        while (num != 0) {
            num = num & (num - 1);
            count++;
        }
        return count;
    }
}
