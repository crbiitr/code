package com.java.testing.graphTestings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// 1) should be connected
// 2) should not be any cycle
public class GraphAValidTree {
    public static void main(String[] args) {
        //int[][] edges = {{0,1}, {0,2}, {0,3}, {1,4}};
        /*int[][] edges = {{0,1},{1,2},{2,3},{1,3},{1,4}};
        int n = 5;*/

        int[][] edges = {{0,1}};
        int n = 3;
        GraphAValidTree graphAValidTree = new GraphAValidTree();
        System.out.println(graphAValidTree.validTree(n, edges));
    }
    public boolean validTree(int n, int[][] edges) {
        if( (edges.length==0 && n>1)) return false;
        Graph graph = new Graph();
        for (int i = 0; i < edges.length; i++) {
            graph.setEdge(edges[i][0], edges[i][1]);
        }

        int count = 0;
        boolean visited[] = new boolean[n];
        Arrays.fill(visited, false);

        for (int i=0;i<n;i++) {
            if (visited[i] == false) {
                boolean isCycleFound = dfs(graph, visited, i, -1);
                if (isCycleFound) return false;
                count++;
            }
        }

        if (count > 1)
            return false;

        return true;
    }

    private boolean dfs(Graph graph, boolean[] visited, Integer key, int parent) {
        visited[key] = true;
        ArrayList<Integer> list = graph.g.get(key);
        if(list!=null) {
            for (int adjNode : list) {
                if (visited[adjNode] == false) {
                    if (dfs(graph, visited, adjNode, key)) {
                        return true;
                    }
                } else {
                    if (adjNode != parent) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    // Undirected graph
    class Graph {
        HashMap<Integer, ArrayList<Integer>> g;
        public Graph() {
            g = new HashMap<Integer, ArrayList<Integer>>();
        }

        public void setEdge(int i, int j) {
            if (g.get(i) != null) {
                ArrayList<Integer> edjList = g.get(i);
                edjList.add(j);
                g.put(i, edjList);
            } else {
                ArrayList<Integer> edjList = new ArrayList<>();
                edjList.add(j);
                g.put(i, edjList);
            }

            if (g.get(j) != null) {
                ArrayList<Integer> edjList = g.get(j);
                edjList.add(i);
                g.put(j, edjList);
            } else {
                ArrayList<Integer> edjList = new ArrayList<>();
                edjList.add(i);
                g.put(j, edjList);
            }
        }

    }
}
