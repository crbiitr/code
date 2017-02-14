package com.java.StaticKeywordUses;

/**
 * Created by user on 12/4/16.
 * This code shows different ways of using of "static" variables
 */
public class StaticUseCase2 {
    static int price = 100;
    public static void main(String args[])
    {
        System.out.println(price);                          // without object

        StaticUseCase2 sd1 = new StaticUseCase2();
        System.out.println(sd1.price);                    // with object

        System.out.println(StaticUseCase2.price);        // with class name
    }

}
