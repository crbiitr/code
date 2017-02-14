package com.java.finalKeywordPrograms;

/**
 * Created by user on 12/3/16.
 */
public class FinalTest5 {
    public static void main(String[] args)
    {
        A a = new A();

        // a.i = 10;     //Compile time error
        // a.j = 20;     //even you can't assign same value to final variables

        a.methodOne(20);
    }
}
class A
{
    static final int i = 10;   //final static variable
    final int j = 20;          //final non-static variable

    void methodOne(final int k)
    {
        System.out.println("K: " + k);
        // k is final local variable
        // k = 20;   //compile time error
    }
}
