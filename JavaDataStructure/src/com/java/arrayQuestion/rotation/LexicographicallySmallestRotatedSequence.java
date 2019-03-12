package com.java.arrayQuestion.rotation;

import java.util.Arrays;

/**
 * @author Chetan Raj
 * @implNote https://www.geeksforgeeks.org/lexicographically-smallest-rotated-sequence-set-2/
 * https://www.geeksforgeeks.org/lexicographically-minimum-string-rotation/  (Brute force solution)
 *
 * NOTE: As a brute force solution, create a array of String(all rotation) and sort it. Than result would be
 *       array[0].
 * @since : 06/03/19
 */
public class LexicographicallySmallestRotatedSequence {
    public static void main(String[] args) {
        String str = "BCABDADAB";
        lexicographicallySmallestRotatedSequence(str, str.length());
    }

    private static void lexicographicallySmallestRotatedSequence(String str, int length) {
        char[] charsArray = str.toCharArray();
        int index = 0;
        for (int i = 1; i < length; i++) {
            if (compare(charsArray, index, i, length)) {
                index = i;
            }
        }
        printArray(charsArray,index);
    }

    private static boolean compare(char[] charsArray, int x, int y, int length) {
        for (int j = 0; j < length; j++) {
            if (charsArray[x] < charsArray[y]) {
                return false;
            }
            if (charsArray[x] > charsArray[y]) {
                return true;
            }
            x = (x + 1) % length;
            y = (y + 1) % length;
        }
        return true;
    }

    private static void printArray(char[] charsArray, int index) {
        int n = charsArray.length;
        for (int i = 0; i < charsArray.length; i++) {
            System.out.print(" " + charsArray[(index+i)%n]);
        }
    }

}
