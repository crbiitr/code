package com.java.StaticKeywordUses;

/**
 * Created by user on 12/4/16.
 */
public class StaticUseCase7 {

    private static String category = "electronic trading system";
    public static void main(String[] args) {
        StaticUseCase7 system = null;

        System.out.println("Case---->1:  " + category);
        System.out.println("Case---->2:  " + system.category);
    }
}