package com.java.graph.graphUsingHashmap;

import java.util.*;

/**
 * Date 23/07/2018
 *
 * @author Chetan Raj
 * Given a directed graph, find all strongly connected components in this graph.
 * We are going to use Kosaraju's algorithm to find strongly connected component.
 * <p>
 * Algorithm
 * Create a order of vertices by finish time in decreasing order.
 * Reverse the graph
 * Do a DFS on reverse graph by finish time of vertex and created strongly connected
 * components.
 * <p>
 * Runtime complexity - O(V + E)
 * Space complexity - O(V)
 * <p>
 * References
 * https://en.wikipedia.org/wiki/Strongly_connected_component
 * http://www.geeksforgeeks.org/strongly-connected-components/
 *
 * KOSARAJU's ALGO
 */

public class StronglyConnectedComponent {
    Deque<Integer> stack = new ArrayDeque<>();

    //For printing all the SCC's print the result list.
    List<Set<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<Integer>();
        graph.addDirectEdge(0, 2);
        graph.addDirectEdge(0, 3);
        graph.addDirectEdge(1, 0);
        graph.addDirectEdge(2, 1);
        graph.addDirectEdge(3, 4);

        graph.traverse();

        StronglyConnectedComponent SCC = new StronglyConnectedComponent();
        SCC.dfs(graph);
        graph.graph = graph.transposeGraph();
        int count = SCC.countSCC(graph);
        System.out.println("\nStrongly Connected Component Count: " + count);
    }

    public void dfs(Graph<Integer> graph) {
        for (Integer vertex : graph.graph.keySet()) {
            if (!graph.visited.get(vertex)) {
                dfsUtils(vertex, graph);
            }
        }
    }

    public void dfsUtils(Integer vertex, Graph<Integer> graph) {
        graph.visited.put(vertex, true);
        for (Integer adjacent : graph.graph.get(vertex)) {
            if (!graph.visited.get(adjacent))
                dfsUtils(adjacent, graph);
        }
        stack.offerFirst(vertex);
    }

    public int countSCC(Graph<Integer> graph) {
        int count = 0;
        while (!stack.isEmpty()) {
            int vertex = stack.poll();
            if (!graph.visited.get(vertex)) {
                Set<Integer> set = new HashSet<>();
                dfsUtilsForReverseGraph(vertex, graph, set);
                result.add(set);
            }
        }
        printResultSet(result);
        return result.size();
    }

    public void dfsUtilsForReverseGraph(Integer vertex, Graph<Integer> graph, Set<Integer> set) {
        graph.visited.put(vertex, true);
        set.add(vertex);
        for (Integer adjacent : graph.graph.get(vertex)) {
            if (!graph.visited.get(adjacent))
                dfsUtilsForReverseGraph(adjacent, graph, set);
        }
    }

    public void printResultSet(List<Set<Integer>> result) {
        System.out.println("\nStrongly Connected Components ::");
        for (Set<Integer> set: result) {
            set.stream().forEach(e-> System.out.print(e +" "));
            System.out.println();
        }
    }
}
