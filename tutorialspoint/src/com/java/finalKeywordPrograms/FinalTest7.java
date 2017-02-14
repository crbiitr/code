package com.java.finalKeywordPrograms;

/**
 * Created by user on 12/3/16.
 * Note: final static global variable must be initialized at the time of declaration or in
 * any one of SIBs – Static Initialization Blocks. (final static global variable can’t be initialized in constructors)
 */
public class FinalTest7 {
    static final int i;   //final static global variable may be initialized here OR

    //may be initialized in any one of SIBs.

    static
    {
        i = 30;
    }

    static
    {
        //i = 40;
    }

    //final static global variable can not be initialized in constructors

    FinalTest7()
    {
        //i=20;
    }

    FinalTest7(int j)
    {
        //i=j;
    }

    FinalTest7(int j, int k)
    {
        //i = 50;
    }
}
