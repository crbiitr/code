package com.java.sorting;

import java.util.Arrays;

/**
 * @author Chetan Raj Bharti
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 * <p>
 * This algo inserting smaller value to statring position
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {4, 3, 7, 2, 9, 1, 5, 6};
        System.out.println("Before Insertion Sort: ");
        Arrays.stream(array).forEach(System.out::println);

        InsertionSort obj = new InsertionSort();
        obj.insertionSort(array);
        System.out.println("\nAfter Insertion Sort: ");
        Arrays.stream(array).forEach(System.out::println);
    }

    public void insertionSort(int[] array) {
        int length = array.length;
        for (int i = 1; i < length; i++) {
            int value = array[i];
            int hole = i;

            while (hole > 0 && value < array[hole - 1]) {
                array[hole] = array[hole - 1];
                hole--;
            }
            array[hole] = value;
        }
    }
}
