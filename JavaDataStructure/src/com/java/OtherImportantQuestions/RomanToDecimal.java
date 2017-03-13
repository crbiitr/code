package com.java.OtherImportantQuestions;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by chetan on 13/3/17.
 * Check it:  http://stackoverflow.com/questions/12967896/converting-integers-to-roman-numerals-java
 */
public class RomanToDecimal {
    static HashMap<Character, Integer> ht = new HashMap<Character, Integer>();
    static {
        ht.put('I', 1);
        ht.put('X', 10);
        ht.put('C', 100);
        ht.put('M', 1000);
        ht.put('V', 5);
        ht.put('L', 50);
        ht.put('D', 500);
    }

    public static void main(String[] args) {
        System.out.println("XCIX => " + rtoi("XCIX"));
        System.out.println("MCMIV => " + rtoi("MCMIV"));
        System.out.println("MCMLXXXVII => " + rtoi("MCMLXXXVII"));
        System.out.println("IMCMLXXXVII => " + rtoi("IMCMLXXXVII"));
    }
    public static int rtoi(String num)
    {
        int intNum=0;
        int prev = 0;
        for(int i = num.length()-1; i>=0 ; i--)
        {
            int temp = ht.get(num.charAt(i));
            if(temp < prev)
                intNum-=temp;
            else
                intNum+=temp;
            prev = temp;
        }
        return intNum;
    }
}
