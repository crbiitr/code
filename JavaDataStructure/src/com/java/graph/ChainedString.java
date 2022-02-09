package com.java.graph;

import com.java.graph.graphUsingHashmap.EulerianCircuitDirectedGraph;
import com.java.graph.graphUsingHashmap.Graph;

/*
 * References:
 * https://www.geeksforgeeks.org/given-array-strings-find-strings-can-chained-form-circle/
 */
public class ChainedString {
    public static void main(String[] args) {
//        String[] str = {"for", "geek", "rig", "kaf"}; // true case
        String[] str = {"ijk", "kji", "abc", "cba"};  // false case

        ChainedString chainedString = new ChainedString();
        System.out.println("isCircularChained: " + chainedString.isCircularChainedString(str));
    }

    public boolean isCircularChainedString(String[] str) {
        Graph<String> graph = new Graph<String>();
        for (String string : str) {
            System.out.println(string.substring(0, 1) + " <-----> " + string.substring(string.length() - 1));
            graph.addDirectEdge(string.substring(0, 1), string.substring(string.length() - 1));
        }
        EulerianCircuitDirectedGraph eulerianCircuitDirectedGraph = new EulerianCircuitDirectedGraph();
        return eulerianCircuitDirectedGraph.isEulerianCycle(str[0].substring(0, 1), graph);
    }
}
