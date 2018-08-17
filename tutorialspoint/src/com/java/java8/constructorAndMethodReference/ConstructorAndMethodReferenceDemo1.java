package com.java.java8.constructorAndMethodReference;

/**
 * @author Chetan Raj Bharti
 * @implNote
 * Both method must have same argument type
 * Both method can have different modifier, Method name, Return type, Static/Non Static scope
 */
interface TestInterface {
    public void method1();
}
public class ConstructorAndMethodReferenceDemo1 {
    public static void method2() {
        System.out.println("Inside Method2()===>");
    }
    public static void main(String[] args) {
        TestInterface testInterface = ConstructorAndMethodReferenceDemo1::method2;
        testInterface.method1();
    }
}
