package com.java.graph;


public class DisjointSetUsingRank {

	private DisjointSet[] set;
	private int noOfElements;
	/**
	 * @return the noOfSets
	 */
	public int getNoOfSets() {
		return noOfElements;
	}

	/**
	 * @param noOfSets the noOfSets to set
	 */
	public void setNoOfElements(int noOfSets) {
		this.noOfElements = noOfSets;
	}

	/**
	 * @return the set
	 */
	public DisjointSet[] getSet() {
		return set;
	}

	/**
	 * @param set the set to set
	 */
	public void setSet(DisjointSet[] set) {
		this.set = set;
	}

	/**
	 * constructor
	 * @param noOfElements
	 */
	public DisjointSetUsingRank(int noOfElements) {
		setNoOfElements(noOfElements);
		set = new DisjointSet[noOfElements];
	}
	
	/**
	 * Set self loop
	 * @param noOfElements
	 */
	public void MakeSet(int noOfElements) {
		for (int i = 0; i< noOfElements; i++) {
			set[i].setParent(i);
			set[i].setRank(0);
		}
	}
	
	/**
	 * A utility function to find set of an element i
	 * (uses path compression technique)
	 * @param element
	 * @return
	 */
	public int find(int element) {
		
		// find root and make root as parent of i (path compression)
		if (set[element].getParent() != element) {
			set[element].setParent(find(set[element].getParent()));
		}
		
		return set[element].getParent();
	}
	
	/**
	 * A function that does union of two sets of element1 and element2 (uses union by rank)
	 * @param element1
	 * @param element2
	 */
	public void union(int element1, int element2) {
		int element1Root = find(element1);
		int element2Root = find(element2);
		
		// Attach smaller rank tree under root of high rank tree
	    // (Union by Rank)
		if (set[element1Root].getRank() > set[element2Root].getRank()) {
			set[element2Root].setParent(element1Root);
		} else if (set[element1Root].getRank() < set[element2Root].getRank()) {
			set[element1Root].setParent(element2Root);
		} else {
			// If ranks are same, then make one as root and increment
		    // its rank by one
			set[element2Root].setParent(element1Root);
			set[element2Root].setRank(set[element2Root].getRank()+1);
		}
	}
}

class DisjointSet {
	private int parent;
	private int rank;
	/**
	 * @return the parent
	 */
	public int getParent() {
		return parent;
	}
	/**
	 * @param parent the parent to set
	 */
	public void setParent(int parent) {
		this.parent = parent;
	}
	/**
	 * @return the rank
	 */
	public int getRank() {
		return rank;
	}
	/**
	 * @param rank the rank to set
	 */
	public void setRank(int rank) {
		this.rank = rank;
	}
}
