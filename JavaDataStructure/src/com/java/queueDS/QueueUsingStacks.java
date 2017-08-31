package com.java.queueDS;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by chetan on 20/8/17.
 */
public class QueueUsingStacks {
    public static void main(String[] args) {

// Your MyQueue object will be instantiated and called as such:
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
//        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();

//        System.out.println("Param2:---> " + param_2);
        System.out.println("Param3:---> " + param_3);
        System.out.println("Param4:---> " + param_4);

    }

}

class MyQueue {

    Stack <Integer> stack1;
    Stack <Integer> stack2;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int front = -1;
        if(stack1.size()>0) {
            for(int i=stack1.size();i>0;i--) {
                stack2.push(stack1.pop());
            }
            front = stack2.pop();

            for(int i=stack2.size();i>0;i--) {
                stack1.push(stack2.pop());
            }
        }
        return front;                                 
    }

    /** Get the front element. */
    public int peek() {
        int front = -1;
        if(stack1.size()>0) {
            for(int i=stack1.size();i>0;i--) {
                stack2.push(stack1.pop());
            }
            front = stack2.peek();

            for(int i=stack2.size();i>0;i--) {
                stack1.push(stack2.pop());
            }
        }
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (stack1.size() > 0 ? false:true );
    }
}
