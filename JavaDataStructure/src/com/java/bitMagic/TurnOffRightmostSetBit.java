package com.java.bitMagic;

/**
 * @author Chetan Raj
 * @implNote https://www.geeksforgeeks.org/turn-off-the-rightmost-set-bit/
 * @since : 11/01/19
 */
public class TurnOffRightmostSetBit {
    public static void main(String[] args) {
        System.out.println(turnOffRightmostSetBit(12));
    }

    /**
     * Turn off the rightmost set bit
     * @param n
     * @return
     */
    public static int turnOffRightmostSetBit(int n)
    {
        return n & (n - 1);
    }
}
