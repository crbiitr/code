package com.java.arrayQuestion.ArrangementRearrangement;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Question: Rearrange an array such that arr[i] = i
 *
 * @author Chetan Raj
 * @implNote https://www.geeksforgeeks.org/rearrange-array-arri/
 * @since : 07/03/19
 */
public class RearrangeAnArray {
    public static void main(String[] args) {
        int[] array = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
        System.out.println(Arrays.toString(array));
        rearrangeAnArray(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * Rearrange an array such that arr[i] = i
     *
     * @param array
     */
    private static void rearrangeAnArray(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; ) {
            if (array[i] == -1 || array[i] == i) {
                i++;
            } else {
                swapArrayElement(array[i], i, array);
                continue;
            }
        }
    }

    /**
     * Swapping two elements position
     *
     * @param x
     * @param y
     * @param array
     */
    private static void swapArrayElement(int x, int y, int[] array) {
        array[x] = array[x] ^ array[y];
        array[y] = array[x] ^ array[y];
        array[x] = array[x] ^ array[y];
    }
}
