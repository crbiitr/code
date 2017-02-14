package com.java.StaticKeywordUses;

/**
 * Created by user on 12/4/16.
 * Note: Static method can not be overridden in Java.
 * NOTE: This shows that static method can not be overridden in Java and concept of
 *          method overloading doesn't apply to static methods. Instead declaring same static
 *          method on Child class is known as 'method hiding' in Java.

 */
public class StaticUseCase5 {
    public static void main(String[] args) {

        StaticUseCase5 super_ = new DirectMarketAccess();
        DirectMarketAccess dma = new DirectMarketAccess();

        // static method of Instrument class will be called,
        // even though object is of sub-class DirectMarketAccess
        super_.printCategory();

        //static method of EquityInstrument class will be called
        dma.printCategory();
    }

    public static void printCategory(){
        System.out.println("inside super class static method");
    }

    public static void display() {
        System.out.println("in display method of Super Class");
    }

}

class DirectMarketAccess extends StaticUseCase5{
    public static void printCategory(){
        System.out.println("inside sub class static method");
    }

    // If you try to override a static method with a non-static method in subclass you will get compilation error
/*
    public void display() { // Error
        System.out.println("in display method of Super Class");
    }
*/
}
