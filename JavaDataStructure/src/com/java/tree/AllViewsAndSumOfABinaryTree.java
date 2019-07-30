package com.java.tree;

import java.util.*;
import java.lang.*;

class AllViewsAndSumOfABinaryTree {
    public static int maxLevel = 0;

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);                                //                     1
        root.left = new TreeNode(2);                                    //               2           3
        root.right = new TreeNode(3);                                   //        9           6 4         5
        root.left.left = new TreeNode(9);                               //            10 11   12    7
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(11);
        root.left.left.right = new TreeNode(10);

        System.out.println("Level Order Traversal");
        levelOrderTraversal(root);

        System.out.println("\n\nSpiral Traversal");
        PrintSpiralTree.printSpiral(root);

        // All kind of SUM of a Binary Tree
        System.out.println("\n\nPrinting Diagonal Sum using Iterative Method");
        printDiagonalSumOfABinaryTree(root);

        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        System.out.println("\n\nPrinting Diagonal Sum :: ");
        printDiagonalSumOfABinaryTree_2(root,0,map); // It's also a good logic.
        printMap(map);
        map.clear();

        System.out.println("\n\nPrinting Vertical Sum :: ");
        printVerticalSumOfABinaryTree(root, 0, map); // It's also a good logic.
        printMap(map);



        // All Kind of VIEW of a Binary Tree
        System.out.println("\n\nPrinting LeftView Of a Tree");
        printLeftViewOfABinaryTree(root,1);

        System.out.println("Level Order Traversal");
        levelOrderTraversal(root);

        map.clear();
        System.out.println("\n\nPrinting Top View :: ");
        topView(root, 0, map);
        printMap_2(map);


        map.clear();
        System.out.println("\n\nPrinting Bottom View :: ");
        bottomView(root, 0, map);
        printMap_2(map);



    }
	
	/**
	 * This method print the diagonal sum of a binary tree.
	 * Time complexity = O(n)
	 * Space complexity = O(n) (need to store elements in queue)
	 * @param root
	 */
	public static void printDiagonalSumOfABinaryTree(TreeNode root){
		if(root==null)
			return;
		
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		//This null will indicate the end of one diagonal
		queue.add(null);
		int sum=0;
		while(!queue.isEmpty()){
			root = queue.remove();
			//if root null, it means we have reached end of diagonal. so, print the sum
			if(root==null){
				System.out.print(sum+" ");
				sum=0;
				//Mark end of next diagonal
				if(!queue.isEmpty()){
					queue.add(null);
				}
			}else{
				while(root != null){
					sum += root.data;
					if(root.left != null)
						queue.add(root.left);
					root = root.right;
				}
			}
		}
	}

    /**
     * This is also a good solution.
     * This method print the diagonal sum of a binary tree.
     * Time complexity = O(n)
     * Space complexity = O(n) (need to store elements in HashMap)
     * @param root,currDiag and HashMap
     */
    public static void printDiagonalSumOfABinaryTree_2(TreeNode root,int currDiag, HashMap<Integer, Integer> map){
        if(root==null)
            return;

        printDiagonalSumOfABinaryTree_2(root.left, currDiag + 1, map);

        int prevSum = 0;
        if (map.get(currDiag) != null) {
            prevSum = map.get(currDiag);
        }
        map.put(currDiag, (prevSum + root.data));

        printDiagonalSumOfABinaryTree_2(root.right, currDiag, map);
    }

    /**
     * This is also a good solution.
     * This method print the diagonal sum of a binary tree.
     * Time complexity = O(n)
     * Space complexity = O(n) (need to store elements in HashMap)
     * @param root,currDiag and HashMap
     */
    public static void printVerticalSumOfABinaryTree(TreeNode root,int currDiag, HashMap<Integer, Integer> map){
        if(root==null)
            return;


        int prevSum = 0;
        if (map.get(currDiag) != null) {
            prevSum = map.get(currDiag);
        }
        map.put(currDiag, (prevSum + root.data));
        printVerticalSumOfABinaryTree(root.left, currDiag -1, map);
        printVerticalSumOfABinaryTree(root.right, currDiag + 1, map);
    }

    /**
     *
     * This method print the LeftView of a binary tree.
     * Time complexity = O(n)
     * Space complexity = O(n) (need to store elements in HashMap)
     * @param root,currDiag and HashMap
     */
    public static void printLeftViewOfABinaryTree(TreeNode root, int level){
        if(root==null)
            return;

        if (maxLevel<level) {
            maxLevel = level;
            System.out.println(root.data);
        }
        printLeftViewOfABinaryTree(root.left,level+1);
        printLeftViewOfABinaryTree(root.right,level+1);
    }

    public  static void topView(TreeNode root, int currDiag, HashMap<Integer,Integer> map) {
        if(root==null)
            return;

        if (map.get(currDiag) == null) {
            map.put(currDiag,root.data);
        }

        topView(root.left, currDiag-1, map);
        topView(root.right, currDiag+1, map);
    }

    public  static void bottomView(TreeNode root, int currDiag, HashMap<Integer,Integer> map) {
        if(root==null)
            return;

        map.put(currDiag,root.data);

        bottomView(root.left, currDiag-1, map);
        bottomView(root.right, currDiag+1, map);
    }

    public static void printMap(HashMap<Integer,Integer> map) {
        Iterator e = map.entrySet().iterator();
        while (e.hasNext()) {
            Map.Entry pair = (Map.Entry)e.next();
            System.out.println(pair.getKey() + " Sum::  " + pair.getValue());
        }
    }

    public static void printMap_2(HashMap<Integer,Integer> map) {
        Iterator e = map.entrySet().iterator();
        while (e.hasNext()) {
            Map.Entry pair = (Map.Entry)e.next();
            System.out.println(pair.getKey() + " :: " + pair.getValue());
        }
    }

    public static void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root == null) {
            System.out.println("Tree is empty");
        } else {
            q.add(root);
            TreeNode temp = null;
            while(!q.isEmpty()) {
                temp = q.poll();
                System.out.print("  " + temp.data);
                if(temp.left != null) {
                    q.add(temp.left);
                }
                if(temp.right != null) {
                    q.add(temp.right);
                }
            }
            q.clear();
        }
    }

}

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	public TreeNode(int data) {
		this.data = data;
	}
}