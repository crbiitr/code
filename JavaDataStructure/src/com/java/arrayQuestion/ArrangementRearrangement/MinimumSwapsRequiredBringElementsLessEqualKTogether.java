package com.java.arrayQuestion.ArrangementRearrangement;

/**
 * @author Chetan Raj
 * @implNote https://www.geeksforgeeks.org/minimum-swaps-required-bring-elements-less-equal-k-together/
 * @since : 12/03/19
 */
public class MinimumSwapsRequiredBringElementsLessEqualKTogether {
    public static void main(String[] args) {
        int[] array = {2, 1, 5, 6, 3};
        int[] array1 = {2, 7, 9, 5, 8, 7, 4};
        int ans = getMinimumSwapCount(array, 3);
        int ans1 = getMinimumSwapCount(array1, 5);
        System.out.println(ans);
        System.out.println(ans1);
    }

    /**
     * NOTE: This solution is my approach.
     * Here answer is: Total no. of element less then or equal to K - maximum length of continuous elements which are less then or equal to K
     * <p>
     * GFG has also provided good solution using Sliding Window.
     *
     * @param array
     * @return
     */
    private static int getMinimumSwapCount(int[] array, int k) {
        int totalElementLessThanK = 0;
        int maxLengthOfContinuousElement = 0;

        for (int i = 0; i < array.length; ) {
            int internalMaxLengthOfContinuousElement = 0;
            while (i < array.length && array[i++] <= k) {
                totalElementLessThanK++;
                internalMaxLengthOfContinuousElement++;
            }

            if (internalMaxLengthOfContinuousElement > maxLengthOfContinuousElement) {
                maxLengthOfContinuousElement = internalMaxLengthOfContinuousElement;
            }
        }
        return (totalElementLessThanK - maxLengthOfContinuousElement);
    }


}
