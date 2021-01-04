package com.java.testing;

import java.util.Arrays;

public class JewelsAndStonesLeetCode {
    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA","aAAbbbb"));
        System.out.println(numJewelsInStones("z","ZZ"));

    }

    public static int numJewelsInStones(String jewels, String stones) {
        char[] charsArray = jewels.toCharArray();
        int [] intArray = new int[127];
        Arrays.fill(intArray,0);

        for (int i = 0; i < charsArray.length; i++) {
            intArray[charsArray[i]] = 1;
        }

        int count = 0;
        for (char ch : stones.toCharArray()) {
            if(intArray[ch]==1) count++;
        }
        return count;
    }
}
