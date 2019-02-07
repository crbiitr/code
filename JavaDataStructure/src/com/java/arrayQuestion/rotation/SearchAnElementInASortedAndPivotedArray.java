package com.java.arrayQuestion.rotation;

/**
 * @author Chetan Raj
 * @implNote https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 * This link has first solution using Pivot and Second solution using single logic
 * @since : 31/01/19
 */
public class SearchAnElementInASortedAndPivotedArray {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        int key = 1;
        int result = searchUsingWithoutPivot(arr, 0, arr.length - 1, key);
        if (result == -1) {
            System.out.println("There is no element :: " + key);
        } else {
            System.out.println("Element exist at location :: " + result);
        }
    }

    /**
     * The method to find element without using Pivot logic
     * @param arr
     * @param low
     * @param high
     * @param key
     * @return Index of key in arr[l..h] if key is present, otherwise returns -1
     */
    public static int searchUsingWithoutPivot(int[] arr, int low, int high, int key) {
        if (low > high) return -1;

        int mid = (low + high) / 2;
        if (arr[mid] == key) return mid;
        /* If arr[l...mid] is sorted */
        if (arr[low] <= arr[mid]) {

            /* As this sub-array is sorted, we can quickly check if key lies in half or other half */
            if (key >= arr[low] && arr[mid] >= key) {
                return searchUsingWithoutPivot(arr, low, mid - 1, key);
            } else {
                return searchUsingWithoutPivot(arr, mid + 1, high, key);
            }
        } else { /* If arr[l..mid] is not sorted, then arr[mid... r] must be sorted*/
            if (key >= arr[mid] && arr[high] >= key) {
                return searchUsingWithoutPivot(arr, mid + 1, high, key);
            } else {
                return searchUsingWithoutPivot(arr, low, mid - 1, key);
            }
        }
    }

    /**
     * TODO: Implementation
     * @param arr
     * @param low
     * @param high
     * @param key
     */
    public static void searchUsingPivotMethod(int[] arr, int low, int high, int key) {

    }
}
