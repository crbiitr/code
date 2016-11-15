package com.java.testing;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String args[]) {
/*        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        int numberOfElement = scanner.nextInt();

        int ar1[] =  new int[numberOfElement];
        int ar2[] = new int[numberOfElement];
        for(int i=0;i<numberOfElement;i++){
            ar1[i]=scanner.nextInt();
            ar2[i] = scanner.nextInt();

        }
        int result = findMax(ar1,ar2);
        System.out.println(result);
        System.out.println(Arrays.toString(ar1));*/

        int a[] =  {4,2,3,9,7,5,6,8};
        solution(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println( "a[i]:: " + a[i] );
        }
    }

    public static void solution(int a[]) {

        int length = a.length;
        if (length < 0 ) return;

        Stack<Integer> s = new Stack<Integer>();

//s.push(a[0]);

        for (int i = 0; i < length; i++) {

            if(!s.isEmpty()) {
                int top = s.peek();
                if(a[top] > a[i]) {
                    s.push(i);

                } else {
                    a[top] = a[i];
                    s.pop();
                    s.push(i);

                }
            } else {
                s.push(i);
            }
        }

    }





    public static int findMax(int entry[], int exit[]) {
        Arrays.sort(entry);
        Arrays.sort(exit);
        // plat_needed indicates number of platforms needed at a time
        int plat_needed = 1, result = 1;
        int i = 1, j = 0;
        int n = entry.length;

        // Similar to merge in merge sort to process all events in sorted order
        while (i < n && j < n)
        {
            // If next event in sorted order is arrival, increment count of
            // platforms needed
            if (entry[i] < exit[j])
            {
                plat_needed++;
                i++;
                if (plat_needed > result)  // Update result if needed
                    result = plat_needed;
            }
            else // Else decrement count of platforms needed
            {
                plat_needed--;
                j++;
            }
        }



        return result;
    }
}