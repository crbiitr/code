package com.java.algorithims.Arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by B0204104 on 19/11/18.
 */
public class Memorise_Me {

    public static final String NOT_PRESENT = "NOT PRESENT";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int length = scanner.nextInt();
        while (length > 0) {
            int num = scanner.nextInt();
            if (map.get(num) == null) {
                map.put(num, 1);
            } else {
                map.put(num, (map.get(num) + 1));
            }
            length--;
        }

        int size = scanner.nextInt();
        while (size>0) {
            int num = scanner.nextInt();
            if (map.get(num) == null) {
                System.out.println(NOT_PRESENT);
            } else {
                System.out.println(map.get(num));
            }
            size--;
        }
    }
}
