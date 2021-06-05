package com.java.testing;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] array = new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        System.out.println(longestOnes(array, k));

        int[] array2 = new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        k = 3;
        System.out.println(longestOnes(array2, k));

        int[] array3 = new int[]{0,0,1,1,1,0,0};
        k = 0;
        System.out.println(longestOnes(array3, k));

        int[] array4 = new int[]{1,1,1,0,0,0,1,1,1,1};
        k = 0;
        System.out.println(longestOnes(array4, k));
    }

    public static int longestOnes(int[] nums, int k) {
        int start = 0, end = 0, result = 0, zeroCount = 0;
        for(end=0;end<nums.length;end++) {
            if(nums[end]==0) {
                zeroCount++;
            }

            while (zeroCount>k) {
                if(nums[start]==0) {
                    zeroCount--;
                }
                start++;
            }

            result = Math.max(result, end-start+1);
        }
        return result;
    }
}

