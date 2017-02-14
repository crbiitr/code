package com.java.exceptionHandling;

/**
 * Created by user on 2/2/17.
 */
public class TestMultipleCatchBlocks2 {
    public static void main(String[] args) {
        try {
            int a[] = new int[5];
            a[5] = 30/0;

        } catch (Exception e) {
            System.out.println("Common Exception");
        }/* catch (ArithmeticException ae) { // Compile time error
            System.out.println("Task1 is completed");
        } catch (IndexOutOfBoundsException ioe) { // Compile time error
            System.out.println("Task2 is completed");
        }*/

        System.out.println("Rest of the code");
    }
}
