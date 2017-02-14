package com.java.collectionsInJava.minPriorityQueue;

import java.util.PriorityQueue;

/**
 * Created by user on 11/28/16.
 */
public class MinHeapWithPriorityQueue {
    public static void main(String args[]) {
        // create priority queue
        PriorityQueue< Integer > prq = new PriorityQueue <Integer> ();

        // insert values in the queue
        prq.add(6);
        prq.add(9);
        prq.add(5);
        prq.add(64);
        prq.add(6);
        prq.add(1);


        System.out.println(prq.peek());
        System.out.println(prq.poll());

        //print values
        while (!prq.isEmpty()) {
            System.out.print(prq.poll()+" ");
        }
    }
}
