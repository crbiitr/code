package com.java.graph.graphUsingHashmap;

/**
 * Date 23/07/2018
 *
 * @author Chetan Raj
 * Runtime complexity - O(V + E)
 * Space complexity - O(V)
 * <p>
 * References
 * https://www.geeksforgeeks.org/euler-circuit-directed-graph/
 */
public class EulerianCircuitDirectedGraph<T> {

    public void DFSUtil(T vertex, Graph<T> graph) {
        graph.visited.put(vertex, true);
        for (T vertices : graph.graph.get(vertex)) {
            if (!graph.visited.get(vertices)) {
                DFSUtil(vertices, graph);
            }
        }
    }

    //Checking is Strongly connected component, But not more than One SCC component
    //That's why we are using same vertex in DFSUtil function, Not the STACK
    public boolean isSC(T vertex, Graph<T> graph) {
        boolean isSC = true;
        DFSUtil(vertex, graph);

        for (T vertices : graph.visited.keySet()) {
            if (!graph.visited.get(vertices)) {
                return false;
            }
        }

        //Reversing the graph
        graph.graph = graph.transposeGraph();

        DFSUtil(vertex, graph);

        for (T vertices : graph.visited.keySet()) {
            if (!graph.visited.get(vertices)) {
                return false;
            }
        }

        return isSC;
    }

    public boolean isEulerianCycle(T vertex, Graph<T> graph) {
        boolean isEulerianCycle = true;

        if (isSC(vertex, graph) == false) {
            return false;
        }

        //InDegree and OutDegree of vertex must be same
        for (T vertices : graph.graph.keySet()) {
            if (graph.graph.get(vertices).size() != graph.inDegree.get(vertices)) {
                return false;
            }
        }

        return isEulerianCycle;
    }


    public static void main(String[] args) {

        Graph<Integer> graph = new Graph<Integer>();
        graph.addDirectEdge(0, 2);
        graph.addDirectEdge(0, 3);
        graph.addDirectEdge(1, 0);
        graph.addDirectEdge(2, 1);
        graph.addDirectEdge(3, 4);
        graph.addDirectEdge(4, 0);

        graph.traverse();

        EulerianCircuitDirectedGraph<Integer> eulerianCircuitDirectedGraph = new EulerianCircuitDirectedGraph<>();
        System.out.println("isEulerianCircuit: " + eulerianCircuitDirectedGraph.isEulerianCycle(0, graph));
    }


}
