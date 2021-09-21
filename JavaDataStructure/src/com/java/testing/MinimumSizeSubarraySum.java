package com.java.testing;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int nums[] = new int[]{ 1, 2,3, 4, 5};
        System.out.println(minSubArrayLen(15, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int n = nums.length;
        int i = 0, j = 1;
        int tempSum = nums[i];
        while (j < n) {
            if (tempSum < target) {
                tempSum += nums[j++];
            } else if (tempSum == target) {
                if (result > j - i) {
                    result = j - i;
                }
                tempSum += nums[j++];

            } else {
                tempSum -= nums[i++];
            }
        }

        while (i < j) {
            if (tempSum >= target) {
                if (result > j - i) {
                    result = j - i;
                }
            }
            tempSum -= nums[i++];

            if (tempSum >= target) {
                if (result > j - i) {
                    result = j - i;
                }
            }
        }
        return result==Integer.MAX_VALUE?0:result;
    }
}
