package com.java.threads.synchronization;

import com.java.threads.ThreadClassDemo;

import java.util.HashMap;

/**
 * Created by chetan on 24/1/18.
 */

public class SyncStaticVsNonStaticLocking {
    public static final HashMap<Integer, Integer> map = new HashMap<>();
    public void function1() {
        try {
            System.out.println("In function1()---->1, going to sleep.");
            map.put(1,1);
            for (int i = 0; i < 10; i++) {
                System.out.print(i*10 + ",  ");
            }System.out.println();
            Thread.sleep(4000);
            System.out.println("In function1()---->1, awaking.");
        } catch (Exception e) {

        }
    }

    public void function2() {
        try {
            System.out.println("In function2()---->2, going to sleep.");
            map.put(2,2);
            for (int i = 0; i < 10; i++) {
                System.out.print(i*100 + ",  ");
            }System.out.println();
            Thread.sleep(4000);
            System.out.println("In function2()---->2, awaking.");
        } catch (Exception e) {

        }
    }

    synchronized public void function3() {
        try {
            System.out.println("In function3()---->3, going to sleep.");
            map.put(3,3);
            for (int i = 0; i < 10; i++) {
                System.out.print(i*1000 + ",  ");
            }System.out.println();
            Thread.sleep(4000);
            System.out.println("In function3()---->3, awaking.");
        } catch (Exception e) {

        }
    }

    synchronized public void function4() {
        try {
            System.out.println("In function4()---->4, going to sleep.");
            map.put(2,2);
            for (int i = 0; i < 10; i++) {
                System.out.print(i*10000 + ",  ");
            }System.out.println();
            Thread.sleep(4000);
            System.out.println("In function4()---->4, awaking.");
        } catch (Exception e) {

        }
    }

    static synchronized public void function5() {
        try {
            System.out.println("In function5()---->5, going to sleep.");
            map.put(3,3);
            for (int i = 0; i < 10; i++) {
                System.out.print(i*100000 + ",  ");
            }System.out.println();
            Thread.sleep(4000);
            System.out.println("In function5()---->5, awaking.");
        } catch (Exception e) {

        }
    }

    static synchronized public void function6() {
        try {
            System.out.println("In function6()---->6, going to sleep.");
            map.put(3,3);
            for (int i = 0; i < 10; i++) {
                System.out.print(i*1000000 + ",  ");
            }
            System.out.println();
            Thread.sleep(4000);
            System.out.println("In function6()---->6, awaking.");
        } catch (Exception e) {

        }
    }


    public static void main(String[] args) {
       final SyncStaticVsNonStaticLocking obj = new SyncStaticVsNonStaticLocking();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                obj.function1();
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                obj.function2();
            }
        };


        Thread t3 = new Thread() {
            @Override
            public void run() {
                obj.function3();
            }
        };

        Thread t4 = new Thread() {
            @Override
            public void run() {
                obj.function4();
            }
        };

        Thread t5 = new Thread() {
            @Override
            public void run() {
                obj.function5();
            }
        };

        Thread t6 = new Thread() {
            @Override
            public void run() {
                obj.function6();
            }
        };

        //Case 1
        //If one thread is running on Class level lock using synchronized, until first thread will not finish second thread can not run.
        /*t5.start();
        t6.start();*/

        //Case 2
        //If one thread is running on Object level lock using synchronized, until first thread will not finish second thread can not run.
        t3.start();
        t4.start();

        //Case 3
        /*t1.start();
        t2.start();*/

        //Case 4
        // Note: class level lock don't care for the object level lock both thread can run parallel.
        /*t1.start(); //Normal function
        t3.start(); //Object level lock
        t5.start(); //Class level lock
        */
    }
}
