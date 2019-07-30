package com.java.arrayQuestion.gfgPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author Chetan Raj
 * @implNote :
 * Must Read: https://www.geeksforgeeks.org/how-to-get-rid-of-java-tle-problem/
 * @since : 2019-07-22
 */
public class ReverseArrayInGroups {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int i = 0; i < testCases; i++) {
            String[] conditions = reader.readLine().split(" ");
            int n = Integer.parseInt(conditions[0]);
            int k = Integer.parseInt(conditions[1]);
            String[] stringArray = reader.readLine().split(" ");

            int[] a = new int[stringArray.length];
            for (int j = 0; j < stringArray.length; j++) {
                a[j] = Integer.parseInt(stringArray[j]);
            }


            int start = 0;
            int end = k - 1;
            int x = n / k;
            while (x > 0) {
                reversArray(a, start, end);
                start = end + 1;
                end = end + k;
                x--;
            }

            reversArray(a,(n-(n%k)),n-1);

            printArray(a);
        }
    }

    private static void reversArray(int[] a, int low, int high) {
        while (low < high) {
            swap(a, low, high);
            low++;
            high--;
        }
    }

    private static void swap(int[] a, int low, int high) {
        a[low] = a[low] ^ a[high];
        a[high] = a[low] ^ a[high];
        a[low] = a[low] ^ a[high];
    }

    public static void printArray(int[] array) {
        /*StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]).append(' ');
        }
        System.out.println(sb);*/

        IntStream intStream1 = Arrays.stream(array);
        intStream1.forEach(x -> System.out.print(x + " "));
        System.out.println();
    }
}
