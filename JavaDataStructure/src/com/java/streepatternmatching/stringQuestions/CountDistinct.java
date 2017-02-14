package com.java.streepatternmatching.stringQuestions;

import java.util.HashMap;

/**
 * Created by user on 12/5/16.
 * http://www.geeksforgeeks.org/distinct-strings-odd-even-changes-allowed/
 *
 * Note: This solution will work only if every string is of same size.
 */
public class CountDistinct {
    public static void main(String[] args) {
        String[] str = {"abcd", "acbd", "adcb", "cdba", "bcda", "badc"};
        String[] otherStr = {"abcde", "acbd", "adcb", "cdba", "bcda", "badc"};
        System.out.println(countDistinct(str));
        System.out.println(countDistinctForAnyStringLength(otherStr));

    }

    public static int countDistinct(String[] str) {
        int count = 0;
        HashMap<String,Integer> map = new HashMap<String, Integer>();

        for (int i = 0; i < str.length; i++) {
            String encode = encodeString(str[i]);
            if(map.get(encode) == null) {
                map.put(encode,1);
                count++;
            } else {
                map.put(encode, map.get(encode) + 1);
            }
        }
        return count;
    }

    public static int countDistinctForAnyStringLength(String[] str) {
        int count = 0;
        HashMap<String,Integer> map = new HashMap<String, Integer>();

        for (int i = 0; i < str.length; i++) {
            String encode = encodeStringForDiffLength(str[i]);
            if(map.get(encode) == null) {
                map.put(encode,1);
                count++;
            } else {
                map.put(encode, map.get(encode) + 1);
            }
        }


        return count;
    }


    public static String encodeStringForDiffLength(String str) {
        StringBuilder sb = new StringBuilder();

        int odd = 0;
        int even = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i%2==0) {
                even += (str.charAt(i)-'a');
            } else {
                odd += (str.charAt(i)-'a');
            }
        }

        sb.append(even).append("#").append(odd).append(str.length());
        return sb.toString();
    }

    public static String encodeString(String str) {
        StringBuilder sb = new StringBuilder();

        int odd = 0;
        int even = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i%2==0) {
                even += (str.charAt(i)-'a');
            } else {
                odd += (str.charAt(i)-'a');
            }
        }

        sb.append(even).append("#").append(odd);
        return sb.toString();
    }


}
