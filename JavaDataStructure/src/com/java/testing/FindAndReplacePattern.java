package com.java.testing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/*
    https://leetcode.com/problems/find-and-replace-pattern/
 */
public class FindAndReplacePattern {
    public static void main(String[] args) {
        String words[] = new String[]{"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";
        // Output: ["mee","aqq"]

        FindAndReplacePattern findAndReplacePattern = new FindAndReplacePattern();
        List<String> list = findAndReplacePattern.findAndReplacePattern(words, pattern);
        System.out.println(list.toString());
        /*Input: words = ["a","b","c"], pattern = "a"
        Output: ["a","b","c"]*/
    }

    public  List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        HashMap<Character, String> map = new HashMap<>();
        map = generateMap(map,pattern);
        String commonPattern = generatePatter(map,pattern);

        for (String word:words) {
            map = generateMap(map,word);
            String wordPattern = generatePatter(map,word);
            if(wordPattern.equals(commonPattern)) {
                result.add(word);
            }
        }
        return result;
    }

    private HashMap<Character, String> generateMap(HashMap<Character, String> map, String word) {
        map.clear();
        int count = 0;
        for (char ch:word.toCharArray()) {
            if(map.get(ch)==null) {
                map.put(ch,String.valueOf(count));
                count++;
            }
        }
        return map;
    }

    private String generatePatter(HashMap<Character, String> map, String pattern) {
        StringBuilder result = new StringBuilder();

        for (char ch:pattern.toCharArray()) {
            if(map.get(ch)!=null) {
                result.append(map.get(ch));
            }
        }
        return result.toString();
    }
}
