package com.java.arrayQuestion;

import javafx.util.Pair;

import java.util.*;

/*
* Its not working, Please check it, I think wrong solution in geeksforgeeks site
*/

public class MinSwaps {

    public static void main(String[] args) {
        int[] array = {4, 3, 2, 1};
//        int[] array = {1, 5, 4, 3, 2};
        MinSwaps minSwaps = new MinSwaps();
        int minimumSwap = minSwaps.getMinSwapUtil(array);
        System.out.println("Minimum Swaps: " + minimumSwap);

    }

    public int getMinSwapUtil(int[] arr) {
        int result = 0;
        int n = arr.length;

        ArrayList<Pair<Integer, Integer>> arrayPositionList = new ArrayList<Pair<Integer, Integer>>();
        for (int i = 0; i < n; i++) {
            arrayPositionList.add(new Pair<Integer, Integer>(arr[i], i));
        }

        arrayPositionList.sort(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                if (p1.getKey() > p2.getKey()) return -1;
                else if (p2.getKey().equals(p1.getKey())) return 0;
                else return 1;
            }
        });

        boolean visited[] = new boolean[n];
        Arrays.fill(visited, false);


        for (int i = 0; i < n; i++) {

            if (visited[i] || arrayPositionList.get(i).getValue() == i) {
                continue;
            }

            int countCycle = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = arrayPositionList.get(j).getValue();
                countCycle++;
            }
            result += (countCycle - 1);
        }

        return result;
    }
}
