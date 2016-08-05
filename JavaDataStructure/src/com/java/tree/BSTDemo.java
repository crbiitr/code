package com.java.tree;

import java.util.LinkedList;
import java.util.Queue;

class BSTNode{

	private int data;
	private BSTNode leftChild;
	private BSTNode RightChild;

	public BSTNode() {
		leftChild = RightChild = null;
		data = (Integer) null;
	}

	public BSTNode(int data) {
		this.data = data;
		leftChild = RightChild = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public BSTNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BSTNode leftChild) {
		this.leftChild = leftChild;
	}

	public BSTNode getRightChild() {
		return RightChild;
	}

	public void setRightChild(BSTNode rightChild) {
		RightChild = rightChild;
	}

}

class BST {
	private BSTNode root;

	public BST(){
		root = null;
	}

	public BSTNode getRoot() {
		return root;
	}

	public void setRoot(BSTNode root) {
		this.root = root;
	}

	public void InsertElement(int data) {
		root = InsertElement(root,data);
	}

	public BSTNode InsertElement(BSTNode root, int data) {
		if(root==null) {
			BSTNode newNode = new BSTNode(data);
			root = newNode;
		} else {
			if(data < root.getData()) {
				root.setLeftChild(InsertElement(root.getLeftChild(),data));
			} else {
				root.setRightChild(InsertElement(root.getRightChild(), data));
			}
		}

		return root;
	}

	BSTNode FindRecursive(int data) {
		return FindRecursive(root,data);
	}

	BSTNode FindRecursive(BSTNode root, int data) {
		if(root == null) return null;

		if(root.getData()>data) return FindRecursive(root.getLeftChild(),data);
		else if(root.getData()<data) return FindRecursive(root.getRightChild(), data);

		return root;// in case it matches means (root.getData()==data)
	}

	BSTNode FindNonRecursive(int data) {
		BSTNode temp = root;
		if(root == null) return null;
		while(temp != null) {
			if(temp.getData()==data) return temp;
			else if(temp.getData()>data) temp = temp.getLeftChild();
			else temp = temp.getRightChild();
		}
		return null;
	}

	void InOrderTraveralRecursive(BSTNode root) {
		if(root!=null) {
			InOrderTraveralRecursive(root.getLeftChild());
			System.out.print("  " + root.getData());
			InOrderTraveralRecursive(root.getRightChild());
		}
	}
	
