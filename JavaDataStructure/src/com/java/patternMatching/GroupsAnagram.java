package com.java.patternMatching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/group-anagrams/
public class GroupsAnagram {
    public static void main(String[] args) {
        // Input: strs = ["eat","tea","tan","ate","nat","bat"]
        // Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
        // String[] strs = {"eat","tea","tan","ate","nat","bat"};
        String[] strs = {"cat","rye","aye","cud","cat","old","fop","bra"};
        System.out.println(groupAnagrams(strs));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String key;
            char[] charArray = new char[26];
            for (char ch:strs[i].toCharArray()) {
                charArray[ch-'a']++;
            }

            key = String.valueOf(charArray);
            if(map.get(key)==null) {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(key,list);
            } else {
                List<String> stringList = map.get(key);
                stringList.add(strs[i]);
                map.put(key,stringList);
            }
        }

        for (Map.Entry<String,List<String>> entry :map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}
