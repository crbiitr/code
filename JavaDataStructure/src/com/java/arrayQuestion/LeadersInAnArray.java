package com.java.arrayQuestion;

/**
 * Created by user on 10/21/16.
 */
public class LeadersInAnArray {
    public static void main(String[] args) {
        int array[] = {16, 17, 4, 3, 5, 2};
        getLeaders(array);
    }

    public static void getLeaders(int arr[]) {
        int length = arr.length;
        int x= arr[length-1];
        for (int i = length-2; i >= 0; i--) {
            if (x < arr[i]) {
                System.out.println(x);
                x = arr[i];
            }
        }
        // for last leader element
        System.out.println(x);
    }
}
