package com.java.arrayQuestion;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by chetan on 2/1/18.
 */
/*
INPUT:

5
ab
bb
hefg
dhck
dkhc

OUPUT:
ba
no answer
hegf
dhkc
hcdk
*/
public class NextSmallLexicographically {

    public static void findNextSmallLexicographically(String str) {
        int len = str.length();
        char[] array = str.toCharArray();

        int lIndex = findSmallestFromLeft(array,len);
        if (lIndex!=-1) {
            int rIndex = findSmallestFromRight(array,array[lIndex],lIndex,len);

            if(rIndex!=-1) {
                swap(array,lIndex,rIndex);
                printString(array);
            }else {
                System.out.println("no answer");
            }
        } else {
            System.out.println("no answer");
        }

    }

    public static int findSmallestFromLeft(char[] array, int len) {
        int index = -1;
        for (int i = len-1; i > 0; i--) {
            if(array[i] > array[i-1]) {
                return (i-1);
            }
        }
        return index;
    }
    public static int findSmallestFromRight(char[] array,char ch, int start, int len) {
        int index = -1;
        Arrays.sort(array,start+1,len);
        for (int i = len-1; i > start; i--) {
            if(ch < array[i]) {
                index =i;
            }
        }
        return index;
    }
    static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void printString(char[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            findNextSmallLexicographically (in.next());
        }
    }
}
