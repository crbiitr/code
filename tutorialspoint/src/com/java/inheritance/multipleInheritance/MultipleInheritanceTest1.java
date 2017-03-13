package com.java.inheritance.multipleInheritance;

/**
 * Created by chetan on 11/3/17.
 */
abstract class SuperClass {

    public abstract void doSomething();
}

class ClassA extends SuperClass{

    @Override
    public void doSomething(){
        System.out.println("doSomething implementation of A");
    }

    //ClassA own method
    public void methodA(){

    }
}

class ClassB extends SuperClass{

    @Override
    public void doSomething(){
        System.out.println("doSomething implementation of B");
    }

    //ClassB specific method
    public void methodB(){

    }
}

/*
class ClassC extends ClassA, ClassB{

    public void test(){
        //calling super class method
        // doSomething(); Error
    }

}
*/

public class MultipleInheritanceTest1 {
    public static void main(String[] args) {

    }
}
