package com.java.algorithims.bitManipulation;

import java.util.Scanner;

/**
 * Created by B0204104 on 21/12/18.
 */
public class HihiAndCrazyBits {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int noOfTestCases = scanner.nextInt();

        for (int i = 0; i < noOfTestCases; i++) {
            long num = scanner.nextLong();
            num = convert(num);
            System.out.println(num);
        }

        System.out.println(Long.MAX_VALUE);
    }

    public static long convert(long num) {
        int i = 0;
        while ((1 << i) > 0) {
            if ((num & (1 << i)) == 0) {
                break;
            }
            i++;
        }
        num = num | (1 << i);
        return num;
    }
}
