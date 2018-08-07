package com.java.java8.defaultMethodInterface;

/*
* Author: Chetan Raj Bharti
*
* NOTE: No Need to define default method of interface until name are different
* */

interface Left2 {
    default void m1() {
        System.out.println("Default method of Left Interface");
    }
}

interface Right2 {
    default void m2() {
        System.out.println("Default method of Right Interface");
    }
}

//No Need to define default method of interface until name are different
public class DefaultMethodInterfaceDemo2 implements Left2,Right2 {

    public static void main(String[] args) {
        DefaultMethodInterfaceDemo2 demo2 = new DefaultMethodInterfaceDemo2();
        demo2.m1();
        demo2.m2();
    }

}
