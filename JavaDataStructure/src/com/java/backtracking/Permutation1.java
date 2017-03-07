package com.java.backtracking;

import java.util.Arrays;

/**
 * Created by chetan on 6/3/17.
 * http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
 * This program only work for distinct characters.
 */
public class Permutation1 {

    public static void main(String[] args) {
        String str = "ABC";
        // String str = "AABC"; // This program only work for distinct characters.

        Permutation1 p = new Permutation1();
        p.permute(str.toCharArray(),0,str.length()-1);
    }

    public void permute(char[] array, int left, int right) {
        if (left == right) {
            printArray(array);
        } else {
            for (int i = left; i <= right ; i++) {
                swap(array,left,i);
                permute(array,left+1,right);
                swap(array,left,i);
            }
        }
    }

    public void swap(char[] array, int leftIndex, int rightIndex) {
        char temp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = temp;
    }

    public void printArray(char[] array) {
        for (char ch : array) {
            System.out.print(ch + " ");
        }
        System.out.println();
    }

}
