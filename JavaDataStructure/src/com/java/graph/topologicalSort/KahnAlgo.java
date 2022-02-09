package com.java.graph.topologicalSort;

import java.util.*;

// https://www.geeksforgeeks.org/topological-sorting-indegree-based-solution/
// BFS + Queue, T: O(V+E)
public class KahnAlgo {
    public static void main(String[] args) {
        Graph graph = new Graph(6,0);
        graph.addEdge(5,0,0);
        graph.addEdge(5,3,0);
        graph.addEdge(3,0,0);
        graph.addEdge(3,2,0);
        graph.addEdge(4,0,0);
        graph.addEdge(4,1,0);
        graph.addEdge(2,1,0);

        graph.iterateGraph();
        KahnAlgo kahnAlgo = new KahnAlgo();
        kahnAlgo.kahnTopologicalSort(graph);
    }

    static class Edge {
        int source;
        int destination;
        int weight;

        Edge(int point1, int destination, int weight) {
            this.source = point1;
            this.destination = destination;
            this.weight = weight;
        }

        public Edge(int source, int weight) {
            this.source = source;
            this.weight = weight;
        }
    }

    static class Graph {
        private int V, E; // Number of vertexes and Edges
        private HashMap<Integer, ArrayList<Edge>> graph;

        public Graph(int v, int e) {
            V = v;
            E = e;
            graph = new HashMap<>();
            for (int i = 0; i < v; i++) {
                graph.put(i,new ArrayList<>());
            }
        }

        public void addEdge(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            if (graph.containsKey(source)) {
                graph.get(source).add(edge);
            } else {
                ArrayList<Edge> listOfEdges = new ArrayList<>();
                listOfEdges.add(edge);
                graph.put(source, listOfEdges);
            }

            if(!graph.containsKey(destination)) {
                ArrayList<Edge> listOfEdges = new ArrayList<>();
                graph.put(destination, listOfEdges);
            }
            E++;
        }

        public void iterateGraph() {
            for (int i: graph.keySet()) {
                ArrayList<Edge> edges = graph.get(i);
                System.out.print(i + ": ");
                for (Edge edge: edges) {
                    System.out.print(edge.destination + " -> ");
                }
                System.out.println();
            }
        }
    }

    public ArrayList<Integer> kahnTopologicalSort(Graph graph) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        // Calculate In-degree
        int[] indegree = new int[graph.V];
        Arrays.fill(indegree,0);

        Iterator<Integer> keysetIterator = graph.graph.keySet().iterator();
        while (keysetIterator.hasNext()) {
            Integer key = keysetIterator.next();

            ArrayList<Edge> edgeArrayList = graph.graph.get(key);
            for (Edge edge: edgeArrayList) {
                indegree[edge.destination] +=1;
            }
        }

        for (int i = 0; i < indegree.length; i++) {
            if(indegree[i]==0) {
                queue.add(i);
            }
        }

        int count =0;
        while (!queue.isEmpty()) {
            int node = queue.remove();

            ArrayList<Edge> edges = graph.graph.get(node);
            result.add(node);
            for (Edge edge: edges) {
                indegree[edge.destination] -= 1;

                if(indegree[edge.destination]==0) {
                    queue.add(edge.destination);
                }
            }
            count++;
        }

        if (count != graph.V) {
            System.out.println(count +" : "+ graph.V);
            System.out.println("There exists a cycle in the graph");
            return null;
        }

        System.out.println("Result: ");
        for (int i:result) {
            System.out.print(i + "  ");
        }
        return result;
    }

}
