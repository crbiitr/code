package com.java.exceptionHandling;

import java.io.IOException;
/**
 * Created by user on 2/3/17.
 * Rule: If you are calling a method that declares an exception, you must either caught or declare the exception.
 *
 * There are two cases:
 *        Case1:You caught the exception i.e. handle the exception using try/catch.
 *        Case2:You declare the exception i.e. specifying throws with the method.
 *               A)In case you declare the exception, if exception does not occur, the code will be executed fine.
 *               B)In case you declare the exception if exception occurs, an exception will be thrown at runtime because throws does not handle the exception.
 *
 * **This Example is for:  Case2: You declare the exception
 * **This program is for:  A)Program if exception does not occur
 */


class N {
    void method() throws IOException {
        System.out.println("Device Operation Perform");
    }
}
public class ThrowsTest3 {
    public static void main(String[] args) throws IOException {
        N n = new N();
        n.method();
        System.out.println("Normal Flow...");
    }
}