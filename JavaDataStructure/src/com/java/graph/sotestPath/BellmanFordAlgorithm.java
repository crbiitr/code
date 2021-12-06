package com.java.graph.sotestPath;

import java.util.ArrayList;
import java.util.HashMap;

// https://www.geeksforgeeks.org/bellman-ford-algorithm-dp-23/
public class BellmanFordAlgorithm {
    static class Edge {
        int point1;
        int point2;
        int cost;

        Edge(int point1, int point2, int cost) {
            this.point1 = point1;
            this.point2 = point2;
            this.cost = cost;
        }
    }

    static class Graph {
        private int V, E; // Number of vertexes and Edges
        private HashMap<Integer,ArrayList<Edge>> graph;

        public Graph(int v, int e) {
            V = v;
            E = e;
            graph = new HashMap<>();
        }

        public void addEdge(int source, int destination, int weight) {
            Edge edge = new Edge(source,destination,weight);
            if(graph.containsKey(source)) {
                graph.get(source).add(edge);
            } else {
                ArrayList<Edge> listOfEdges = new ArrayList<>();
                listOfEdges.add(edge);
                graph.put(source,listOfEdges);
            }
            E++;
        }
    }

    public void bellmanFordAlgo(Graph graph, int src) {
        int distance[] = new int[graph.V];
        int parents[] = new int[graph.V];

        for (int i = 0; i < graph.V; i++) {
            distance[i] = Integer.MAX_VALUE;
            parents[i] = i;
        }

        distance[src] = 0;
        for (int i = 0; i < graph.V; i++) {
            ArrayList<Edge> edges = graph.graph.get(i);
            for (int j = 0; edges!=null && j < edges.size(); j++) {
                Edge edge = edges.get(j);
                if(distance[edge.point1] + edge.cost< distance[edge.point2]) {
                    distance[edge.point2] = distance[edge.point1] + edge.cost;
                    parents[edge.point2] = edge.point1;
                }
            }

        }

        for (int i = 0; i < graph.V; i++) {
            ArrayList<Edge> edges = graph.graph.get(i);
            for (int j = 0; edges!=null &&  j < edges.size(); j++) {
                Edge edge = edges.get(j);
                if(distance[edge.point1] + edge.cost< distance[edge.point2]) {
                    System.out.println("Graph contains negative weight cycle");
                    return;
                }
            }

        }

        // Print distance
        printArr(distance, graph.V);

        //Print parents
        printArr(parents,graph.V);

    }

    // A utility function used to print the solution
    void printArr(int dist[], int V)
    {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5,0);
        graph.addEdge(0,1,-1);
        graph.addEdge(0,2,2);
        graph.addEdge(1,2,9);
        graph.addEdge(1,3,8);
        graph.addEdge(2,4,4);
        graph.addEdge(3,4,-2);

        BellmanFordAlgorithm bellmanFordAlgorithm = new BellmanFordAlgorithm();
        bellmanFordAlgorithm.bellmanFordAlgo(graph,0);

    }


}
