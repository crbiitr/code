package com.java.arrayQuestion.rotation;

/**
 * @author Chetan Raj
 * @implNote https://www.geeksforgeeks.org/given-a-sorted-and-rotated-array-find-if-there-is-a-pair-with-a-given-sum/
 * In this link, one more approach is to find all the existing pairs in the array. Check that also.
 * ****************************************************************
 * There can be a another solution with finding pivot element:
 * find pivot O(log n) + sort the given array using reversal algorithm O(n) + apply algorithm to find sum O(n) => O(n)
 * But in this solution array will change.
 * ****************************************************************
 * @since : 01/02/19
 */
public class PairSumInSortedRotatedArray {
    public static void main(String[] args) {
        int[] sortedRotedArray = {11, 15, 6, 8, 9, 10};
        int sum = 16;
        int n = sortedRotedArray.length;
        boolean result = pairSumInSortedRotedArray(sortedRotedArray,sortedRotedArray.length,sum);
        if(result) {
            System.out.println("Pair exist");
        } else {
            System.out.println("Pair doesn't exist");
        }
    }

    /**
     * Time: O(n), Space: O(1)
     * @param sortedRotedArray
     * @param length
     * @param sum
     * @return
     */
    public static boolean pairSumInSortedRotedArray(int[] sortedRotedArray, int length, int sum) {
        int low = 0, high = length;
        for (int i = 0; i < length - 1; i++) {
            if (sortedRotedArray[i] > sortedRotedArray[i + 1]) {
                high = i;
                low = i + 1;
                break;
            }
        }

        while (low != high) {
            if (sortedRotedArray[low] + sortedRotedArray[high] == sum) {
                return true;
            }
            if (sortedRotedArray[low] + sortedRotedArray[high] < sum) {
                low = (length + low + 1) % length;
            } else {
                high = (length + high - 1) % length;
            }
        }
        return false;
    }
}
