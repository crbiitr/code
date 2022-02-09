package com.java.graph.shortestPath;

import com.java.graph.topologicalSort.KahnAlgo;

import java.util.*;

// Priority Queue Solution
// https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-in-java-using-priorityqueue/
public class DijkstraAlgo {
    int distance[];
    Set<Integer> visited;
    PriorityQueue<Edge> pq;

    public static void main(String[] args) {
        Graph graph = new Graph(6, 0);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 4, 15);
        graph.addEdge(1, 2, 15);
        graph.addEdge(1, 5, 12);
        graph.addEdge(2, 3, 5);
        graph.addEdge(4, 3, 10);
        graph.addEdge(5, 2, 1);
        graph.addEdge(5, 3, 2);

        DijkstraAlgo dijkstraAlgo = new DijkstraAlgo();
        dijkstraAlgo.dijkstra(graph, 0);
        dijkstraAlgo.printArr(dijkstraAlgo.distance, 6);
    }

    public void dijkstra(Graph graph, int source) {
        distance = new int[graph.V];
        visited = new HashSet<>();
        pq = new PriorityQueue<>(graph.V, Comparator.comparingInt(o -> o.weight));

        for (int i = 0; i < graph.V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        distance[source] = 0;
        pq.offer(new Edge(graph.graph.get(source).get(0).source,graph.graph.get(source).get(0).weight));


        while (visited.size() < graph.V) {
            if (pq.isEmpty())
                return;

            Edge edge = pq.remove();

            if (visited.contains(edge.source))
                continue;

            visited.add(edge.source);

            // now run for its all neighbours
            executeAllItsNeighbours(graph, edge);

        }

    }

    private void executeAllItsNeighbours(Graph graph, Edge edge) {
        ArrayList<Edge> edgeArrayList = graph.graph.get(edge.source);

        for (Edge connectedEdge : edgeArrayList) {
            if (!visited.contains(connectedEdge.destination)) {
                int tempDistance = distance[edge.source] + connectedEdge.weight;

                if (tempDistance < distance[connectedEdge.destination]) {
                    distance[connectedEdge.destination] = tempDistance;
                }

                if (graph.graph.get(connectedEdge.destination) != null) {
                    pq.offer(new Edge(connectedEdge.destination,distance[connectedEdge.destination]));
                }
            }
        }
    }

    // A utility function used to print the solution
    void printArr(int dist[], int V) {
        System.out.println("Vertex Distance from Source");
        System.out.println("Vertex" + "\t" + "Distance");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
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

            E++;
        }
    }


}
