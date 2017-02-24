package com.java.graph.graphUsingAdjacencyMatrix;

/**
 * This Topological Sorting, For which we need DAG.
 * So in this class we are creating DAG.
 * 
 * @author user
 *
 */
public class TopologicalSortDemo {

	/**
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
		g.addVertex('I'); // Vertex[8] = 'I';

		// Connecting Vertexes, using Edges
		g.addEdge(0, 3, 1); // A->D
		// g.addEdge(3, 0, 1); // A->D // Putting cycle in Graph
		g.addEdge(0, 4, 1); // A->E
		g.addEdge(1, 3, 1); // B->D
		g.addEdge(2, 4, 1); // C->E
		g.addEdge(2, 7, 1); // C->H
		g.addEdge(3, 5, 1); // D->F
		g.addEdge(3, 6, 1); // D->G
		g.addEdge(3, 7, 1); // D->H
		g.addEdge(4, 6, 1); // A->G
		g.addEdge(8, 5, 1); // I->F
		
		int indegree[] = g.getIndegreeArray();
		g.printArray(indegree);
		g.topologicalSort();


	}

}
