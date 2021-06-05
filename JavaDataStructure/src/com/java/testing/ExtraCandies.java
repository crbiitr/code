package com.java.testing;

import java.util.ArrayList;
import java.util.List;

public class ExtraCandies {
    public static void main(String[] args) {
        int candies[] =  {2,3,5,1,3};
        int extraCandies = 3;
        System.out.println(kidsWithCandies(candies,extraCandies));
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max =  Integer.MIN_VALUE;
        for (int tmp: candies) {
            if (max<tmp) max = tmp;
        }
        List<Boolean> list = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            if(candies[i] + extraCandies>=  max) {
                list.add(true);
            } else {
                list.add(false);
            }
        }
        return list;
    }
}
