package com.java.algorithims.Arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by B0204104 on 20/11/18.
 */
public class HamiltonianAndLagrangain {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] result = new int[n];
        Arrays.fill(result,-1);
        int biggest = arr[n-1];
        result[n-1] = biggest;
        for (int i = n-2; i >= 0 ; i--) {
            if(biggest<=arr[i]) {
                biggest = arr[i];
                result[i] = arr[i];
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if(result[i]!=-1) {
                stringBuilder.append(result[i] + " ");
            }
        }
        System.out.println(stringBuilder.toString().trim());

    }
}
