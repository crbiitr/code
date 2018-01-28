package com.java.function;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by chetan on 26/2/17.
 */

class Operation {
    int data = 50;
    void change(int data) {
        // this.data = data + 100;
        data = data + 100;
    }

    void change(Operation op) {
        op.data = op.data + 100;
    }
    void changeReference(List list) {
        System.out.println("Old hashCode of list: " + list.hashCode());
        printList(list);
        list = new LinkedList();
        list.add(2);
        System.out.println("New hashCode of list: " + list.hashCode());
        printList(list);
    }

    void printList(List l) {
        l.toString();
    }

}
public class CallByValue {
    public static void main(String args[]){
        Operation op=new Operation();

        System.out.println("before change "+op.data);
        op.change(500);
        System.out.println("after change "+op.data);


        // changing data member using reference variable
        Operation op1=new Operation();
        System.out.println("before change "+op1.data);
        op1.change(op1);//passing object
        System.out.println("after change "+op1.data);

        List<Integer>  list = new LinkedList();
        list.add(1);
        System.out.println("Main method Old hashCode of list: " + list.hashCode());
        op.printList(list);
        op.changeReference(list);
        System.out.println("Main method New hashCode of list: " + list.hashCode());
        op.printList(list);

    }

}

