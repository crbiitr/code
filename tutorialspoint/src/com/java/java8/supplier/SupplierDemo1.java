package com.java.java8.supplier;

import java.util.Random;
import java.util.function.Supplier;

/**
 * @author Chetan Raj Bharti
 * @implNote Supplier interface provide get method which does not take any parameter and return T type
 */
public class SupplierDemo1 {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> {
            String[] array = {"Aman", "Ratan", "Chetan", "Chaman", "Goli"};
            Random random1 = new Random();
            int i = (random1.nextInt(10)%array.length);
            return array[i];
        };

        System.out.println(supplier.get());
        System.out.println(supplier.get());
        System.out.println(supplier.get());
        System.out.println(supplier.get());
        System.out.println(supplier.get());
    }
}
