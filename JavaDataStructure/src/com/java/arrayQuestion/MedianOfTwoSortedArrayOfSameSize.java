package com.java.arrayQuestion;
import java.lang.*;

/**
 * Created by user on 10/20/16.
 * There are two solutions. One for O(n) complexity. and second is O(logn).
 */

class MedianOfTwoSortedArrayOfSameSize
{
    public static void main (String[] args) throws java.lang.Exception
    {
        //int[] a1 = new int[]{1, 3, 5, 7, 9};
        //int[] a2 = new int[]{2, 4, 6, 8, 10};

        int[] a1 = new int[]{1, 3, 5, 7};
        int[] a2 = new int[]{2, 4, 6, 8};

        System.out.println("O(n) -> "+getMedian1(a1,a2));
        System.out.println("O(logn) -> "+getMedian2(a1,a2));
    }
    public static float getMedian2(int[] a1,int[] a2){
        int end = a1.length-1;
        return _getMedian2(a1,0,end,a2,0,end);
    }

    private static float _getMedian2(int[] a1, int s1,int e1, int[] a2,int s2, int e2){
        //System.out.println("("+a1[s1]+","+a1[e1]+") to ("+a2[s2]+","+a2[e2]+")");
        int len = e1-s1+1;
        if(len <= 0)
            return -1;
        if(len == 1)
            return (a1[s1]+a2[s2])/2.0f;
        if(len == 2)
            return (Math.max(a1[s1],a2[s2])+Math.min(a1[e1],a2[e2]))/2.0f;
        float m1 = getM(a1,s1,e1);
        float m2 = getM(a2,s2,e2);
        if(m1 == m2)
            return m1;

//        Note: we always drop bigger median
        if(m1 < m2){
            if(len%2 == 0)
                return _getMedian2(a1,s1+(len/2),e1, a2,s2,s2+(len/2)-1);
            return _getMedian2(a1,s1+(len/2),e1, a2,s2,s2+(len/2));
        }

//        Note: we always drop bigger median
        if(len%2 == 0)
            return _getMedian2(a1,s1,s1+(len/2)-1, a2,s2+(len/2),e2);
        return _getMedian2(a1,s1,s1+(len/2), a2,s2+(len/2),e2);
    }

    private static float getM(int[] arr,int s,int e){
        int len = e-s+1;
        int i=len/2;
        if(len%2 == 0){
            return (arr[i]+arr[i+1])/2.0f;
        }
        return arr[i];
    }

    public static float getMedian1(int[] a1,int[] a2){
        int i1 = 0, i2 = 0;
        int len = a1.length;
        int count = 0;
        int med1 = -1, med2 = -1;
        for(count = 0;count <= len;count++){
            /*Below is to handle case where all elements of ar1[] are
          smaller than smallest(or first) element of ar2[]*/
            if(i1 == len){
                med1 = med2;
                med2 = a2[0];
                break;
            }
            /*Below is to handle case where all elements of ar2[] are smaller than smallest(or first) element of ar1[]*/
            else if(i2 == len){
                med1 = med2;
                med2 = a1[0];
                break;
            }
            if(a1[i1] < a2[i2]){
                med1 = med2;/* Store the prev median */
                med2 = a1[i1];
                i1++;
            }else{
                med1 = med2;/* Store the prev median */
                med2 = a2[i2];
                i2++;
            }
        }

        return (med1+med2)/2.0f;
    }
}