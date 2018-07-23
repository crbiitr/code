package com.java.graph.graphUsingHashmap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * New implementation of graph Using HashMap.
 * */

public class Graph<T> {
    public Map<T, List<T>> graph;
    public Map<T, Boolean> visited;
    public Map<T, Integer> inDegree;

    public Graph() {
        graph = new HashMap();
        visited = new HashMap();
        inDegree = new HashMap();
    }

    //Adding edge for undirected graph
    public void addEdge(T source, T dest) {
        if (!graph.containsKey(source)) {
            List<T> list = new LinkedList<T>();
            graph.put(source, list);
            visited.put(source, false);
        }
        if (!graph.containsKey(dest)) {
            List<T> list = new LinkedList<T>();
            graph.put(dest, list);
            visited.put(dest, false);
        }

        List<T> l = graph.get(source);
        l.add(dest);
        l = graph.get(dest);
        l.add(source);
    }

    //Adding direct edge graph
    public void addDirectEdge(T source, T dest) {
        if (!graph.containsKey(source)) {
            List<T> list = new LinkedList<T>();
            graph.put(source, list);
            visited.put(source, false);
        }
        if (!graph.containsKey(dest)) {
            List<T> list = new LinkedList<T>();
            graph.put(dest, list);
            visited.put(dest, false);
        }

        List<T> l = graph.get(source);
        l.add(dest);
        int inDegreeCount = inDegree.get(dest) != null ? inDegree.get(dest) : 0;
        inDegree.put(dest, (inDegreeCount + 1));
    }

    public void traverse() {
        for (T i : graph.keySet()) {
            System.out.print(i + " -> ");
            int count = 0;
            int size = graph.get(i).size();
            for (T l : graph.get(i)) {
                count++;
                if (size >= count) {
                    System.out.print(l + " -> ");
                }

            }
            System.out.println();
        }
    }

    public Map transposeGraph() {
        Map<T, List<T>> transposeMap = new HashMap();
        for (T i : graph.keySet()) {
            for (T l : graph.get(i)) {
                if (!transposeMap.containsKey(l)) {
                    List<T> list = new LinkedList<T>();
                    transposeMap.put(l, list);
                    visited.put(l, false);
                }
                if (!transposeMap.containsKey(i)) {
                    List<T> list = new LinkedList<T>();
                    transposeMap.put(i, list);
                    visited.put(i, false);
                }

                List<T> list = transposeMap.get(l);
                list.add(i);
            }
        }
        return transposeMap;
    }

    public static void main(String[] args) {
        Graph<Integer> g = new Graph();
        g.addEdge(1, 5);
        g.addEdge(2, 5);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(3, 1);
        g.traverse();
    }
}
