package com.java.java8.functionalInterface;

@FunctionalInterface
interface FunctionInterfaceDemo1 {
    public void m1();
}

@FunctionalInterface
interface Interf1  {
    public void m1();
}

@FunctionalInterface
interface Interf2 {
    public void m1();
    default void m2() {
        //Some statement
    }
    public static void m3() {

    }
}

@FunctionalInterface
interface Interf3 {
    public void m1();
    default void m2() {
        //Some statement
    }
    //Compile time error because of void static => it must be static void
    //NOTE: static must have the body, other wise compile time error
    //public void static m3();
}

/*
//Compile time error

@FunctionalInterface
interface Interf4  {

}

*/

/*
//Compile time error

@FunctionalInterfaceDemo2
interface Interf3 {
    public void m1();
    public void m1();
}

*/

