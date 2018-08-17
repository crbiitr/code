package com.java.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Chetan Raj Bharti
 * Filter: Stream.filter takes Predicates Interface
 * Map: Stream.Map takes on Function Interface
 */
public class StreamFilterAndMapDemo1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Chetan");
        list.add("HemanRajBharti");
        list.add("Deepak");
        list.add("KeshavRaj");
        list.add("Chaman");

        System.out.println("List: " + list);

        //Filter using stream
        List<String> filteredList = list.stream().filter(s1 -> s1.length() >= 9).collect(Collectors.toList());
        System.out.println("\nFiltered List: " + filteredList);

        //Converting to upper case using map of Stream Interface
        List<String> upperList = list.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
        System.out.println("\nUpper List: " + upperList);

        //Count method using Filter of Stream
        long count = list.stream().filter(s1 -> s1.length() >= 9).count();
        System.out.println("\nCount of length greater than 9 length: " + count);
    }
}
