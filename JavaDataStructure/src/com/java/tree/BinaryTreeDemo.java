package com.java.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

class Node{

	private int data;
	private Node leftChild;
	private Node RightChild;

	public Node() {
		leftChild = RightChild = null;
		data = (Integer) null;
	}

	public Node(int data) {
		this.data = data;
		leftChild = RightChild = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return RightChild;
	}

	public void setRightChild(Node rightChild) {
		RightChild = rightChild;
	}

}

class BinaryTree {

	private Node root;
	public static int diameter;
	public HashMap<Integer, Integer> VerticalSum = new HashMap<Integer, Integer>();
	public BinaryTree() {
		root = null;
	}

	public Node getRoot() {
		return root;
	} 
	public void insertElement(int data) {
		Queue<Node> q = new LinkedList<Node>();
		Node temp = null;
		Node newNode = new Node(data);

		if(root == null) {
			root = newNode;
		} else {
			q.add(root);
			while(!q.isEmpty()) {
				temp = q.poll();

				if(temp.getLeftChild() != null) {
					q.add(temp.getLeftChild());
				} else {
					temp.setLeftChild(newNode);
					q.clear();
					return;
				}

				if(temp.getRightChild() != null) {
					q.add(temp.getRightChild());
				} else {
					temp.setRightChild(newNode);
					q.clear();
					return;
				}

			}
			q.clear();
		}
	}

	public void levelOrderTraversal() {

		Queue<Node> q = new LinkedList<Node>();
		if(root == null) {
			System.out.println("Tree is empty");
		} else {

			q.add(root);
			Node temp = null;

			while(!q.isEmpty()) {
				temp = q.poll();

				System.out.print("  " + temp.getData());

				if(temp.getLeftChild() != null) {
					q.add(temp.getLeftChild());
				}

				if(temp.getRightChild() != null) {
					q.add(temp.getRightChild());
				}

			}
			q.clear();
		}
	}

	public void PreOrderTraversalRecursion(Node root) {
		if(root != null) {
			System.out.print("  " + root.getData());
			PreOrderTraversalRecursion(root.getLeftChild());
			PreOrderTraversalRecursion(root.getRightChild());
		}

	}

	public void PostOrderTraversalRecursion(Node root) {
		if(root != null) {
			PostOrderTraversalRecursion(root.getLeftChild());
			PostOrderTraversalRecursion(root.getRightChild());
			System.out.print("  " + root.getData());
		}
	}

	public void InOrderTraversalRecursion(Node root) {
		if(root != null) {
			InOrderTraversalRecursion(root.getLeftChild());
			System.out.print("  " + root.getData());
			InOrderTraversalRecursion(root.getRightChild());
		}
	}

	public void PreOrderTraversalNonRecursive() {

		if(root == null) {
			return;
		}
		Node temp = root;
		Stack<Node> s = new Stack<Node>();
		while(true) {

			while(temp!=null) {
				System.out.print("  " + temp.getData());
				s.push(temp);
				temp = temp.getLeftChild();
			}

			if(s.isEmpty()) {
				break;
			} else {
				temp = s.pop();
			}

			temp = temp.getRightChild();			
		}
	}

	public void InOrderTraversalNonRecursive() {

		if(root == null) {
			return;
		}
		Node temp = root;
		Stack<Node> s = new Stack<Node>();
		while(true) {

			while(temp!=null) {
				s.push(temp);
				temp = temp.getLeftChild();
			}

			if(s.isEmpty()) {
				break;
			} else {
				temp = s.pop();
				System.out.print("  " + temp.getData());
			}

			temp = temp.getRightChild();			
		}
	}

	public void PostOrderTraversalNonRecursive() {

		if(root == null) {
			return;
		}
		Node temp = root;
		Stack<Node> s = new Stack<Node>();
		while(true) {

			while(temp!=null) {
				if(temp.getRightChild()!=null) {
					s.push(temp.getRightChild());
				}
				s.push(temp);
				temp = temp.getLeftChild();
			}

			if(s.isEmpty()) {
				break;
			} else {
				temp = s.pop();
			}
			if(!s.isEmpty() && temp.getRightChild()!=null && temp.getRightChild()==s.peek() ) {

				s.pop();
				s.push(temp);
				temp = temp.getRightChild();
			} else {
				System.out.print("  " + temp.getData());
				temp = null;
			}
		}
	}

	public int SizeOfTreeRecursively(Node root) {
		if(root == null) return 0;
		else return(SizeOfTreeRecursively(root.getLeftChild()) + 1 + SizeOfTreeRecursively(root.getRightChild()));
	}

	public void LevelOrderTraversalInReverse() {
		Queue<Node> q = new LinkedList<Node>();
		Stack<Node> s = new Stack<Node>();

		Node temp = root;
		if(temp == null) {
			return;
		}

		q.add(temp);
		while(!q.isEmpty()) {
			temp = q.poll();
			if(temp.getRightChild()!= null) {
				q.add(temp.getRightChild());
			}
			if(temp.getLeftChild()!=null) {
				q.add(temp.getLeftChild());
			}
			s.push(temp);
		}

		while(!s.isEmpty()) {
			System.out.print("  " + s.pop().getData());
		}
	}

