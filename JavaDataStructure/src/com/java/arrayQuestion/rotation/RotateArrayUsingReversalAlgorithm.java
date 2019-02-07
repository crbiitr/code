package com.java.arrayQuestion.rotation;

/**
 * @author Chetan Raj
 *         Question: Write a function rotate(arr[], d, n) that rotates arr[] of size n by d elements.
 * @implNote https://www.geeksforgeeks.org/program-for-array-rotation-continued-reversal-algorithm/
 * @since : 29/01/19
 */
public class RotateArrayUsingReversalAlgorithm {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        int d = 2;
        rotate(array, d);
        printArray(array);
    }

    /**
     * Reversal algorithm for rotation the array
     *
     * @param array
     * @param d
     */
    public static void rotate(int[] array, int d) {
        int length = array.length;
        swapGroupWise(array, 0, d);
        swapGroupWise(array, d, length);
        swapGroupWise(array, 0, length);
    }

    /**
     * Rotate array from low index to high index
     *
     * @param array
     * @param low
     * @param high
     */
    public static void swapGroupWise(int[] array, int low, int high) {
        high=high-1;
        while (low < high) {
            swap(array, low, high);
            low++;
            high--;
        }

    }

    /**
     * Another short form: a ^= b ^= a ^= b;
     *
     * @param array
     * @param low
     * @param high
     */
    public static void swap(int[] array, int low, int high) {
        array[low] = array[low] ^ array[high];
        array[high] = array[low] ^ array[high];
        array[low] = array[low] ^ array[high];
    }

    /**
     * Printing the array
     *
     * @param array
     */
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
