package com.java.sorting;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author Chetan Raj Bharti
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 * <p>
 * This algo placing min element to the starting positions
 */
public class SelectionSort {
    public static void main(String[] args) {
        Integer[] array = {4, 3, 7, 2, 9, 1, 5, 4};
        System.out.println("Before sorting: ");
        Stream<Integer> stream = Stream.of(array);
        stream.forEach(System.out::println);

        System.out.println("\nAfter sorting: ");
        SelectionSort S = new SelectionSort();
        S.selectionSort(array);
        Arrays.stream(array).forEach(System.out::println);

    }

    public void selectionSort(Integer[] array) {
        int length = array.length;

        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            swap(array, minIndex, i);
        }
    }

    public void swap(Integer[] array, int i, int j) {
        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
