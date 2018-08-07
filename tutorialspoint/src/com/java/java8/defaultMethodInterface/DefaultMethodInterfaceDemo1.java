package com.java.java8.defaultMethodInterface;

/*
* Author: Chetan Raj Bharti
*
* NOTE:
*      You have to define m1 method in Sub Class because both interfaces have same method name and signature,
*      Other wise Compile time Error will come. If name are different then no need to define the default method
*/
interface Left {
    default void m1() {
        System.out.println("Default method of Left Interface");
    }
}

interface Right {
    default void m1() {
        System.out.println("Default method of Right Interface");
    }
}


//NOTE: You have to define m1 method in Sub Class because both interfaces have same method name and signature,
//       Other wise Compile time Error will come. If name are different then no need to define the default method
public class DefaultMethodInterfaceDemo1 implements Left,Right {

    //Have to define default method because name and signature of both methods are same
    @Override
    public void m1() {
        //You can give your own implementation OR can call super method
        System.out.println("M1 of DefaultInterfaceDemo1 class");

        //Calling m1 default method of Left Interface
        Left.super.m1();

        //Calling m1 default method of Right Interface
        Right.super.m1();
    }


    public static void main(String[] args) {
        DefaultMethodInterfaceDemo1 demo1 = new DefaultMethodInterfaceDemo1();
        demo1.m1();
    }
}
