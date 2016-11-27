package com.java.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
* New implementation of graph Using HashMap.
* */

 public class Graph<T> {
    Map<T, List<T>> graph;

    Graph(){
        graph = new HashMap();
    }

    public void addEdge(T source, T dest){
        if(!graph.containsKey(source)){
            List<T> list = new LinkedList<T>();
            graph.put(source, list);
        }
        if(!graph.containsKey(dest)){
            List<T> list = new LinkedList<T>();
            graph.put(dest, list);
        }

        List<T> l = graph.get(source);
        l.add(dest);
        l = graph.get(dest);
        l.add(source);
    }

    public void traverse(){
        for(T i : graph.keySet()){
            System.out.print(i + " -> ");
            for(T l : graph.get(i)){
                System.out.print(l + " -> ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Graph<Integer> g = new Graph();
        g.addEdge(1, 5);
        g.addEdge(2, 5);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(3, 1);
        g.traverse();
    }
}
