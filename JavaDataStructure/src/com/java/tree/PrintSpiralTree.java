package com.java.tree;

import java.util.Stack;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 2019-07-26
 */
public class PrintSpiralTree {

    public static void printSpiral(TreeNode root) {
        if(root==null) return;

        Stack<TreeNode> lToRStack = new Stack<>();
        Stack<TreeNode> rToLStack = new Stack<>();

        lToRStack.push(root);
        while (!lToRStack.isEmpty() || !rToLStack.isEmpty()) {
            while (!lToRStack.isEmpty()) {
                TreeNode node = lToRStack.pop();
                System.out.print(node.data + " ");

                if(node.right!=null) {
                    rToLStack.push(node.right);
                }
                if(node.left!=null) {
                    rToLStack.push(node.left);
                }
            }

            while (!rToLStack.isEmpty()) {
                TreeNode node = rToLStack.pop();
                System.out.print(node.data + " ");
                if(node.left!=null) {
                    lToRStack.push(node.left);
                }
                if(node.right!=null) {
                    lToRStack.push(node.right);
                }
            }
        }
    }
}
