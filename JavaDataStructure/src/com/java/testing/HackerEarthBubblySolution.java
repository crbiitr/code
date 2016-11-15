package com.java.testing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by user on 10/30/16.
 */
public class HackerEarthBubblySolution {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        int count = 0;
        for (int i = 0; i < N; i++) {
            String nextLine = br.readLine();
            char[] array = nextLine.toCharArray();

            if (isBubbly(array)) {
                count++;
            }
        }

        /*
        char[] arr = {'a','b','a','b'};

        if (isBubbly(arr)) {
            System.out.println("Bubbly");
        } else {
            System.out.println("Not Bubbly");
        }*/
        System.out.println(count);
    }

    public static boolean isBubbly(char[] array) {
    boolean bubbly = false;
    int length = array.length;
    if (length%2 == 1) {
        bubbly = false;
    } else {
        Stack<Character> s = new Stack<Character>();
        int i = 0;
        while(i < length) {
            if (s.isEmpty()) {
                s.push(array[i]);
            } else {
                if (array[i] == s.peek()) {
                    s.pop();
                } else  {
                    s.push(array[i]);
                }
            }
            i++;
        }
        if (s.isEmpty()) {
            bubbly = true;
        }
    }
    return bubbly;
}

}
