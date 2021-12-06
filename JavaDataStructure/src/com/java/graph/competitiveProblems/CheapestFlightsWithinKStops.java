package com.java.graph.competitiveProblems;

import com.java.graph.sotestPath.BellmanFordAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;

// https://leetcode.com/problems/cheapest-flights-within-k-stops/solution/
public class CheapestFlightsWithinKStops {

    public static void main(String[] args) {
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int src = 0, dst = 2, k = 0;

        CheapestFlightsWithinKStops cheapestFlightsWithinKStops = new CheapestFlightsWithinKStops();

        System.out.println(cheapestFlightsWithinKStops.findCheapestPrice(3, flights, 0, 2, 0));
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int cheapestPrice = 0;
        Graph graph = new Graph(n);
        graph.generateAGraph(flights);

        int count = 0, v = src, sum = 0;

        cheapestPrice = sps(graph, flights, src, dst, k, sum, count, v);

        return cheapestPrice;
    }

    private int sps(Graph graph, int[][] flights, int src, int dst, int k, int sum, int count, int v) {
        if (v == dst) {
            if (count == k) {
                return sum;
            } else
                return -1;
        }

        if(count>0 && v==src) return -1;

        for (Edge edge : graph.graph.get(v)) {
            return sps(graph, flights, src, dst, k, sum + edge.cost, count + 1, edge.point1);
        }
        return -1;
    }

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
        int totalVertices;
        ArrayList<Edge> listOfEdges;// = new ArrayList<>();
        HashMap<Integer, ArrayList<Edge>> graph;

        public Graph(int totalVertices) {
            this.totalVertices = totalVertices;
            listOfEdges = new ArrayList<>();
            graph = new HashMap<>();
        }

        public void addEdge(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            listOfEdges.add(edge);
        }

        public int getDistance(int x1, int x2, int y1, int y2) {
            return Math.abs(x1 - x2) + Math.abs(y1 - y2);
        }

        public void generateAGraph(int[][] points) {
            for (int i = 0; i < points.length; i++) {
                int source = points[i][0];
                int destination = points[i][1];
                int weight = points[i][2];

                Edge edge = new Edge(source, destination, weight);
                listOfEdges.add(edge);

                if (graph.containsKey(source)) {
                    graph.get(source).add(edge);
                } else {
                    ArrayList<Edge> listOfEdges = new ArrayList<>();
                    listOfEdges.add(edge);
                    graph.put(source, listOfEdges);
                }
            }
        }
    }
}
