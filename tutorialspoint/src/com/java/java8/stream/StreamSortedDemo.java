package com.java.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Chetan Raj Bharti
 *
 * @implNote
 * sorted(): To sort element inside stream, default sorting order
 * sorted(Comparator c): To sort element inside stream, customize sorting order
 * min(): to get the min element from the stream iff Stream is sorted
 * max(): to get the max element from the stream iff Stream is sorted
 * forEach(): present inside stream
 */
public class StreamSortedDemo {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(10);
        list.add(20);
        list.add(100);
        list.add(50);

        System.out.println("List: " + list);
        List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());
        System.out.println("Default sorted list: " + sortedList);

        List<Integer> ascendingSortedList = list.stream().sorted((i1, i2) -> i1.compareTo(i2)).collect(Collectors.toList());
        System.out.println("Default sorted list using Comparator: " + ascendingSortedList);

        List<Integer> descendingSortedList = list.stream().sorted((i1, i2) -> -i1.compareTo(i2)).collect(Collectors.toList());
        System.out.println("List according to Customize sorting: " + descendingSortedList);

        //Get Min element from the stream IFF list stream is sorted
        int min = list.stream().min((i1,i2)->i1.compareTo(i2)).get();
        System.out.println("\nMin Element in the list is: " + min);

        //Get Max element from the stream IFF list stream is sorted
        int max = list.stream().max((i1,i2)->i1.compareTo(i2)).get();
        System.out.println("Max Element in the list is: " + max);

        //ForEach() use
        System.out.println();
        list.stream().forEach(s-> System.out.println(s));
        System.out.println();
        list.stream().forEach(System.out::println);
    }
}
