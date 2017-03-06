package com.java.tree;

/**
 * Created by chetan on 6/3/17.
 */import java.io.*;

import java.util.*;

class GFG {

    //tree node
    public static class Node {
        public int key;
        public Node left;
        public Node right;
        public Node(int new_key) {
            key=new_key;
        }
    }

    //used for building up a vertical map
    public static class VerticalMap {
        public int min_index;
        //the begining index of the map
        public Map<Integer,List<Integer>> m;
        public VerticalMap() {
            min_index=0;
            m=new HashMap<Integer,List<Integer>>();
        }

        public void addIntoMap(int index,int key) {
            List<Integer> list;
            if(!m.containsKey(index)) {
                list=new ArrayList<Integer>();
            }
            else {
                list=m.get(index);
            }
            list.add(key);
            m.put(index,list);
        }
    }

    public static void getVerticalMapFromTree(Node root,int index,VerticalMap vm) {

        //if it is empty, return
        if(root==null)return;

        //push the vertical node into vm with its index.
        vm.addIntoMap(index,root.key);

        if(index<vm.min_index) {
            vm.min_index=index;
        }
        getVerticalMapFromTree(root.left,index-1,vm);
        getVerticalMapFromTree(root.right,index+1,vm);

    }
    public static void printverticalorder(VerticalMap vm) {
        int size=vm.m.size();
        int start=vm.min_index;
        for(int i=start; i<size;i++) {
            List<Integer> list=vm.m.get(i);
            if(list!=null){
                for(int j=0; j<list.size(); j++) {
                    System.out.print(list.get(j)+"  ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[]args){
        VerticalMap vm=new VerticalMap();
        Node root=new Node(1);                             //                     1
        root.left=new Node(2);                             //                   /   \
        root.right=new Node(3);                            //                 2       3
        root.left.left=new Node(4);                        //               /   \    /  \
        root.left.right=new Node(5);                       //             4      5  6     7
        root.right.left=new Node(6);                       //                        \     \
        root.right.right=new Node(7);                      //                         8     9
        root.right.left.right=new Node(8);
        root.right.right.right=new Node(9);
        getVerticalMapFromTree(root,0,vm);
        System.out.print("vertical order traversal is\n");
        printverticalorder(vm);

    }

}
