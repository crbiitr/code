package com.java.variableTypes;

/**
 * Created by user on 12/2/16.
 * Note: Class variables also known as static variables are declared
 * with the static keyword in a class, but outside a method, constructor or a block.
 */

public class ClassOrStaticVariables {

    // salary  variable is a private static variable
    private static double salary;

    // position  variable is a private static variable
    private static double position = 100;

    // DEPARTMENT is a constant
    public static final String DEPARTMENT = "Development ";

    // static block. It executes after initialization of outer static/class variables.
    static {
        position = 200;
        salary = 500;
        System.out.println("In static block");
        System.out.println("{\n\tSalary: " + salary);
        System.out.println("\tPosition: " + position + "\n}");
    }

    public static void main(String args[]) {
        salary = 1000;
        System.out.println(DEPARTMENT + "average salary:" + salary);
    }
}
