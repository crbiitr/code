/*
package com.java.selectiveQuestions;

*/
/**
 * @author Chetan Raj
 * @implNote
 * @since : 13/10/18
 *//*

public class Problem10 implements Runnable {
    public static Problem10 obj;
    private int data;

    public Problem10() {
        data = 10;
    }

    @Override
    public void run() {
        obj = new Problem10();
        obj.wait();
        obj.data += 20;

        System.out.println(obj.data);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Problem10());
        Thread thread2 = new Thread(new myThread());

        thread1.start();
        thread2.start();

        System.out.printf(" GFG - ");
    }
}

class myThread implements Runnable {
    @Override
    public void run() {
        Problem10.obj.notify();
    }
}
*/
