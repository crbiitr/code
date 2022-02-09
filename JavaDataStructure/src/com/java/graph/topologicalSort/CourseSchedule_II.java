package com.java.graph.topologicalSort;

import java.util.*;

// https://leetcode.com/explore/learn/card/graph/623/kahns-algorithm-for-topological-sorting/3868/
public class CourseSchedule_II {
    public static void main(String[] args) {
        Graph graph = new Graph(4,0);
        CourseSchedule_II courseSchedule_ii = new CourseSchedule_II();

        /*int[][] pre = {{1,0},{2,0},{3,1},{3,2}}; int numCourses = 4;
        courseSchedule_ii.findOrder(numCourses,pre);
*/
        /*int[][] pre = {{1,0}}; int numCourses = 2;
        courseSchedule_ii.findOrder(numCourses,pre);*/

        /*int[][] pre = {}; int numCourses = 1;
        courseSchedule_ii.findOrder(numCourses,pre);*/

        int[][] pre = {{1,0}}; int numCourses = 3;
        courseSchedule_ii.findOrder(numCourses,pre);

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

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];

        if(prerequisites!=null && prerequisites.length==0) {
            for(int i=0;i<numCourses;i++) {
                result[i] = numCourses-i-1;
            }
            return result;
        }

        Graph graph = generateGraph(numCourses,prerequisites);

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
        int resultIndex = 0;
        while (!queue.isEmpty()) {
            int node = queue.remove();

            ArrayList<Edge> edges = graph.graph.get(node);
            result[resultIndex++]=node;
            for (Edge edge: edges) {
                indegree[edge.destination] -= 1;

                if(indegree[edge.destination]==0) {
                    queue.add(edge.destination);
                }
            }
            count++;
        }

        if (count != graph.V) {
            return new int[]{};
        }
        System.out.println("Result: ");
        for (int i:result) {
            System.out.print(i + "  ");
        }

        return result;

    }

    private Graph generateGraph(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph(numCourses,0);
        for (int[]array: prerequisites) {
            graph.addEdge(array[1],array[0],0);
        }
        return graph;
    }
}
