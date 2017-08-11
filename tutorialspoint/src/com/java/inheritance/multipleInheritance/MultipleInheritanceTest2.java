package com.java.inheritance.multipleInheritance;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

/**
 * Created by chetan on 13/3/17.
 */

abstract class ClassA1 {

    public void doSomething(){
        System.out.println("doSomething implementation of A");
    }

    //ClassA own method
    public abstract void methodA();
}

interface InterfaceB {
    void methodA();
}

class ClassC extends ClassA1 implements InterfaceB{

    public void test(){
        //calling super class method
        // doSomething(); Error
    }

    @Override
    public void methodA() {
        System.out.println("Calling from class C");
    }
}


public class MultipleInheritanceTest2 {
    public static void main(String[] args) {

        ClassC c= new ClassC();
        c.methodA();

        System.out.println();
    }
}

