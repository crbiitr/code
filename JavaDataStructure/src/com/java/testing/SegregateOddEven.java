package com.java.testing;

/**
 * Created by user on 11/23/16.
 */
import java.io.*;

class SegregateOddEven
{
    static int segregateEvenOdd(int a[])
    {
        /* Initialize low and high indexes */
        int low = 0, high = a.length - 1;
        int count = 0;
        while (low < high)
        {
            while (a[low]%2 == 0 && low < high)
                low++;

            while (a[high]%2 == 1 && low < high)
                high--;

            if (low < high)
            {
                count++;
                int temp = a[low];
                a[low] = a[high];
                a[high] = temp;
                low++;
                high--;
            }
        }
        return count;
    }

    /* Driver program to test above functions */
    public static void main (String[] args)
    {
//        int arr[] = {12, 34, 45, 9, 8, 90, 3};
//        int arr[] = {13, 10, 21, 20};
        int arr[] = {8, 5, 11, 4, 6};


        System.out.println(segregateEvenOdd(arr));

        System.out.print("Array after segregation ");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i]+" ");
    }
}