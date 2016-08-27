package com.java.streepatternmatching;

/**
 * Created by user on 8/24/16.
 * This can be done by DP also. But here it is a simple solution.
 * For DP solution check in dynamicProgramming package for class name LongestPalindromicSubstring.
 *
 * For DP check this below link:
 * https://www.youtube.com/watch?annotation_id=annotation_1075415315&feature=iv&src_vid=U4yPae3GEO0&v=obBdxeCx_Qs
 */
public class LongestPalindromicSubstring {
//    private final static String str = "BANANAS";
    private final static String str = "BANNAS";

    private static void longestPalindromicSubstring() {
        int outerMax = 0;
        int startingIndex = -1;
        int max = 0;
        for (int k = 0; k < str.length() - 1; k++) {
            int i = k;max=0;
            for (int j = str.length()-1; j > i; j--) {
                if (str.charAt(i) == str.charAt(j)) {
                    max += 2;
                    i++;
                } else {
                    i = k;
                    max = 0;
                }

                if (i == j && outerMax <= max) {
                    outerMax = max;
                    startingIndex = k;
                }else if (i == j-1 && outerMax <= max) {
                    outerMax = max + 1;
                    startingIndex = k;
                }
            }
        }

        System.out.println("MaxLength: " + outerMax);
        System.out.println("Starting index: " + startingIndex);
    }

    public static void main(String[] args) {
        longestPalindromicSubstring();
    }
}
