package com.java.finalKeywordPrograms;

/**
 * Created by user on 12/3/16.
 * Note: final non-static global variable must be initialized at the
 * time of declaration or in all constructors or in any one of IIBs – Instance Initialization Blocks.
 */

class FinalTest6
{
    final int i;  //Final non-static global variable may be initialized here  OR

    //may be initialized in any one of IIB's,
    // because while object creation, all IIBs are called.  OR

    {
        i = 30;
    }

    {
        //i = 40;
    }

    //must be initialized in all constructors.
    //because while object creation, only one constructor is called

    FinalTest6() {
        //i=20;
    }

    FinalTest6(int j) {
        // i=j;
    }

    FinalTest6(int j, int k) {
        // i = 50;
    }
}
