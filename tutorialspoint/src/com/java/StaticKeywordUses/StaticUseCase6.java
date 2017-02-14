package com.java.StaticKeywordUses;

/**
 * Created by user on 12/4/16.
 * Note: http://javarevisited.blogspot.in/2012/03/mixing-static-and-non-static.html
 * Using static and non static synchronized method together for protecting same shared resource is not advisable
 */
public class StaticUseCase6 {
    private static int count = 0;

    //locking on 'this' object lock
    public synchronized int getCount(){
        return count;
    }

    //locking on '.class' object lock
    public static synchronized void increment(){
        count++;
    }

}
