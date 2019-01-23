package com.java.bitMagic;

/**
 * @author Chetan Raj
 * @implNote  FIRST SOLUTION IN GFG IS WRONG. SO I CHANGED THE CODE IN MY SOLUTION. NOW IT IS WORKING.
 * https://www.geeksforgeeks.org/add-1-to-a-given-number/
 * @since : 11/01/19
 */
public class Add1WithoutPlus {
    public static void main(String[] args) {
        System.out.println(addOne(15));
        System.out.println(addOne(11));
        System.out.println(addOneAnotherMethod(15));
        System.out.println("Negative numbers::");
        System.out.println(addOne(-15));
        System.out.println(addOneAnotherMethod(-15));
    }

    /**
     * To add 1 to a number x (say 0011000111), flip all the bits after the rightmost 0 bit (we get 0011000000).
     * Finally, flip the rightmost 0 bit also (we get 0011001000) to get the answer.
     * @param x
     * @return
     */
    public static int addOne(int x) {
        int m = 1;

        while((x & m) != 0) {
            x = x ^ m;
            m = m << 1;
        }

        x = x ^ m;
        return x;
    }

    /**
     * Say, x is numerical value of a number, then
     * ~x = -(x+1) [ ~ is for bitwise complement ]
     * (x + 1) is due to addition of 1 in 2’s complement conversion.
     * To get (x + 1) apply negation once again. So, the final expression becomes (-(~x)).
     * @param x
     * @return
     */
    static int addOneAnotherMethod(int x)
    {
        return (-(~x));
    }
}
