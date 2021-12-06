package com.java.graph.competitiveProblems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/expl|xi - xj| + |yi - yj|ore/learn/card/graph/621/algorithms-to-construct-minimum-spanning-tree/3857/
//|xi - xj| + |yi - yj|
public class MinCostToConnectAllPoints {
    public static void main(String[] args) {
//        int[][] points =  {{3,12},{-2,5},{-4,1}};
        //int[][] points =  {{0,0},{1,1},{1,0},{-1,1}};
        int[][] points =  {{0,0}};

        MinCostToConnectAllPoints minCostToConnectAllPoints = new MinCostToConnectAllPoints();
        int totalDistance = minCostToConnectAllPoints.minCostConnectPoints(points);
        System.out.println("Total Distance :: " + totalDistance);

    }

    public int minCostConnectPoints(int[][] points) {
        if(points.length<=1) return 0; // Important for single point
        int result = 0;
        int n = points.length;
        Graph graph = new Graph(n);
        graph.generateAGraph(points);

        // Create Priority Queue and Fill with edges
        // Create a set
        // Union operation for n-1 edges

/*
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge edge, Edge edge2) {
                return edge.weight> edge.weight?1:0;
            }
        });
*/

        PriorityQueue<Edge> pq = new PriorityQueue<>(graph.listOfEdges.size(), Comparator.comparingInt(o -> o.weight));


        for (int i = 0; i < graph.listOfEdges.size(); i++) {
            pq.add(graph.listOfEdges.get(i));
        }

        int parent[] = new int[n];
        makeSet(parent);

        int index = 0;
        while (index < n-1) {  // Important note: loop should run only n-2 times
            Edge edge = pq.remove();
            int xSet = find(parent,edge.source);
            int ySet = find(parent,edge.destination);

            if(xSet == ySet) {
                // Ignore, will create cycle
            } else {
                result+=edge.weight;
                index++;
                union(parent,xSet,ySet);
            }
        }
        return result;
    }

    private void makeSet(int[] parent) {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    public int find(int[] parent, int vertex) {
        if(parent[vertex] != vertex)
            return find(parent,parent[vertex]);
        return vertex;
    }

    public void union(int[] parent, int x,int y) {
        int xSetParent = find(parent,x);
        int ySetParent = find(parent,y);

        parent[ySetParent] = xSetParent;
    }

    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph {
        int totalVertices;
        ArrayList<Edge> listOfEdges;// = new ArrayList<>();

        public Graph(int totalVertices) {
            this.totalVertices = totalVertices;
            listOfEdges = new ArrayList<>();
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
                for (int j = i+1; j < points.length; j++) {
                    int distance = getDistance(points[i][0],points[j][0],points[i][1],points[j][1]);
                    addEdge(i,j,distance);
                }
            }
        }
    }


}
