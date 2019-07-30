package com.java.arrayQuestion.gfgPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Chetan Raj
 * @implNote: I created my solution using Scanner but it is giving Time exceeded issue.
 * I took help from here "https://ide.geeksforgeeks.org/f4gdIxBefp".
 * And found that I should use "BufferedReader".
 * Earlier, I used Stack and got time issue. Than i used list but again got time issue. Than i used bufferedReader but again timeout issue.
 * Findings: 1) Scanner is giving timeout issue.
 *           2) Printing list and stack using for loop is giving issue. So used StringBuilder.
 *
 * NOTE: (Sometime)While breaking into functions than giving timeout issue on GFG.
 * NOTE: Read it "https://www.geeksforgeeks.org/how-to-get-rid-of-java-tle-problem/"
 * @since : 2019-07-19
 */
class LeadersInArray {
    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int arraySize = scanner.nextInt();
            int a[] = new int[arraySize];
            for (int j = 0; j < arraySize; j++) {
                a[j] = scanner.nextInt();
            }
            findLeaders(a);
        }
    }*/

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        for (int i = 1; i <= testCases; i++) {
            int size = Integer.parseInt(br.readLine());
            int a[] = new int[size];
            String line = br.readLine();
            String strs[] = line.trim().split("\\s+");

            // array elements input
            for (int j = 0; j < strs.length; j++) {
                a[j] = Integer.parseInt(strs[j]);
            }

            int max = a[a.length - 1];
            List<Integer> list = new ArrayList<>();
            list.add(max);
            for (int k = a.length - 2; k >= 0; k--) {
                if (a[k] >= max) {
                    max = a[k];
                    list.add(max);
                }
            }

            printList(list);
            // findLeaders(a); //Giving timeout issue
        }
    }

    private static void findLeaders(int[] a) {
        int max = a[a.length - 1];
        List<Integer> list = new ArrayList<>();
        list.add(max);
        for (int i = a.length - 2; i >= 0; i--) {
            if (a[i] >= max) {
                max = a[i];
                list.add(max);
            }
        }
        printList(list);
    }

    /**
     * Its working very fast.
     * @param list
     */
    private static void printList(List<Integer> list) {
        /*StringBuilder sb = new StringBuilder();
        for (int j = list.size() - 1; j >= 0; j--) {
            sb.append(list.get(j));
            sb.append(' ');
        }
        System.out.print(sb);
        System.out.println();*/

        list.stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        lst -> {
                            Collections.reverse(lst);
                            return lst.stream();
                        }
                ))
                .forEach(i-> System.out.print(i + " "));
        System.out.println();
    }

    /**
     * VIMP: This function gives timeout issue while above function doesn't give any issue.
     *       Use the above function
     * @param list
     */
    private static void printListSlowFunction(List<Integer> list) {
        int size = list.size();
        while (size > 0) {
            System.out.print(list.get(size-1) + " ");
            size--;
        }
        System.out.println();


        // Its not working bcz of "collections.reverse()" taking time.
        /*list.stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        lst -> {
                            Collections.reverse(lst);
                            return lst.stream();
                        }
                ))
                .forEach(i-> System.out.print(i + " "));
        System.out.println();*/
    }

    /**
     * This if from GFG.
     * "https://ide.geeksforgeeks.org/f4gdIxBefp"
     * @param args
     * @throws IOException
     */
    public static void mainGfg(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int size = Integer.parseInt(br.readLine());
            int[] a = new int[size];
            StringBuilder sb = new StringBuilder();

            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");

            // array elements input
            for (int j = 0; j < strs.length; j++)
                a[j] = Integer.parseInt(strs[j]);

            //Stack<Integer> stack = new Stack<>();
            int max = a[a.length - 1];
            List<Integer> list = new ArrayList<>();
            list.add(max);
            //stack.push(max);
            for (int k = a.length - 2; k >= 0; k--) {
                if (a[k] >= max) {
                    max = a[k];
                    list.add(max);
//                stack.push(max);
                }
            }
            //printStack(stack);
            int lSize = list.size();
            while (lSize > 0) {
                System.out.print(list.get(lSize - 1) + " ");
                lSize--;
            }
            System.out.println();
            for(int j=list.size()-1;j>=0;j--)
            {
                sb.append(list.get(j));
                sb.append(' ');
            }
            System.out.print(sb);
            System.out.println();
        }
    }


}
