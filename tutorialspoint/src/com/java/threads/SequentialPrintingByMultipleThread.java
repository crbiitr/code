package com.java.threads;

/**
 * Created by user on 9/7/16.
 */
public class SequentialPrintingByMultipleThread extends Thread {
    static int i = 1;
    Object lock;

    SequentialPrintingByMultipleThread(Object lock) {
        this.lock = lock;
    }

    public static void main(String ar[]) {
        Object obj = new Object();
        // This constructor is required for the identification of wait/notify
        // communication
        SequentialPrintingByMultipleThread odd = new SequentialPrintingByMultipleThread(obj);
        SequentialPrintingByMultipleThread even = new SequentialPrintingByMultipleThread(obj);
        odd.setName("Odd");
        even.setName("Even");
        odd.start();
        even.start();
    }

    @Override
    public void run() {
        while (i <= 1000) {
            if (i % 2 == 0 && Thread.currentThread().getName().equals("Even")) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " - "
                            + i);
                    i++;
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (i % 2 == 1 && Thread.currentThread().getName().equals("Odd")) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " - "
                            + i);
                    i++;
                    lock.notify();
                }
            }
        }
    }
}
