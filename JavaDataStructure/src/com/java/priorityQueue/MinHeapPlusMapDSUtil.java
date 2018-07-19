package com.java.priorityQueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Chetan
 * <p>
 * Data structure to support following operations
 * extracMin - O(logn)
 * addToHeap - O(logn)
 * decreaseKey - O(logn)
 * containsKey - O(1)
 * getKeyWeight - O(1)
 * <p>
 * It is a combination of binary heap and hash map, which can be used in Grahp algos
 * TODO: still pending for code completion from my side
 */
public class MinHeapPlusMapDSUtil<T> {
    private Map<T, Integer> nodePositionMap = new HashMap<>();
    private List<Node> allNode = new ArrayList<>();


    public class Node {
        int weight;
        T key;
    }

    public boolean containsData(T key) {
        return nodePositionMap.containsKey(key);
    }

    public T getMin() {
        return allNode.get(0).key;
    }

    public boolean isHeapEmpty() {
        return allNode.size() == 0;
    }

    public void printHeap(List<Node> allNode) {
        for (Node n : allNode) {
            System.out.println(n.weight + " " + n.key);
        }
    }

    public void add(T key, int weight) {
        Node node = new Node();
        node.weight = weight;
        node.key = key;

        allNode.add(node);
        int size = allNode.size();
        int current = size - 1;
        int parentIndex = (current - 1) / 2;
        nodePositionMap.put(key, current);

        if (parentIndex >= 0) {
            Node parentNode = allNode.get(parentIndex);
            Node currentNode = allNode.get(current);

            if (parentNode.weight > currentNode.weight) {
                swap(parentNode, currentNode);
                updatePositionMap(parentNode.key, currentNode.key, parentIndex, current);
                current = parentIndex;
                parentIndex = (parentIndex - 1) / 2;
            } else {
               //TODO: still pending
            }
        }
    }

    public void updatePositionMap(T parent, T current, int parentIndex, int currentIndex) {
        nodePositionMap.remove(parent);
        nodePositionMap.remove(current);

        nodePositionMap.put(parent, parentIndex);
        nodePositionMap.put(current, currentIndex);
    }

    public void swap(Node node1, Node node2) {
        Node temp = new Node();
        temp.key = node1.key;
        temp.weight = node1.weight;

        node1.key = node2.key;
        node1.weight = node2.weight;

        node2.key = temp.key;
        node2.weight = temp.weight;
    }


}
