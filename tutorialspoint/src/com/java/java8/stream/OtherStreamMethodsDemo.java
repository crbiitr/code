package com.java.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @author Chetan Raj Bharti
 *
 * @implNote
 * min(): To get the min element from the stream iff Stream is sorted
 * max(): To get the max element from the stream iff Stream is sorted
 * forEach(): Present inside stream
 * toArray(): To copy elements present in the Stream into specified array
 */
public class OtherStreamMethodsDemo {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(10);
        list.add(20);
        list.add(100);
        list.add(50);

        //Get Min element from the stream IFF list stream is sorted
        int min = list.stream().min((i1,i2)->i1.compareTo(i2)).get();
        System.out.println("\nMin Element in the list is: " + min);

        //Get Max element from the stream IFF list stream is sorted
        int max = list.stream().max((i1,i2)->i1.compareTo(i2)).get();
        System.out.println("Max Element in the list is: " + max);

        //ForEach() use
        System.out.println("Printing using forEach Method of Stream: ");
        list.stream().forEach(s-> System.out.println(s));
        System.out.println("Printing using forEach Method and method reference of Stream: ");
        list.stream().forEach(System.out::println);

        //toArray() Stream method, creating new array from list
        System.out.println("Use of toArray(): ");
        Integer[] array = list.stream().toArray(Integer[]::new);
        for (int i: array) System.out.println(i);
    }
}
