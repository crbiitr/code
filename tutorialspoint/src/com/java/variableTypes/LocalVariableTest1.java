package com.java.variableTypes;

/**
 * Created by user on 12/2/16.
 * https://www.tutorialspoint.com/java/java_variable_types.htm
 */
public class LocalVariableTest1 {
    public void pupAge() {

        // int age;    Error: LocalVariableTest1.java:9:variable number might not have been initialized
        int age = 0;
        age = age + 7;
        System.out.println("Puppy age is : " + age);
    }

    public static void display() {
        int x =1; // default specifier
        final int y = 1; // final modifier with default specifier
        final int z;

//        Local variables can only have default specifier, final modifier and combination of both.
//        But other specifier and modifiers can not use on local variables)
//        Means following are not possible
/*
        static final int z = 2;
        public final int z = 2;
        protected final int z = 2;
        private final int z = 2;
 */

        System.out.println("In Display Method");
    }

    public static void main(String args[]) {
        LocalVariableTest1 test = new LocalVariableTest1();
        test.pupAge();
    }
}
