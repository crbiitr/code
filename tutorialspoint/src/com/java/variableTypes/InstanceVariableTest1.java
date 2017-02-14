package com.java.variableTypes;

/**
 * Created by user on 12/2/16.
 * Note: Instance variables have default values. For numbers, the default value is 0,
 * for Booleans it is false, and for object references it is null.
 * Values can be assigned during the declaration or within the constructor
 */

public class InstanceVariableTest1 {

    // this instance variable is visible for any child class.
    public String name;

    // salary  variable is visible in InstanceVariableTest1 class only.
    private double salary;

    // The name variable is assigned in the constructor.
    public InstanceVariableTest1(String empName) {
        name = empName;
    }

    // The salary variable is assigned a value.
    public void setSalary(double empSal) {
        salary = empSal;
    }

    // This method prints the employee details.
    public void printEmp() {
        System.out.println("name  : " + name );
        System.out.println("salary :" + salary);
    }


    // NOTE: non-static variable name cannot be referenced from a static context.
    public static void printEmpTest() {
//        System.out.println("name  : " + name ); // Error:(32, 41) java: non-static variable name cannot be referenced from a static context
//        System.out.println("salary :" + salary); // Error:(33, 41) java: non-static variable name cannot be referenced from a static context
    }

    public static void main(String args[]) {
        InstanceVariableTest1 empOne = new InstanceVariableTest1("Ransika");
        empOne.setSalary(1000);
        empOne.printEmp();
    }
}


