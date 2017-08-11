package com.java.MathematicalAlgo;

/**
 * Created by chetan on 5/3/17.
 * http://www.geeksforgeeks.org/square-root-of-a-perfect-square/
 */
public class SquareRootBabyLonianMethod {

    public static double squareRoot(double n)
    {
  /*We are using n itself as initial approximation
   This can definitely be improved */
        double x = n;
        double y = 1;
        double e = 0.001; /* e decides the accuracy level*/
        while(x - y > e)
        {
            x = (x + y)/2;
            y = n/x;
        }
        return x;
    }


    /* Driver program to test above function*/
    // Driver Method
    public static void main(String args[])
    {
        double x = 10;
//        double x = 9;
        System.out.println(squareRoot(x));
    }
}
