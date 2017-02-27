package com.java.inheritance;

/**
 * Created by chetan on 25/2/17.
 * NOte: Runtime polymorphism can't be achieved by data members.
 */

class A {
    int i =10;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}

class B extends A{
    int i = 20;
    int j = 30;

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    @Override
    public int getI() {
        return i;
    }

    @Override
    public void setI(int i) {
        this.i = i;
    }
}

public class InheritanceTest1 {
    public static void main(String[] args) {
        A a1 = new B();
        System.out.println(a1.i);

        A a2 = new A();
        A a3;
        B b2 = new B();

        a3=a2;
        System.out.println("A3.i :: " + a3.i);

        a3 = b2;
        System.out.println("A3.i :: " + a3.i);
        // System.out.println("A3.i :: " + a3.j); // Error


        a3.i = 50;

        // Not allow
        // a3.j = 50; // Error

        // a3.setJ(60); // Error
    }
}
