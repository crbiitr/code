package com.java.matrix;

import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

public class KthSmallestElementInSortedMatrix {
    public static void main(String[] args) {
        // [[1,5,9],[10,11,13],[12,13,15]]
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        System.out.println(kthSmallest(matrix,8));
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        // Default is min queue
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        for (int j = 0; j < n; j++) {
            pq.offer(new Tuple(0,j,matrix[0][j]));
        }

        for (int i = 0; i < k-1; i++) {
            Tuple tuple = pq.poll();
            if(tuple.x == n-1) continue;
            pq.offer(new Tuple(tuple.x+1, tuple.y,matrix[tuple.x+1][tuple.y]));
        }
        return pq.poll().val;
    }
}

class Tuple implements Comparable<Tuple> {
    int x, y, val;
    public Tuple (int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    @Override
    public int compareTo (Tuple that) {
        return this.val - that.val;
    }
}
