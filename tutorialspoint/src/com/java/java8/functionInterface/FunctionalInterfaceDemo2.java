package com.java.java8.functionInterface;

@FunctionalInterface
public interface FunctionalInterfaceDemo2 {

    public void m1();
    default void m2() {
        //Some statement
    }
    public static void m3() {

    }
}
