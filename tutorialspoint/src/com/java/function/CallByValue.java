package com.java.function;

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
    }
}
