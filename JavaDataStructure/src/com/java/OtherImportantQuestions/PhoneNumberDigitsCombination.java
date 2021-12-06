package com.java.OtherImportantQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class PhoneNumberDigitsCombination {

    public static void main(String[] args) {
        List<String> strings = letterCombinations("7");
        System.out.println(strings.toString());
    }

    public static List<String> letterCombinations(String digits) {
        if(digits==null || digits.length()==0) return new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");

        ArrayList<String> result = new ArrayList<>();
        getCombination(map, result, digits, 0, "");
        return result;
    }

    private static void getCombination(HashMap<String, String> map, ArrayList<String> resultList, String  digits, int digitIndex, String result) {
        if (result.length() == digits.length()) {
            resultList.add(result.toString());
            return;
        }

        if(digitIndex<digits.length()) {
            String word = map.get(digits.substring(digitIndex, digitIndex + 1));
            String res1 = result + word.charAt(0);
            String res2 = result + word.charAt(1);
            String res3 = result + word.charAt(2);

            getCombination(map, resultList, digits, digitIndex + 1, res1);
            getCombination(map, resultList, digits, digitIndex + 1, res2);
            getCombination(map, resultList, digits, digitIndex + 1, res3);

            if (digits.substring(digitIndex, digitIndex + 1).equals("7") || digits.substring(digitIndex, digitIndex + 1).equals("9")) {
                String res4 = result + word.charAt(3);
                getCombination(map, resultList, digits, digitIndex + 1, res4);
            }
        }
    }


}