	public void levelOrderTreaversal() {

		Queue<BSTNode> q = new LinkedList<BSTNode>();
		if(root == null) {
			System.out.println("Tree is empty");
		} else {

			q.add(root);
			BSTNode temp = null;

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

	public void LevelOrderWithComma() {
		BSTNode temp;
		int height = -1;
		int LevelMaxSum = Integer.MIN_VALUE;
		int maxLevel = 0;
		int sum = 0;
		Queue<BSTNode> q = new LinkedList<BSTNode>();
		if(root != null) {
			q.add(root);
			q.add(null);
		}

		while(!q.isEmpty()) {
			temp = q.poll();
			if(temp==null) {
				if(!q.isEmpty()) {
					q.add(null);
					System.out.print(", ");
				}
				height++;
				if(sum>LevelMaxSum) {
					LevelMaxSum = sum;
					maxLevel = height;
				}
				sum=0;
			}else {
				System.out.print(" " + temp.getData());
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
	}

	
	BSTNode findMinNode() {
		BSTNode temp = root;
		if(root==null) return null;
		while(temp.getLeftChild()!=null) {
			temp = temp.getLeftChild();
		}
		return temp;
	}

	BSTNode findMaxNode() {
		BSTNode temp = root;
		if(root==null) return null;
		while(temp.getRightChild()!=null) {
			temp = temp.getRightChild();
		}
		return temp;
	}
	
	static BSTNode findMinNodeRecursive(BSTNode root) {
		if(root==null) return null;
		if(root.getLeftChild()==null) return root;
		else return findMinNodeRecursive(root.getLeftChild());
	}
	
	static BSTNode findMaxNodeRecursive(BSTNode root) {
		if(root==null) return null;
		if(root.getRightChild()==null) return root;
		else return findMinNodeRecursive(root.getRightChild());
	}
	
	void DeleteElement(int data) {
		BSTNode temp = root, temp2=null,temp3=null;
		if(root == null) return ;
		while(temp.getLeftChild()!=null || temp.getRightChild()!=null) {
			if(temp.getData()==data) break;
			else if(temp.getData()>data) {
				temp2 = temp;
				temp = temp.getLeftChild();
			} else if(temp.getData()<data){
				temp2 = temp;
				temp = temp.getRightChild();
			}
		}
		
		if(temp.getLeftChild() == null && temp.getRightChild() == null && temp2 != null) {
			
			if(temp2.getRightChild()==temp) temp2.setRightChild(null);
			if(temp2.getLeftChild()==temp) temp2.setLeftChild(null);
			
		}else if(temp.getLeftChild()==null && temp.getRightChild()!=null && temp2 != null) {
			
			if(temp2.getRightChild()==temp) temp2.setRightChild(temp.getRightChild());
			if(temp2.getLeftChild()==temp) temp2.setLeftChild(temp.getRightChild());
			
		}else if(temp.getLeftChild()!=null && temp.getRightChild()==null && temp2 != null) {
			
			if(temp2.getRightChild()==temp) temp2.setRightChild(temp.getLeftChild());
			if(temp2.getLeftChild()==temp) temp2.setLeftChild(temp.getLeftChild());
			
		}else if(temp.getLeftChild() != null && temp.getRightChild() != null) {
			
			temp3=findMaxNodeRecursive(temp.getLeftChild());
			int dElement = temp.getData();
			temp.setData(temp3.getData());
			temp3.setData(dElement);
			DeleteElement(dElement);
			
		}
		
		
	}
	
	BSTNode DeleteElementRecursive(BSTNode root, int data) {
		BSTNode temp;
		if(root==null) {
			System.out.println("Element is not there in tree");
		} else if(data<root.getData()) {
			root.setLeftChild(DeleteElementRecursive(root.getLeftChild(), data));
		} else if(data>root.getData()) {
			root.setRightChild(DeleteElementRecursive(root.getRightChild(), data));
		} else {
			if(root.getLeftChild()!=null && root.getRightChild()!=null) {
				temp = findMaxNodeRecursive(root.getLeftChild());
				root.setData(temp.getData());
				root.setLeftChild(DeleteElementRecursive(root.getLeftChild(), data));
			} else {
				temp = root;
				if(root.getLeftChild()==null) {
					root = root.getRightChild();
				}
				
				if(root.getRightChild()==null) {
					root = root.getLeftChild();
				}
//				root = null;
				root.setLeftChild(null);
				root.setRightChild(null);
				root.setData((Integer)null);
			}
		}
		
		return root;
	}
	
	BSTNode LCA(BSTNode root, BSTNode a, BSTNode b) {
		
		while(true) {
			
			if((a.getData()<=root.getData()&&root.getData()<=b.getData()) 
					|| (a.getData()>=root.getData()&&root.getData()>=b.getData())) {
				return root;
			}
			
			if(a.getData()<root.getData()) {
				root = root.getLeftChild();
			} else root = root.getRightChild();
		}
	}
	
	boolean isBST(BSTNode root) {
		if(root==null) return true;
		if(root.getLeftChild()!=null && findMaxNodeRecursive(root.getLeftChild()).getData()>root.getData()) {
			return false;
		}
		if(root.getRightChild()!=null && findMinNodeRecursive(root.getRightChild()).getData()<root.getData()) {
			return false;
		}
		
		if(!isBST(root.getLeftChild()) || !isBST(root.getRightChild())) return false;
		
		return true;
	}
	
	BSTNode KthSmallestInBST(BSTNode root, int k, int count) {
		if(root==null) return root;
		BSTNode left = KthSmallestInBST(root.getLeftChild(), k, count+1);
		
		if(left!=null) return left;
		
		if(++count==k) return root;
		
		return KthSmallestInBST(root.getRightChild(), k, count+1);
	}
}

public class BSTDemo {

	public static void main(String[] args) {

		BST bst = new BST();
		bst.InsertElement(20);
		bst.InsertElement(10);
		bst.InsertElement(25);
		bst.InsertElement(7);
		bst.InsertElement(15);
		bst.InsertElement(13);
		bst.InsertElement(40);
		bst.InsertElement(30);
		bst.InsertElement(50);
		bst.InsertElement(26);
		bst.InsertElement(35);
		bst.InsertElement(32);
		bst.InsertElement(80);
		bst.InsertElement(45);
		bst.InsertElement(41);
		bst.InsertElement(46);

		System.out.println("Print InOrder Traversal Recursive ");
		bst.InOrderTraveralRecursive(bst.getRoot());
		int findElement =14;
		System.out.println("\n\nFinding Element "+ findElement+" in BST using recursive funtion");
		BSTNode temp = bst.FindNonRecursive(findElement);
		if(temp == null) {
			System.out.println("  " + findElement +" does not present in the BST");
		} else {
			System.out.println("  " + findElement +" Present in the BST");
		}

		System.out.println("\nFinding Element "+ findElement+" in BST using Non Recursive funtion");
		temp = bst.FindNonRecursive(findElement);
		if(temp == null) {
			System.out.println("  " + findElement +" does not present in the BST");
		} else {
			System.out.println("  " + findElement +" Present in the BST");
		}

		temp = bst.findMinNode();
		if(temp == null) {
			System.out.println("BST is empty");
		} else {
			System.out.println("Min element of tree is : " + temp.getData());
		}

		temp = bst.findMaxNode();
		if(temp == null) {
			System.out.println("BST is empty");
		} else {
			System.out.println("Max element of tree is : " + temp.getData());
		}
		
		int kth = 4;
		BSTNode KthNode = null;
		KthNode = bst.KthSmallestInBST(bst.getRoot(), kth, 0);
		if(KthNode!=null) {
			System.out.println(kth + "th smallest in the BST is : " + KthNode.getData());
		}else {
			System.out.println("less nodes are present in the tree");
		}

		//Deleting an element
/*		
		int deletingElement = 80;
		bst.DeleteElementRecursive(bst.getRoot(), deletingElement);
		bst.InOrderTraveralRecursive(bst.getRoot());
*/
		System.out.println("Level Order Traversal : ");
		bst.LevelOrderWithComma();
		int deletingElement = 30;
		System.out.println("\n\nDeleted Element is : " + deletingElement);
		bst.DeleteElement(deletingElement);
		System.out.println("Level Order Traversal After Deleting Element " + deletingElement);
		bst.LevelOrderWithComma();
		
		//LCA of BST
		BSTNode a = bst.FindNonRecursive(26);
		BSTNode b = bst.FindNonRecursive(45);
		BSTNode lca = bst.LCA(bst.getRoot(), a, b);
		System.out.println("\nLCA is : " + lca.getData());
		
		if(bst.isBST(bst.getRoot())) {
			System.out.println("It is a BST tree");
		} else {
			System.out.println("It is not a BST tree");
		}


		BST bst2 = new BST();
		bst2.InsertElement(6);
		bst2.InsertElement(2);
		bst2.InsertElement(8);
		bst2.InsertElement(1);
		bst2.InsertElement(9);
		bst2.InsertElement(10);
		if(bst2.isBST(bst2.getRoot())) {
			System.out.println("It is a BST tree---->bst2");
		} else {
			System.out.println("It is not a BST tree---->bst2");
		}
		
		bst2.LevelOrderWithComma();
	}

}
