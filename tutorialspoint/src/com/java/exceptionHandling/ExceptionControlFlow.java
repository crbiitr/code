package com.java.exceptionHandling;

/**
 * Created by chetan on 5/1/18.
 */
public class ExceptionControlFlow {
    public static void main(String[] args) {
        System.out.println("Case---->1");
        try{
            System.out.println("Case---->2");
            int x = 1/0;
            System.out.println("Case---->3");
            System.out.println("Case---->4");

        }catch(Exception e) {
            System.out.println("Case---->5");
            int x = 1/0;

        }finally {
            int x = 1/0;
            System.out.println("Case---->7");
        }
        System.out.println("Case---->8");
    }
}