	public int getHeightOfTree(Node root) {
		if(root==null) {
			return -1;
		} else return(Math.max(getHeightOfTree(root.getLeftChild()), getHeightOfTree(root.getRightChild())) + 1);
	}

	public int getHeightOfTreeNonRecursive() {

		Node temp;
		int height = -1;
		Queue<Node> q = new LinkedList<Node>();
		if(root != null) {
			q.add(root);
			q.add(null);
		}

		while(!q.isEmpty()) {
			temp = q.poll();
			if(temp==null) {
				if(!q.isEmpty()) {
					q.add(null);
				}
				height++;
			}else {

				if(temp.getLeftChild()!=null) {
					q.add(temp.getLeftChild());
				}
				if(temp.getRightChild()!=null) {
					q.add(temp.getRightChild());
				}
			}
		}
		q.clear();
		return height;
	}

	static boolean AreStructurullySameTrees(Node root1, Node root2) {
		if(root1==null && root2==null)
			return true;
		if(root1==null || root2==null)
			return false;

		return (root1.getData()==root2.getData() 
				&& AreStructurullySameTrees(root1.getLeftChild(), root2.getLeftChild())
				&& AreStructurullySameTrees(root1.getRightChild(), root2.getRightChild()) );
	}

	static int DiameterOfTree(Node root) {
		if(root == null) return 0;
		int ld, rd;
		ld = DiameterOfTree(root.getLeftChild());
		rd = DiameterOfTree(root.getRightChild());
		if(ld+rd>=diameter) diameter = ld+rd+1;
		return Math.max(ld, rd)+1;

	}

	public void LevelOfMaxSum() {
		Node temp;
		int height = -1;
		int LevelMaxSum = Integer.MIN_VALUE;
		int maxLevel = 0;
		int sum = 0;
		Queue<Node> q = new LinkedList<Node>();
		if(root != null) {
			q.add(root);
			q.add(null);
		}

		while(!q.isEmpty()) {
			temp = q.poll();
			if(temp==null) {
				if(!q.isEmpty()) {
					q.add(null);
				}
				height++;
				if(sum>LevelMaxSum) {
					LevelMaxSum = sum;
					maxLevel = height;
				}
				sum=0;
			}else {

				sum+=temp.getData();
				if(temp.getLeftChild()!=null) {
					q.add(temp.getLeftChild());
				}
				if(temp.getRightChild()!=null) {
					q.add(temp.getRightChild());
				}
			}
		}
		q.clear();
		System.out.println("Maximum sum is : " + LevelMaxSum + "  of Level : "+ maxLevel);
	}

	public void PrintAllPathsOfTree() {
		int path[] = new int[256];
		PrintPaths(root,path,0);
	}
	public void PrintPaths(Node root, int[] path, int len) {
		if(root == null) return;

		path[len]=root.getData();
		len++;
		if(root.getLeftChild() == null && root.getRightChild() == null) PrintArray(path,len);
		else {
			PrintPaths(root.getLeftChild(), path, len);
			PrintPaths(root.getRightChild(), path, len);
		}
	}
	public void PrintArray(int[] a,int len) {
		for(int i=0;i<len;i++) {
			System.out.print("  " + a[i]);
		}
		System.out.println();
	}

	boolean HasPathSum(int sum) {
		return(HasPathSum(root,sum));
	}
	boolean HasPathSum(Node root, int sum) {
		if(root == null)
			return (sum==0);
		else {
			if(sum!=0)
				sum-=root.getData();
			else
				return true;
			if((root.getLeftChild()==null && root.getRightChild()==null) ||(root.getLeftChild()!=null && root.getRightChild()!=null))
				return (HasPathSum(root.getLeftChild(), sum) || HasPathSum(root.getRightChild(), sum));
			else if(root.getLeftChild()!=null)
				return HasPathSum(root.getLeftChild(), sum);
			else 
				return HasPathSum(root.getRightChild(), sum);
		}
	}

	void PrintAllAncestors(int num) {
		int array[] = new int[256];
		PrintAllAncestors(root,array,0,num);
	}
	void PrintAllAncestors(Node root, int []path, int len, int num) {
		if(root == null) return ;

		path[len] = root.getData();
		len++;
		if(root.getData()==num) {
			PrintArray(path, len);
		} else {
			PrintAllAncestors(root.getLeftChild(), path, len, num);
			PrintAllAncestors(root.getRightChild(), path, len, num);
		}
	}

	Node GetSearchedNode(int num) {
		Queue<Node> q = new LinkedList<Node>();
		if(root == null) {
			return null;
		} else {

			q.add(root);
			Node temp = null;

			while(!q.isEmpty()) {
				temp = q.poll();

				if(temp.getData()==num) break;

				if(temp.getLeftChild() != null) {
					q.add(temp.getLeftChild());
				}

				if(temp.getRightChild() != null) {
					q.add(temp.getRightChild());
				}

			}
			q.clear();
			return temp;
		}
	}
	
