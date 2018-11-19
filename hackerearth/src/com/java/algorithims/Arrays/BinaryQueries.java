package com.java.algorithims.Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by B0204104 on 16/11/18.
 */
public class BinaryQueries {
    public static void main(String args[] ) throws Exception {

        // Write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();                // Reading input from STDIN
        String[] arrLengthAndQueryCount = line.split(" ");
        int arrayLength = Integer.parseInt(arrLengthAndQueryCount[0]);
        int queryCount = Integer.parseInt(arrLengthAndQueryCount[1]);


        String arrayLine = br.readLine();
        String[] str = arrayLine.split(" ");
        int [] array = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            array[i] = Integer.parseInt(str[i]);
        }
//        System.out.println("ArrayLength:: " + arrayLength + " and query count:: " + queryCount);
//        System.out.println("array:: " + array.toString());
        String result = null;
        for (int i = 1; i <= queryCount; i++) {
            String query = br.readLine();
//            System.out.println("Query:: " + query);
            String[] querySplit = query.split(" ");
            int[] queryIntArray = new int[querySplit.length];
            for (int j = 0; j < querySplit.length; j++) {
                queryIntArray[j] = Integer.parseInt(querySplit[j]);
            }

            if(queryIntArray[0]==1) {
                flipBit(queryIntArray[1],array);
            } else if(queryIntArray[0]==0) {
                int digit = getDigit(queryIntArray[1],queryIntArray[2],array);
                result = isEven(digit)==0?"EVEN":"ODD";
            }
        }
        System.out.println(result);
    }

    public static int getDigit(int l, int r, int arr[]) {
        int result = 0;
        double pow = 0;
        for (int i = l; i <=r ; i++) {
            int value = (int)Math.pow(2.0,pow);
            result+= arr[i]*value;
        }
        return result;
    }

    public static int[] flipBit(int index, int[]arr) {
        if(arr[index]==1) {
            arr[index]=0;
        } else {
            arr[index]=1;
        }
        return arr;
    }
    static int isEven(int n)
    {

        // n&1 is 1, then
        // odd, else even
        return (n & 1);
    }
}
