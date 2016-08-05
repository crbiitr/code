package com.java.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Vertex class  
 * @author user
 */
class Vertex {
	public char label;
	public boolean visited;

	public Vertex(char lab) {
		label = lab;
		visited = false;
	}
}

/**
 * Graph main class;
 * @param args
 */
class GraphADT {
	private int maxVertices = 20;
	private Vertex[] vertexList;
	private int vertexCount;
	private int adjMatrix[][];
	private int indegree[];

	public GraphADT() {
		vertexCount = 0;
		vertexList = new Vertex[maxVertices];
		adjMatrix = new int[maxVertices][maxVertices];
		indegree = new int[maxVertices];
		for (int x = 0; x < maxVertices; x++) {
			indegree[x] = -1;
			for (int y = 0; y < maxVertices; y++) {
				adjMatrix[x][y] = 0;
			}
		}
	}

	/**
	 * @return the maxVertices
	 */
	public int getMaxVertices() {
		return maxVertices;
	}
	/**
	 * @param maxVertices the maxVertices to set
	 */
	public void setMaxVertices(int maxVertices) {
		this.maxVertices = maxVertices;
	}
	/**
	 * @return the vertexList
	 */
	public Vertex[] getVertexList() {
		return vertexList;
	}
	/**
	 * @param vertexList the vertexList to set
	 */
	public void setVertexList(Vertex[] vertexList) {
		this.vertexList = vertexList;
	}
	/**
	 * @return the vertexCount
	 */
	public int getVertexCount() {
		return vertexCount;
	}
	/**
	 * @param vertexCount the vertexCount to set
	 */
	public void setVertexCount(int vertexCount) {
		this.vertexCount = vertexCount;
	}
	/**
	 * @return the adjMatrix
	 */
	public int[][] getAdjMatrix() {
		return adjMatrix;
	}
	/**
	 * @param adjMatrix the adjMatrix to set
	 */
	public void setAdjMatrix(int[][] adjMatrix) {
		this.adjMatrix = adjMatrix;
	}

	/**
	 * @param lab
	 */
	public void addVertex(char lab) {
		vertexList[vertexCount++] = new Vertex(lab);
	}

	/**
	 * @param x
	 * @param y
	 */
	public void addEdge(int x, int y) {
		adjMatrix[x][y] = 1;
		adjMatrix[y][x] = 1;
		
		if (indegree[x] == -1) {
			indegree[x] = 1;
		} else {
			indegree[x]++;
		}
		
		if (indegree[y] == -1) {
			indegree[y] = 1;
		} else {
			indegree[y]++;
		}
	}

	/**
	 * This method is used for adding a edge with weight
	 * 
	 * @param x
	 * @param y
	 * @param weight
	 */
	public void addEdge(int x, int y, int weight) {
		adjMatrix[x][y] = weight;
		
		if (indegree[x] == -1) {
			indegree[x] = 0;
		}
		
		if (indegree[y] == -1) {
			indegree[y] = 1;
		} else {
			indegree[y]++;
		}
	}

	/**
	 * @param S
	 */
	public void dfs(Stack<Integer> S) {
		if (vertexCount == 0) {
			return;
		}

		vertexList[0].visited = true;
		display(0);
		S.push(0);
		while(!S.isEmpty()) {
			int v = getAdjUnvisitedVertex(S.peek());
			if(v == -1) {
				S.pop();
			} else {
				vertexList[v].visited = true;
				display(v);
				S.push(v);
			}
		}

		for (int i = 0; i < vertexCount; i++) {
			vertexList[i].visited = false;
		}
	}

	/**
	 * @param v
	 * @return
	 */
	public int getAdjUnvisitedVertex(int v) {
		for (int j = 0; j < vertexCount; j++) {
			if(adjMatrix[v][j] >= 1 && vertexList[j].visited == false) {
				return j;
			}
		}
		return -1;
	}

	/**
	 * Breath First Search
	 * @param Q
	 */
	public void bfs(Queue<Integer> Q) {
		if (vertexCount == 0) {
			return;
		}

		Q.add(0);
		vertexList[0].visited = true;
		display(0);

		while(!Q.isEmpty()) {
			int v1 = Q.poll();
			int v2;
			while((v2 = getAdjUnvisitedVertex(v1)) != -1) {
				vertexList[v2].visited = true;
				Q.add(v2);
				display(v2);
			}
		}

		for (int i = 0; i < vertexCount; i++) {
			vertexList[i].visited = false;
		}
	}

	/**
	 * Display a label of index v
	 * @param v
	 */
	public void display(int v) {
		System.out.print("  " + vertexList[v].label);
	}

	/**
	 * 
	 */
	public void topologicalSort() {
		Queue<Integer> Q = new LinkedList<Integer>();
		int indegreeArray[] = getIndegreeArray();
		int counter = 0;
		for (int i = 0; i < vertexCount; i++) {
			if (indegreeArray[i] == 0) {
				Q.add(i);
			}
		}
		
		while (!Q.isEmpty()) {
			int v1 = Q.poll();
			counter++;
			System.out.print("  " + vertexList[v1].label);
			for (int i = 0; i < maxVertices; i++) {
				if (adjMatrix[v1][i] >= 1) {
					if (--indegreeArray[i] == 0) {
						Q.add(i);
					}
				}
			}
		}
		if (counter != vertexCount) {
			System.out.println("Graph has cycle");
		}
	}


	/**
	 * Use this method only for DAG(Directed acyclic graph)
	 * @return indegree array
	 */
	public int[] getIndegreeArray() {
		int indegree[] = new int[maxVertices];
		for (int i = 0; i < maxVertices; i++) {
			indegree[i] = this.indegree[i];
		}

		return indegree;
	}

	public void printArray(int array[]) {
		for (int i : array) {
			System.out.print("  " + i);
		}
		System.out.println();
	}

	public void printMatrix(int matrix[][]) {

		for (int i = 0; i < maxVertices; i++) {
			for (int j = 0; j < maxVertices; j++) {
				System.out.print("  " + matrix[i][j]);
			}
			System.out.println();
		}

		System.out.println();
	}
}
