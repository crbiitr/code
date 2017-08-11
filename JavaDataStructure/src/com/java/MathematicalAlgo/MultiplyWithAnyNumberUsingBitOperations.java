package com.java.MathematicalAlgo;

/**
 * Created by chetan on 18/5/17.
 *http://www.geeksforgeeks.org/efficient-way-to-multiply-with-7/
 *
 multiply with 2 n<<1

 multiply with 3 (n<<1)+n

 multiply with 4 (n<<2)

 multiply with 5 (n<<2)+n

 multiply with 6 (n<<2)+(n<<1)

 multiply with 7 (n<<3)-n

 multiply with 8 (n<<3)

 multiply with 9 (n<<3)+n

 multiply with 10 (n<<3)+(n<<1)
 */


public class MultiplyWithAnyNumberUsingBitOperations {
    public static void main(String[] args) {
        // here we are demonstrating for digit 7
        System.out.println(multiplyBySeven(8));

    }

    public static int multiplyBySeven(int n) {
        /*
        Explanation:
            N * 7 = n * (8-1) = (4 + 4 -1 ) = N * (4 + 2 +1) So it becomes (n<<2) + (n<<1) + n
         */
        return ((n<<3)-n);

    }
}
