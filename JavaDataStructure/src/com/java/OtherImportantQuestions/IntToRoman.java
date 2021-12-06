package com.java.OtherImportantQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class IntToRoman {
    public static void main(String[] args) {
        System.out.println("intToRoman:: " + intToRoman(1994));
    }

    public static String intToRoman(int num) {
        LinkedHashMap<Integer, String> map = generateRomanMappingMap();
        int remainder = num;
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Integer,String> entry:map.entrySet()) {
            int divisor = entry.getKey();
            int quotient = num / divisor;
            if (quotient > 0) {
                remainder = num % divisor;
                for (int i = 1; i <= quotient; i++) {
                    sb.append(map.get(divisor));
                }
                num = remainder;
            }
        }
        return sb.toString();
    }

    public static LinkedHashMap<Integer, String> generateRomanMappingMap() {
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1000, "M");
        linkedHashMap.put(900, "CM");
        linkedHashMap.put(500, "D");
        linkedHashMap.put(400, "CD");
        linkedHashMap.put(100, "C");
        linkedHashMap.put(90, "XC");
        linkedHashMap.put(50, "L");
        linkedHashMap.put(40, "XL");
        linkedHashMap.put(10, "X");
        linkedHashMap.put(9, "IX");
        linkedHashMap.put(5, "V");
        linkedHashMap.put(4, "IV");
        linkedHashMap.put(1, "I");
        return linkedHashMap;
    }
}
