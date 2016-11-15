package com.java.arrayQuestion;

/**
 * Created by user on 10/31/16.
 * Number of subset of a given set is: 2^n (Here n is the length of the set)
 * http://www.geeksforgeeks.org/finding-all-subsets-of-a-given-set-in-java/
 *
 * Logic: http://javabypatel.blogspot.in/2015/10/all-subsets-of-set-powerset.html
 */
public class FindAllSubsetOfASet {
    public static void main(String[] args) {
        char[] set = {'a','b','c'};
        printAllSubsetOfASet(set);
    }

    public static void printAllSubsetOfASet(char[] set) {
        int n = set.length;

        for (int i = 0; i < (1<<n); i++) {
            System.out.print("{");
            for (int j = 0; j < n; j++) {
                if((i&(1<<j)) > 0) {
                    System.out.print( set[j] + " ");
                }
            }
            System.out.print("}\n");

        }

    }
}
