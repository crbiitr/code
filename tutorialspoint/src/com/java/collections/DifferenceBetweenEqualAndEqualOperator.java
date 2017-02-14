package com.java.collections;

/**
 * //http://javarevisited.blogspot.com/2012/12/difference-between-equals-method-and-equality-operator-java.html#ixzz4Ja1zLyDJ
 * Created by user on 9/7/16.
 */
public class DifferenceBetweenEqualAndEqualOperator {

    public static void main(String[] args) {

        // Very Important case
        String personalLoan = "cheap personal loans";
        String homeLoan = "cheap personal loans";

        // Very Important case
//        String personalLoan = new String("cheap personal loans");
//        String homeLoan = new String("cheap personal loans");

        //since two strings are different object result should be false
        boolean result = personalLoan == homeLoan;
        System.out.println("Comparing two strings with == operator: " + result);

        //since strings contains same content , equals() should return true
        result = personalLoan.equals(homeLoan);
        System.out.println("Comparing two Strings with same content using equals method: " + result);

        homeLoan = personalLoan;
        //since both homeLoan and personalLoand reference variable are pointing to same object
        //"==" should return true
        result = (personalLoan == homeLoan);
        System.out.println("Comparing two reference pointing to same String with == operator: " + result);

        // For Object Comparition
        Object obj1 = new Object();
        Object obj2 = new Object();

        // == should return false
        result = (obj1==obj2);
        System.out.println("\n\nComparing two different Objects with == operator: " + result);

        //equals should return false because obj1 and obj2 are different
        result = obj1.equals(obj2);
        System.out.println("Comparing two different Objects with equals() method: " + result);

        // "==" should return true because both obj1 and obj2 points same object
        obj1=obj2;
        result = (obj1==obj2);
        System.out.println("Comparing two reference pointing to same Object with == operator: " + result);


    }

}
