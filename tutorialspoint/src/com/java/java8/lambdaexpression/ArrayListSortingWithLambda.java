package com.java.java8.lambdaexpression;

import java.util.*;

public class ArrayListSortingWithLambda {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(10);
        arrayList.add(6);
        arrayList.add(17);
        arrayList.add(9);
        arrayList.add(1);
        arrayList.add(2);

        //Sorting using Lambda expression
        Collections.sort(arrayList, (I1, I2) -> I1 > I2 ? -1 : I1 < I2 ? 1 : 0);
        System.out.println("Print ARRAY LIST Using LAMBDA Expression: " + arrayList.toString());
        System.out.println();


        //TreeSet Sorting using Lambda Expression
        Set<Integer> set = new TreeSet<Integer>((I1, I2) -> I1 > I2 ? -1 : I1 < I2 ? 1 : 0);
        set.add(10);
        set.add(6);
        set.add(17);
        set.add(9);
        set.add(1);
        set.add(2);

        //Sorting using Lambda expression
        System.out.println("Print HASH SET Using LAMBDA Expression: " + set.toString());
        System.out.println();


        //TreeMap Sorting using Lambda Expression
        Map<Integer, String> map = new TreeMap<>((I1, I2) -> I1 > I2 ? -1 : I1 < I2 ? 1 : 0);
        set.add(10);
        set.add(6);
        set.add(17);
        set.add(9);
        set.add(1);
        set.add(2);

        //Sorting using Lambda expression
        System.out.println("Print TREE MAP Using LAMBDA Expression: " + set.toString());
    }
}
