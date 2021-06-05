package com.java.testing;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String str = "abcabcabc";
        String str2 = "bbbbb";
        String str3 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(str));
        System.out.println(lengthOfLongestSubstring(str2));
        System.out.println(lengthOfLongestSubstring(str3));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.trim().length() == 1) return 1;
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int maxCount = 0;
        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {

            if (map.containsKey(s.charAt(end))) {
                int value = map.get(s.charAt(end));
                value++;
                map.put(s.charAt(end), value);
            } else {
                map.put(s.charAt(end), 1);
            }

            if (map.size() == (end - start + 1)) {
                maxCount = Math.max(maxCount, end-start+1);
                end++;
            } else if (map.size() < (end - start + 1)) {
                while (map.size() < (end - start + 1)) {
                    int value = map.get(s.charAt(start));
                    value--;
                    map.put(s.charAt(start), value);

                    if (map.get(s.charAt(start)) == 0) {
                        map.remove(s.charAt(start));
                    }
                    start++;
                }
                end++;
            }
        }
        return maxCount;
    }
}
