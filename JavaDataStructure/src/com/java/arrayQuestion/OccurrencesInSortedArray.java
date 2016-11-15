package com.java.arrayQuestion;

/**
 * Created by user on 11/15/16.
 * // Important question: here Conditions are very important
 * // http://www.geeksforgeeks.org/count-number-of-occurrences-in-a-sorted-array/
 */
public class OccurrencesInSortedArray {

    public static void main(String[] args) {
        int[] array = {1,1,2,2,2,2,3};
        int x = 2;
        int occurrence = occurrences(array,x);
        if ( occurrence != -1) {
            System.out.println("Output: " + occurrence);
        } else {
            System.out.println("Number is not present in the list");
        }

    }

    public static int occurrences(int[] array, int x) {
        int result = -1;

        int first = first(array,0,array.length,x);
        System.out.println("First:: " + first);
        if (first == -1) {
            return result;
        }

        int last = last(array,0,array.length,x);
        System.out.println("Last:: " + last);
        if (last == -1) {
            return result;
        }
        result = last - first + 1;
        return result;
    }

    public static int first(int[] array, int low, int high, int x) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high)/2;
        if (array[mid] == x && (mid == 0 || array[mid-1] < x)) {
            return mid;
        } else if (x > array[mid]) {
            // Note: mid+1 to high condition must come first for this method
            // if you write x<array[mid] {return first(array, low, mid - 1, x);} first then
            // this code will not work
            return first(array, mid + 1, high, x);
        } else {
            return first(array, low, mid - 1, x);
        }
    }

    public static int last(int[] array, int low, int high, int x) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high)/2;
        if ((mid == array.length-1 || array[mid+1] > x) && array[mid] == x ) {
            return mid;
        } else if (x < array[mid]) {
            // Note: low to mid-1 condition must come first for this method
            // if you write x>array[mid] {return last(array, mid + 1, high, x);} first then
            // this code will not work
            return last(array, low, mid - 1, x);
        } else {
            return last(array, mid + 1, high, x);
        }
    }
}
