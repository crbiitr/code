package com.java.stackds;

import java.util.Stack;

/**
 * Created by chetan on 24/12/17.
 */
public class ArrayCanRepresentPreorderTraversalOfBinarySearchTree {
    public static void main(String[] args) {
        ArrayCanRepresentPreorderTraversalOfBinarySearchTree bst = new ArrayCanRepresentPreorderTraversalOfBinarySearchTree();
        int[] pre1 = new int[]{40, 30, 35, 80, 100};
        int n = pre1.length;
        if (bst.canRepresentBST(pre1) == true) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        int[] pre2 = new int[]{40, 30, 35, 20, 80, 100};
        int n1 = pre2.length;
        if (bst.canRepresentBST(pre2) == true) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public boolean canRepresentBST(int[] array) {
        int n  = array.length;
        Stack<Integer> stack = new Stack<>();

        int root = Integer.MIN_VALUE;
        for (int i = 0; i <n ; i++) {

            if (array[i] < root) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek()<array[i]) {
                root = stack.pop();
            }
            stack.push(array[i]);
        }
        return true;
    }
}
