package com.java.OtherImportantQuestions;

/*
https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));

        int[] height2 = {4,2,0,3,2,5};
        System.out.println(trap(height2));
    }

    public static int trap(int[] height) {
        int[] lHeight = new int[height.length];
        lHeight[0] = height[0];

        for (int i = 1; i < height.length; i++) {
            lHeight[i] = Math.max(lHeight[i-1],height[i]);
        }

        int[] rHeight = new int[height.length];
        rHeight[height.length-1] = height[height.length-1];

        for (int i = height.length-2; i >= 0; i--) {
            rHeight[i] = Math.max(height[i],rHeight[i+1]);
        }

        int[] resultArray = new int[height.length];
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            resultArray[i] = Math.min(lHeight[i],rHeight[i]) - height[i];
            result+=resultArray[i];
        }

        return result;
    }

}
