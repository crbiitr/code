package com.java.sorting;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author Chetan Raj Bharti
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 * <p>
 * This algo placing Max element to the last position
 */

public class BubbleSort {
    public static void main(String[] args) {
        Integer[] array = {4, 3, 7, 2, 9, 1, 5, 6};
        System.out.println("Before sorting: ");
        Stream<Integer> stream = Stream.of(array);
        stream.forEach(System.out::println);

        System.out.println("\nAfter sorting: ");
        BubbleSort S = new BubbleSort();
        S.bubbleSort(array);
        Arrays.stream(array).forEach(System.out::println);

    }

    public void bubbleSort(Integer[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }

    }

    public void swap(Integer[] array, int i, int j) {
        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
