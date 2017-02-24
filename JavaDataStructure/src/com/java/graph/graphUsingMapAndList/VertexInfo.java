package com.java.graph.graphUsingMapAndList;

/**
 * Created by chetan on 24/2/17.
 */
public class VertexInfo<V> {
    /** The vertex itself. */
    public V v;

    /** A mark for whether this vertex has been visited.  Useful for path searching. */
    public boolean visited;

    /** Constructs information for the given vertex. */
    public VertexInfo(V v) {
        this.v = v;
        this.clear();
    }

    /** Resets the visited field. */
    public void clear() {
        this.visited = false;
    }
}
