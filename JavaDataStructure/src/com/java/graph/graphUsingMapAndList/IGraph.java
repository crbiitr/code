package com.java.graph.graphUsingMapAndList;

import java.util.*;
/**
 * Created by chetan on 24/2/17.
 */

public interface IGraph<V> {
    public void addVertex(V v);

    public void addEdge(V v1, V v2, int weight);

    public boolean hasEdge(V v1, V v2);

    public Edge<V> getEdge(V v1, V v2);

    public boolean hasPath(V v1, V v2);

    public List<V> getDFSPath(V v1, V v2);

    public void DFSTraversal(V v);

    public void BFSTraversal(V v);

    public void topologicalSort(V v);

    public String toString();
}
