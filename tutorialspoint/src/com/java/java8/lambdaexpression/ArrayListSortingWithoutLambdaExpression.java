package com.java.java8.lambdaexpression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArrayListSortingWithoutLambdaExpression {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(10);
        arrayList.add(6);
        arrayList.add(17);
        arrayList.add(9);
        arrayList.add(1);
        arrayList.add(2);

        Collections.sort(arrayList, new MyComparator());
        System.out.println("Print array list: " + arrayList.toString());

    }
}

class MyComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer I1, Integer I2) {
        if(I1>I2) return -1;
        else if (I1<I2) return 1;
        else return 0;
    }
}
