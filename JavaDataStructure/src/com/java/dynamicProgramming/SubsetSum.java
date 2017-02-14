package com.java.dynamicProgramming;

/**
 * Created by user on 12/8/16.
 */
public class SubsetSum {
    public boolean subsetSum(int input[], int total) {
        boolean T[][] = new boolean[input.length + 1][total + 1];
        for (int i = 0; i <= input.length; i++) {
            T[i][0] = true;
        }
        System.out.println("Before calculation: ");
        printMat(T,input,total);
        for (int i = 1; i <= input.length; i++) {
            for (int j = 1; j <= total; j++) {
                if (j - input[i - 1] >= 0) {
                    T[i][j] = T[i - 1][j] || T[i - 1][j - input[i - 1]];
                } else {
                    T[i][j] = T[i-1][j];
                }
            }
        }

        System.out.println("\n\n\n\nAfter calculation: ");
        printMat(T,input,total);

        return T[input.length][total];
    }
    public boolean partition(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum = sum / 2;
        boolean[][] T = new boolean[arr.length + 1][sum + 1];
        for (int i = 0; i <= arr.length; i++) {
            T[i][0] = true;
        }
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - arr[i - 1] >= 0) {
                    T[i][j] = T[i - 1][j - arr[i - 1]] || T[i - 1][j];
                } else {
                    T[i][j] = T[i-1][j];
                }
            }
        }
        return T[arr.length][sum];
    }
    public static void main(String args[]) {
        SubsetSum ss = new SubsetSum();
        int arr[] = {1, 3, 5, 5, 2, 1, 1, 6};
        System.out.println(ss.partition(arr));
        int arr1[] = {2, 3, 7, 8};
        System.out.print(ss.subsetSum(arr1, 11));
    }

    public static void printMat(boolean T[][],int[] input, int total) {
        boolean flag = true;

        for (int j = 0; j <= total; j++) {
                System.out.print("   " + j + "  ");
        }
        System.out.println();
        for (int i = 0; i <=input.length; i++) {
//            System.out.print(input[i]);
            for (int j = 0; j <= total; j++) {
                System.out.print(" " + T[i][j]);
            }
            flag = false;
            System.out.println();
        }
    }
}
