package com.java.dynamicProgramming;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chetan on 7/3/17.
 */
public class AllUniquePallindrome {
    Set<String> set = new HashSet<String>();
    public void palindromDp(String str) {
        int len = str.length();
        boolean[][] t = new boolean[len][len];

/* Level 1*/
        for (int i = 0; i < len; i++) {
            t[i][i] = true;
            set.add(Character.toString(str.charAt(i)));
        }

/* Level 2*/
        for (int i = 0; i < len - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1))
                t[i][i + 1] = true;
            else
                t[i][i + 1] = false;
        }

/* Level > 2*/
        for (int i = 3; i < len - 1; i++) {
            for (int j = 0; j < len - i + 1; j++) {
                int k = j + i - 1;
                if (str.charAt(j) == str.charAt(k)) {
                    t[j][k] = true;
                }
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.print(t[i][j] + "\t");
                if (t[i][j] == true) {
                    String pal = str.substring(i, j + 1);
                    if (!pal.isEmpty()) {
                        set.add(pal);
                    }
                }
            }
            System.out.println();
        }

        for (String s : set) {
            System.out.println(s);
        }

    }

    public static void main(String[] args) {
        String str = "abaaa";
        AllUniquePallindrome p = new AllUniquePallindrome();
        p.palindromDp(str);
    }
}
