package com.java.java8.predicates;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class PredicatesDemo1 {
    public static void main(String[] args) {
        //Checking number is greater than 10 or not using predefined functional interface
        Predicate<Integer> P = I->I>10;
        System.out.println("Is 100 greater than 10 --->> " + P.test(100));
        System.out.println("Is 1 greater than 10 --->> " + P.test(1));

        //Checking String length is greater than 5 or not using predefined functional interface
        Predicate<String> P1 = s->s.length()>=5;
        System.out.println("\nIs abcdef length greater than 5 --->> " + P1.test("abcdef"));
        System.out.println("Is ab length greater than 5 --->> " + P1.test("ab"));

        //Checking giving collection is empty or not
        Predicate<Collection> predicate = c->c.isEmpty();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        System.out.println("\nIs collection empty --->> " + predicate.test(list));
        list.clear();
        System.out.println("Is collection empty --->> " + predicate.test(list));
    }
}
