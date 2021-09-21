package com.java.testing;

import java.util.Arrays;
import java.util.HashMap;

public class LongestSubstringWithKRepeatingCharacters {
    public static void main(String[] args) {
        int arr1[] = {1,2,1};
        int arr2[] = {0,1,2,2};
        int arr3[] = {1,2,3,2,2};
        int arr4[] = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(lengthOfLongestSubstring(arr1));
        System.out.println(lengthOfLongestSubstring(arr2));
        System.out.println(lengthOfLongestSubstring(arr3));
        System.out.println(lengthOfLongestSubstring(arr4));
    }

    public static int lengthOfLongestSubstring(int[] fruits) {
        int maxCount = -1;
        int start = 0, end = 0, k = 2; // k: basket
        HashMap<Integer, Integer> map = new HashMap<>();
        while (end < fruits.length) {
            if (map.containsKey(fruits[end])) {
                map.put(fruits[end], map.get(fruits[end]) + 1);
            } else {
                map.put(fruits[end], 1);
            }

            if (map.size() < k) {
                end++;
            } else if (map.size() == k) {
                if (maxCount < (end - start + 1)) {
                    maxCount = end - start + 1;
                }
                end++;
            } else if (map.size() > k) {
                while (map.size()>k) {
                    int count = map.get(fruits[start]);
                    count--;
                    map.put(fruits[start],count);

                    if(map.get(fruits[start])==0) {
                        map.remove(fruits[start]);
                    }
                    start++;
                }
                end++;
            }
        }
        return  (maxCount==-1)?end-start:maxCount;
    }
    //public int totalFruit(int[] fruits) {
}
