package com.java.practice;

import java.util.Scanner;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 2019-07-24
 */
public class Staircase {
    static void staircase(int n) {
        for (int i = 0; i < n; i++) {
            int space = n-1-i;
            while(space>0) {
                System.out.print(" ");
                space--;
            }

            int hash = i+1;

            while (hash>0) {
                System.out.print("#");
                hash--;
            }

            System.out.println();
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }
}
