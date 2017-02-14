package com.java.exceptionHandling;

/**
 * Created by user on 2/2/17.
 */
public class TestMultipleCatchBlocks {
    public static void main(String[] args) {
        try {
            int a[] = new int[5];
            a[5] = 30/0;

        } catch (ArithmeticException ae) {
            System.out.println("Task1 is completed");
        } catch (IndexOutOfBoundsException ioe) {
            System.out.println("Task2 is completed");
        } catch (Exception e) {
            System.out.println("Common Exception");
        }

        System.out.println("Rest of the code");
    }
}
