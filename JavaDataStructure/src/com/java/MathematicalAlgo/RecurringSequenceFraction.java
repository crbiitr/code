package com.java.MathematicalAlgo;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by chetan on 4/2/18.
 */
public class RecurringSequenceFraction {
    public static void main(String args[]){
        int numr=1, denr=28;
//        int numr=1, denr=6;
//        int numr=50, denr=22;
        String res=ftod(numr,denr);
        if("".equals(res))
            System.out.println("No recc");
        else
            System.out.println(res);
    }

    private static String ftod(int numr, int denr) {
        String res="";
        Map<Integer,Integer> mp = new TreeMap<>();
        int rem = numr%denr;
        while((rem!=0) && (!mp.containsKey(rem))){
            mp.put(rem, res.length());
            rem=rem*10;
            int res_Part=rem/denr;
            res+=Integer.toString(res_Part);
            rem=rem%denr;
        }
        return (rem==0)?"":res.substring(mp.get(rem));
    }

}