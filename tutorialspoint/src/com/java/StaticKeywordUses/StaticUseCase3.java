package com.java.StaticKeywordUses;

/**
 * Created by user on 12/4/16.
 * Note: 'static methods' also and can be called in three ways
 */
public class StaticUseCase3 {
    public static void show()
    {
        System.out.println("Hello World");
    }
    public static void main(String args[])
    {
        show();                                                   // without object

        StaticUseCase3 sd1 = new StaticUseCase3();

        sd1.show();                                               // with object

        StaticUseCase3.show();                                    // with class name
    }

}
