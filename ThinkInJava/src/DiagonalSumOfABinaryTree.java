///* package whatever; // don't place package name! */
//
//import java.util.*;
//import java.lang.*;
//import java.io.*;
//
//class DiagonalSumOfABinaryTree {
//
//	public static void main(String[] args) {
//
//		TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(9);
//        root.left.right = new TreeNode(6);
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(5);
//        root.right.left.left = new TreeNode(12);
//        root.right.left.right = new TreeNode(7);
//        root.left.right.left = new TreeNode(11);
//        root.left.left.right = new TreeNode(10);
//        printDiagonalSumOfABinaryTree(root);
//	}
//
//	/**
//	 * This method print the diagonal sum of a binary tree.
//	 * Time complexity = O(n)
//	 * Space complexity = O(n) (need to store elements in queue)
//	 * @param root
//	 */
//	public static void printDiagonalSumOfABinaryTree(TreeNode root){
//		if(root==null)
//			return;
//
//		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
//		queue.add(root);
//		//This null will indicate the end of one diagonal
//		queue.add(null);
//		int sum=0;
//		while(!queue.isEmpty()){
//			root = queue.remove();
//			//if root null, it means we have reached end of diagonal. so, print the sum
//			if(root==null){
//				System.out.print(sum+" ");
//				sum=0;
//				//Mark end of next diagonal
//				if(!queue.isEmpty()){
//					queue.add(null);
//				}
//			}else{
//				while(root != null){
//					sum += root.data;
//					if(root.left != null)
//						queue.add(root.left);
//					root = root.right;
//				}
//			}
//		}
//	}
//}
//
//class TreeNode {
//	int data;
//	TreeNode left;
//	TreeNode right;
//	public TreeNode(int data) {
//		this.data = data;
//	}
//}