	Node LCA(Node root, Node a, Node b) {
		Node left,right;
		if(root==null) return null;
		if(root==a || root==b) return root;
		
		left = LCA(root.getLeftChild(),a,b);
		right = LCA(root.getRightChild(),a,b);
		
		if(left!=null && right!=null) 
			return root;
		else return (left!=null?left:right);
	}
	
	void GetVerticalSumOfTree() {
		GetVerticalSumOfTree(root,0);
		printHashMap(VerticalSum);
	}
	void GetVerticalSumOfTree(Node root, int column) {
		if(root==null) return;
		GetVerticalSumOfTree(root.getLeftChild(), column-1);
		if(VerticalSum.containsKey(column)) {
			int x = VerticalSum.get(column);
			VerticalSum.put(column, x+root.getData());
		} else {
			VerticalSum.put(column, root.getData());
		}
		GetVerticalSumOfTree(root.getRightChild(), column+1);
	}
	
	void printHashMap(HashMap<Integer, Integer> map) {
		for(Map.Entry<Integer,Integer> e : map.entrySet()) {
			System.out.println(e.getKey() + "  :  " + e.getValue());
		}
	}
}

public class BinaryTreeDemo {

	public static void main(String[] args) {

		BinaryTree  bt = new BinaryTree();
		bt.insertElement(1);
		bt.insertElement(2);
		bt.insertElement(3);
		bt.insertElement(4);
		bt.insertElement(5);
		bt.insertElement(6);
		bt.insertElement(7);
		bt.insertElement(8);
		bt.insertElement(9);
		bt.insertElement(10);
		bt.insertElement(11);
		bt.insertElement(12);
		bt.insertElement(13);
		bt.insertElement(14);
		bt.insertElement(15);
		bt.insertElement(16);
		bt.insertElement(17);
		bt.insertElement(18);
		bt.insertElement(19);

		BinaryTree  bt2 = new BinaryTree();
		bt2.insertElement(1);
		bt2.insertElement(2);
		bt2.insertElement(3);
		bt2.insertElement(4);
		bt2.insertElement(5);
		bt2.insertElement(6);
		bt2.insertElement(7);
		bt2.insertElement(8);
		bt2.insertElement(9);
		bt2.insertElement(10);
		bt2.insertElement(11);
		bt2.insertElement(12);
		bt2.insertElement(13);
		bt2.insertElement(14);
		bt2.insertElement(15);
		bt2.insertElement(16);
		bt2.insertElement(17);
		bt2.insertElement(18);
		//		bt2.insertElement(19);

		bt.levelOrderTraversal();

		System.out.println("\n\nPreOrder Traversal Using recursion ");
		bt.PreOrderTraversalRecursion(bt.getRoot());

		System.out.println("\n\nPostOrder Traversal Using recursion ");
		bt.PostOrderTraversalRecursion(bt.getRoot());

		System.out.println("\n\nInOrder Traversal Using recursion ");
		bt.InOrderTraversalRecursion(bt.getRoot());

		System.out.println("\n\nPreOrder Traversal without recursion ");
		bt.PreOrderTraversalNonRecursive();

		System.out.println("\n\nInOrder Traversal without recursion ");
		bt.InOrderTraversalNonRecursive();

		System.out.println("\n\nPostOrder Traversal without recursion ");
		bt.PostOrderTraversalNonRecursive();

		System.out.println("\n\nReverse Level Order Traversal ");
		bt.LevelOrderTraversalInReverse();

		System.out.println("\n\nSize of tree is : " + bt.SizeOfTreeRecursively(bt.getRoot()));
		System.out.println("Height of Tree : " + bt.getHeightOfTree(bt.getRoot()));
		System.out.println("Height of Tree Non Recursive : " + bt.getHeightOfTreeNonRecursive());
		bt.DiameterOfTree(bt.getRoot());
		System.out.println("Diameter of tree is : " + bt.diameter);
		// Printing maximum sum with level 
		bt.LevelOfMaxSum();


		if(BinaryTree.AreStructurullySameTrees(bt.getRoot(),bt2.getRoot())) {
			System.out.println("Both Trees are Structurelly same");
		} else {
			System.out.println("Both Trees are not Structurelly same");
		}

		bt.PrintAllPathsOfTree();
		System.out.println("Has Path Sum : " + bt.HasPathSum(23));
		System.out.println("All ancestors of 18 are : \n");
		bt.PrintAllAncestors(18);
		
		//LCA Process
		Node a = bt.GetSearchedNode(1);
		Node b = bt.GetSearchedNode(7);
		Node LCA = bt.LCA(bt.getRoot(), a, b);
		if(LCA!=null) {
			System.out.println("LCA of " + a.getData() + " and " + b.getData() + " is " + LCA.getData());
		}else {
			System.out.println("LCA does not present.");
		}
		
		//Printing Vertical Sum
		bt.GetVerticalSumOfTree();
	}

}
