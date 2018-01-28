package com.java.inheritance;

/**
 * Created by chetan on 25/1/18.
 */
public class OverLoadedInterviewQuestion1 {

    public void print(String str) {
        System.out.println("In String argument method");
    }

    public void print(Object str) {
        System.out.println("In String argument method");
    }

    public static void main(String[] args) {
        OverLoadedInterviewQuestion1 obj = new OverLoadedInterviewQuestion1();
        obj.print(null);
    }
}
