package com.java.threads.deadlockPrograms;

/**
 * Created by user on 2/1/17.
 */
public class DeadlockDemo1 {

    public static void main(String[] args) {
        final String resource1 = "Ratan";
        final String resource2 = "Chetan";

        Thread t1 = new Thread() {
            public void run() {
                synchronized (resource1) {
                    System.out.println("Thread1: locked resource1");
                    try {
                        Thread.sleep(1000);
                    } catch (Exception ex) {

                    }

                    synchronized (resource2) {
                        System.out.println("Thread1: locked resource2");
                    }
                }
            }
        };


        Thread t2 = new Thread() {
            public void run() {
                synchronized (resource2) {
                    System.out.println("Thread2: locked resource2");
                    try {
                        Thread.sleep(1000);
                    } catch (Exception ex) {

                    }

                    synchronized (resource1) {
                        System.out.println("Thread2: locked resource1");
                    }
                }
            }
        };

        t1.start();
        t2.start();
    }


}
