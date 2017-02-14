package com.java.finalKeywordPrograms;

/**
 * Created by user on 12/3/16.
 * Note: When an array reference variable is declared as final, only variable itself is final but not the array elements.
 */
public class FinalTest4 {
    public static void main(String[] args)
    {
        final int X[] = new int[10];     //final array variable

        X[2] = 10;
        X[2] = 20;     //Array element can be re-assigned

        // X = new int[30];  //compile time error
        // can't re-assign new array object to final array variable
    }
}
