package com.java.dynamicProgramming;

/**
 * Print Maximum number of A's using Ctrl-A, Ctrl-C, Crtl-V
 * Created by user on 8/24/16.
 * It's a DP question but this below solution is a DP solution.
 * It's a very good Question.
 */
public class Max_A_using_ctrlA_ctrlC_ctrlV {

    public static void main(String[] args) {
        int n = 7;
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = -1;
        }

        int result = -1;
        result = findMaxAs(n,array);
        if (result > -1) {
            System.out.println("Maximum A's count is: " + result);
            for (int i = 0; i < result; i++) {
                System.out.print("A ");
            }
        }
    }
    public static int findMaxAs(int n, int[] maxAsSolution) {
        if (n < 0) return -1;
        if (n <= 6) return n;
        int maxSoFar = 0, maxSoFarForThis_i = 0, multiplier = 2;
        for (int i = n-3; i >= 0 ; i--) {
            if (maxAsSolution[i] == -1) {
                maxAsSolution[i] = findMaxAs(i, maxAsSolution);
            }

            maxSoFarForThis_i = multiplier*maxAsSolution[i];

            if (maxSoFarForThis_i > maxSoFar) {
                maxSoFar = maxSoFarForThis_i;
            }
            multiplier+=1;
        }
        return maxSoFar;
    }
}
