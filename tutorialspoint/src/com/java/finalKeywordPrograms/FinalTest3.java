package com.java.finalKeywordPrograms;

/**
 * Created by user on 12/3/16.
 * Note: final method can be overloaded and that overloaded method can be overridden in the sub class.
 */
public class FinalTest3 {
    final void methodOne()
    {
        //final method
    }

    void methodOne(int i)
    {
        //final method can be overloaded
    }
}
class SubClass extends FinalTest3
{
    @Override
    void methodOne(int i)
    {
        //Overloaded method can be overridden
    }
}
