package com.java.queueDS.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
    Maximum Number of Vowels in a Substring of Given Length
    https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
 */
public class MaximumVowels {
    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        System.out.println("result1: " + vowelsCount(s, k));

        s = "aeiou";
        k = 2;
        System.out.println("result2: " + vowelsCount(s, k));

        s = "leetcode";
        k = 3;
        System.out.println("result3: " + vowelsCount(s, k));

        s = "rhythms";
        k = 4;
        System.out.println("result4: " + vowelsCount(s, k));

        s = "tryhard";
        k = 4;
        System.out.println("result5: " + vowelsCount(s, k));


    }

    public static int vowelsCount(String str, int k) {
        Set<Integer> set = new HashSet<>();
        char arr[] = str.toCharArray();
        int i = 0, result = 0;

        for (i = 0; i < k; i++) {
            if (isVowel(arr[i])) {
                set.add(i);
            }
        }
        if (set.size() > 0) result = set.size();

        for (; i < arr.length; i++) {
            // Remove old vowel
            if (set.contains(i - k))
                set.remove(i - k);

            // add new vowel
            if (isVowel(arr[i]))
                set.add(i);

            // result
            if (result < set.size())
                result = set.size();
        }
        return result;
    }

    public static boolean isVowel(char ch) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a', 1);
        map.put('e', 1);
        map.put('i', 1);
        map.put('o', 1);
        map.put('u', 1);
        return map.containsKey(ch) ? true : false;
    }
}
