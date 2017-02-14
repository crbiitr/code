package com.java.threads;

/**
 * Created by user on 12/1/16.
 */
public class PrintOddEvenUsingTwoThreads extends Thread {

    volatile static int i =1;
    Object lock;

    public static void main(String[] args) {
        Object obj = new Object();
        PrintOddEvenUsingTwoThreads even = new PrintOddEvenUsingTwoThreads(obj);
        PrintOddEvenUsingTwoThreads odd = new PrintOddEvenUsingTwoThreads(obj);
        even.setName("even");
        odd.setName("odd");
        even.start();
        odd.start();
    }

    public PrintOddEvenUsingTwoThreads(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        while(i<=10) {
            if ((i%2)==1 && Thread.currentThread().getName().equals("odd")) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() +" : "+ i);
                    i++;
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            if ((i%2)==0 && Thread.currentThread().getName().equals("even")) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() +" : "+ i);
                    i++;
                    lock.notify();
                }
            }

        }

    }

/*
//    It is also working
    @Override
    public void run() {
        while(i<=10) {
            if ((i%2)==1 && Thread.currentThread().getName().equals("odd")) {
                    System.out.println(Thread.currentThread().getName() +" : "+ i);
                    i++;

            }
            if ((i%2)==0 && Thread.currentThread().getName().equals("even")) {
                    System.out.println(Thread.currentThread().getName() +" : "+ i);
                    i++;
            }

        }
    }

    */

/*
    @Override
    public void run() {
        while(i<=10) {
            if ((i%2)==1 && Thread.currentThread().getName().equals("odd")) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() +" : "+ i);
                    i++;
*//*
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    *//*
                }
            }
            if ((i%2)==0 && Thread.currentThread().getName().equals("even")) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() +" : "+ i);
                    i++;
//                    lock.notify();
                }
            }

        }
    }

    */

}

