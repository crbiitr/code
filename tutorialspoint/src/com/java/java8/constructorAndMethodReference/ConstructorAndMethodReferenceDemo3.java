package com.java.java8.constructorAndMethodReference;

class Test {
    public Test() {
        System.out.println("Test constructor");
    }
}

interface Test1Interface {
    Test get();
}

public class ConstructorAndMethodReferenceDemo3 {
    public static void main(String[] args) {
        //By Using Lambda expression
        System.out.println("By Using Lambda expression");
        Test1Interface test1Interface_ = () -> {
            Test test = new Test();
            return test;
        };
        test1Interface_.get();


        //By Using Constructor Reference
        System.out.println("\nBy Using Constructor Reference");
        Test1Interface test1Interface = Test::new;
        test1Interface.get();
    }
}
