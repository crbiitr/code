package com.java.bitMagic;

/**
 * @author Chetan Raj
 * @implNote https://www.geeksforgeeks.org/find-whether-a-given-number-is-a-power-of-4-or-not/
 * @since : 11/01/19
 */
public class PowerOf4orNot {
    public static void main(String[] args) {
        if(powerOf4_OrNot(16)) {
            System.out.println("This is a power of 4");
        } else {
            System.out.println("This is not a power of 4");

        }
    }

    /**
     *
     * @param num
     * @return
     */
    public static boolean powerOf4_OrNot (int num) {
        boolean isTrue = false;
        int count =0;
        int x = num & num-1;
        if(num > 0 && x == 0) {
            while(num>1) {
                num=num>>1;
                count++;
            }
            return count%4==0?true:false;
        }
        return isTrue;
    }
}
