package com.java.graph.competitiveProblems;

import java.util.*;

// https://leetcode.com/explore/learn/card/graph/619/depth-first-search-in-graph/3900/
// this can be solved using single loop

// Definition for a Node
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneTheGraph {

    public static void main(String[] args) {
//        [[2,4],[1,3],[2,4],[1,3]]
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        CloneTheGraph cloneTheGraph = new CloneTheGraph();
        cloneTheGraph.printGraph(node1);
        Node node = cloneTheGraph.cloneGraph(node1);
        System.out.println("\n\n");
        cloneTheGraph.printGraph(node);
    }

    public Node cloneGraph(Node node) {
        // BFS traversal, create a Map for Original & Duplicate
        if(node==null) return null;
        if (node.neighbors==null) return node;

        boolean[] visited = new boolean[101];
        HashMap<Node, Node> map = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        visited[node.val] = true;

        while (!queue.isEmpty()) {
            Node currNode = queue.poll();
            map.put(currNode, new Node(currNode.val));
            for (Node neighbor : currNode.neighbors) {
                if (!visited[neighbor.val]) {
                    queue.add(neighbor);
                    visited[neighbor.val] = true;

                }
            }
        }

        queue.clear();
        Arrays.fill(visited, false);
        queue.add(node);
        visited[node.val] = true;
        while (!queue.isEmpty()) {
            Node currNode = queue.poll();
            Node copyNode = map.get(currNode);

            List<Node> copyNeighbors = copyNode.neighbors;
            for (Node neighbor : currNode.neighbors) {
                copyNeighbors.add(map.get(neighbor));

                if (!visited[neighbor.val]) {
                    queue.add(neighbor);
                    visited[neighbor.val] = true;

                }
            }
        }

        return map.get(node);
    }

    public void printGraph(Node node) {
        boolean[] visited = new boolean[101];
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        visited[node.val] = true;
        while (!queue.isEmpty()) {
            Node currNode = queue.poll();
            System.out.print(currNode.val + " - ");
            for (Node neighbor : currNode.neighbors) {
                if (!visited[neighbor.val]) {
                    visited[neighbor.val] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}
