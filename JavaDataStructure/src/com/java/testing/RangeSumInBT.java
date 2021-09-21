package com.java.testing;

import java.util.LinkedList;
import java.util.Queue;
//https://leetcode.com/problems/range-sum-of-bst/submissions/
public class RangeSumInBT {
    public static void main(String[] args) {

    }
    /*
        Your input: [10,5,15,3,7,null,18]
        low: 7
        high: 15
        Output: 32
    */
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int result = 0;
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            if(low<=tempNode.val && tempNode.val<=high) {
                result+=tempNode.val;
            }

            if(tempNode.left!=null) {
                queue.add(tempNode.left);
            }

            if(tempNode.right!=null) {
                queue.add(tempNode.right);
            }
        }
        return result;
    }
}


  //Definition for a binary tree node.
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
