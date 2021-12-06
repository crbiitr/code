package com.java.testing;

import java.util.Arrays;

public class Catalan {
    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }

    public static int numTrees(int n) {
        int result[] = new int[n+2];
        result[0] = 1;
        result[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                result[i] += result[j] * result[i-j-1];
            }
        }
        for (int i = 0; i < n+1; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
        return result[n];
    }
}
