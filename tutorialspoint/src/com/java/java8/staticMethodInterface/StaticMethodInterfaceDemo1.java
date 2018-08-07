package com.java.java8.staticMethodInterface;

interface Interf_ {
    //You have to provide definition inside interface because it is static method
    public static void m1(){
        //Some Statement
    }
}

public class StaticMethodInterfaceDemo1 implements Interf_ {

    public static void main(String[] args) {
        StaticMethodInterfaceDemo1 demo1 = new StaticMethodInterfaceDemo1();


        /*****Compile time error*****/
        // demo1.m1();
        // StaticMethodInterfaceDemo1.m1();


        /*
        * This is the only way to call static method of interface
        */
        Interf_.m1();
    }
}


class Test1 implements Interf_ {
    //You can create same static method, No issue
    public static void m1(){
        System.out.println("Inside Test1 class");
    }
}

class Test2 implements Interf_ {
    //You can create the non static m1 method
    public void m1(){
        System.out.println("Inside Test2 class");
    }
}

class Test3 implements Interf_ {
    //You can change the modifier
    private static void m1(){
        System.out.println("Inside Test3 class");
    }
}