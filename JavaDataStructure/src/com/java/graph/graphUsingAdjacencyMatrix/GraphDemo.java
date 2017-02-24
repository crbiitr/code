package com.java.graph.graphUsingAdjacencyMatrix;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphDemo {

	/**
	 * This class is creating a graph and using 
	 * utility function of GraphADT
	 * @param args
	 */
	public static void main(String[] args) {
		GraphADT g = new GraphADT();
		
		// Adding Vertexes in the graph
		g.addVertex('A'); // Vertex[0] = 'A';
		g.addVertex('B'); // Vertex[1] = 'B';
		g.addVertex('C'); // Vertex[2] = 'C';
		g.addVertex('D'); // Vertex[3] = 'D';
		g.addVertex('E'); // Vertex[4] = 'E';
		g.addVertex('F'); // Vertex[5] = 'F';
		g.addVertex('G'); // Vertex[6] = 'G';
		g.addVertex('H'); // Vertex[7] = 'H';
		
		// Connecting Vertexes, using Edges
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 7);
		g.addEdge(2, 3);
		g.addEdge(2, 4);
		g.addEdge(4, 5);
		g.addEdge(4, 6);
		g.addEdge(4, 7);
		
		System.out.println("\n\nDepth First Search: \n");
		Stack<Integer> S = new Stack<Integer>();
		g.dfs(S);
		System.out.println("\n\nBreath First Search: \n");
		Queue<Integer> Q = new LinkedList<Integer>();
		g.bfs(Q);
		
		// Printing Indegree Array
		int indegreeArray[] = g.getIndegreeArray();
		g.printArray(indegreeArray);

	}

}
