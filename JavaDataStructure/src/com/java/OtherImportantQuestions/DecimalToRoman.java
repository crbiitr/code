package com.java.OtherImportantQuestions;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by chetan on 13/3/17.
 */
public class DecimalToRoman {
    public static String romanToInteger(int Int) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);
        String res = "";
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            int matches = Int/entry.getValue();
            res += repeat(entry.getKey(), matches);
            Int = Int % entry.getValue();
        }
        return res;
    }
    public static String repeat(String s, int n) {
        if(s == null) {
            return null;
        }
        final StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < n; i++) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
    static String[] romanizer(int[] numbers) {
        int n = numbers.length;
        String[] romanArray = new String[n];
        for (int i = 0; i < n; i++) {
            int num = numbers[i];
            romanArray[i] = (romanToInteger(num));
        }
        return romanArray;
    }
    public static void main(String[] args) {

        int numbers[] = {75,80,99,100,50};
        int n = numbers.length;
        String[] str = new String[n];
        str = romanizer(numbers);
        for (int i = 0; i < n; i++) {
            System.out.println(str[i]);
        }
    }
}
