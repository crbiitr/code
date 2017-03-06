package com.java.graph.graphUsingMapAndList;

/**
 * Created by chetan on 24/2/17.
 * https://courses.cs.washington.edu/courses/cse373/11wi/lectures/02-25/programs/
 */
public class GraphTest {
    public static void main(String[] args) {
        IGraph<String> airlineGraph = new Graph<String>();

        buildGraph(airlineGraph);
        System.out.println(airlineGraph);

        testEdges(airlineGraph);
        System.out.println();

        testDFS(airlineGraph);

        testDFSTraversal(airlineGraph);

        testBFS(airlineGraph);

        testTopological(airlineGraph);
    }

    public static void testEdges(IGraph<String> g) {
        System.out.println("\n\n");
        System.out.println("Edge between JFK and SFO? " + g.hasEdge("JFK", "SFO"));
        System.out.println("Edge between JFK and SFO: " + g.getEdge("JFK", "SFO"));

        System.out.println("Edge between MIA and LAX? " + g.hasEdge("MIA", "LAX"));
        System.out.println("Edge between MIA and LAX: " + g.getEdge("MIA", "LAX"));

        System.out.println("Edge between MIA and ORD? " + g.hasEdge("MIA", "ORD"));
        System.out.println("Edge between MIA and ORD: " + g.getEdge("MIA", "ORD"));

        System.out.println("Edge between SFO and DFW? " + g.hasEdge("SFO", "DFW"));
        System.out.println("Edge between SFO and DFW: " + g.getEdge("SFO", "DFW"));
    }

    public static void testDFS(IGraph<String> g) {
        System.out.println("\n\n");
        System.out.println("Path between BOS and LAX? " + g.hasPath("BOS", "LAX"));
        System.out.println("Edge between BOS and LAX: " + g.getDFSPath("BOS", "LAX"));

        System.out.println("Path between ORD and LAX? " + g.hasPath("ORD", "LAX"));
        System.out.println("Edge between ORD and LAX: " + g.getDFSPath("ORD", "LAX"));

        System.out.println("Path between SFO and LAX? " + g.hasPath("SFO", "LAX"));
        System.out.println("Edge between SFO and LAX: " + g.getDFSPath("SFO", "LAX"));
    }

    public static void testDFSTraversal(IGraph<String> g) {
        System.out.println("\n\nDFS Traversal:");
        g.DFSTraversal("LAX");
    }

    public static void testBFS(IGraph<String> g) {
        System.out.println("\n\nBFS Traversal:");
        g.BFSTraversal("LAX");
    }

    public static void testTopological(IGraph<String> g) {
        System.out.println("\n\nTopological test:");
        g.topologicalSort("LAX");
    }

    public static void buildGraph(IGraph<String> g) {
        g.addVertex("LAX");
        g.addVertex("SFO");
        g.addVertex("DFW");
        g.addVertex("ORD");
        g.addVertex("MIA");
        g.addVertex("JFK");
        g.addVertex("BOS");

        g.addEdge("LAX", "ORD", 1500);
        g.addEdge("DFW", "LAX", 800);
        g.addEdge("DFW", "ORD", 600);
        g.addEdge("DFW", "SFO", 1100);
        g.addEdge("DFW", "JFK", 950);
        // g.addEdge("ORD", "DFW", 600); // Remove comment if you want cycle in the graph
        // g.addEdge("MIA", "DFW", 1200); // Remove comment if you want cycle in the graph
        // g.addEdge("MIA", "LAX", 2800); // Remove comment if you want cycle in the graph
        g.addEdge("JFK", "MIA", 1300);
        g.addEdge("JFK", "SFO", 3600);
        g.addEdge("JFK", "BOS", 300);
        g.addEdge("BOS", "JFK", 300);
        g.addEdge("BOS", "MIA", 1500);
    }
}

