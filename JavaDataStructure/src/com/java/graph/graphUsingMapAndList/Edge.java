package com.java.graph.graphUsingMapAndList;

/**
 * Created by chetan on 24/2/17.
 */
public class Edge<V> {
    public V from, to;
    public int weight;

    public Edge(V from, V to, int weight) {
        if (from == null || to == null) {
            throw new IllegalArgumentException("null");
        }
        this.from = from;
        this.to = to;
        this.weight = weight;
    }


    public String toString() {
        return "<" + from + ", " + to + ", " + weight + ">";
    }
}
