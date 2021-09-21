package com.java.testing;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = new int [] {1,3,-1,-3,5,3,6,7};
        for (int value:maxSlidingWindow(nums, 3)) {
            System.out.print(value + " ");
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        int output[] = new int[length-k+1];
        int i = 0;
        int count = 0;
        int j = 0;
        Deque<Integer> q = new LinkedList<>();

        while (count<k) {
            count++;
            while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
                q.removeLast();
            }
            q.addLast(i++);
        }

        output[j] = nums[q.getFirst()];
        j++;

        while (i<length) {
            // remove invalid data
            while (!q.isEmpty() && q.getFirst()<=(i-k)) {
                q.removeFirst();
            }

            // remove smaller element
            while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
                q.removeLast();
            }

            // add new element
            q.addLast(i++);

            // add into output
            if(q.isEmpty()) {
                output[j] = -1;
            } else {
                output[j] = nums[q.getFirst()];
            }
            j++;

        }

     /*   // add into output
        if(q.isEmpty()) {
            output[j] = -1;
        } else {
            output[j] = nums[q.getFirst()];
        }
        j++;*/
        return output;
    }
}
