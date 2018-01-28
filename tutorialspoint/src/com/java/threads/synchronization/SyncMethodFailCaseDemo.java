package com.java.threads.synchronization;

/**
 * Created by user on 2/1/17.
 * This program shows the fail case of synchronized method.
 * We have to use static synchronization for resolving this issue.
 * Which is mentioned in commented code.
 */


class Table2{
/*
    synchronized void printTable(int n){//synchronized method
        for(int i=1;i<=5;i++){
            System.out.println(n*i);
            try{
                Thread.sleep(400);
            }catch(Exception e){System.out.println(e);}
        }
    }
    */
    /*
    // This method will not fail bcz of static keyword in method.
    // Now it will work for class level.
       synchronized static void printTable(int n){//synchronized method
        for(int i=1;i<=5;i++){
            System.out.println(n*i);
            try{
                Thread.sleep(400);
            }catch(Exception e){System.out.println(e);}
        }

    }
     */


    // This method will not fail bcz of static keyword in method.
    // Now it will work for class level.
    static void printTable(int n){//synchronized method
        synchronized (Table2.class) {
            for (int i = 1; i <= 5; i++) {
                System.out.println(n * i);
                try {
                    Thread.sleep(4000);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

    /*
        // This method will not fail bcz of static keyword in method.
    // Now it will work for class level.
    void printTable(int n){//synchronized method
        synchronized (Table2.class) {
            for (int i = 1; i <= 5; i++) {
                System.out.println(n * i);
                try {
                    Thread.sleep(400);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }
     */

}

public class SyncMethodFailCaseDemo{
    public static void main(String args[]) {
        final Table2 obj = new Table2();//one object Using by 2 threads
        final Table2 obj2 = new Table2();//one object Using by 2 threads

        Thread t1=new Thread(){
            public void run(){
                obj.printTable(1);
            }
        };
        Thread t2=new Thread(){
            public void run(){
                obj.printTable(10);
            }
        };

        Thread t3=new Thread(){
            public void run(){
                obj2.printTable(100);
            }
        };
        Thread t4=new Thread(){
            public void run(){
                obj2.printTable(1000);
            }
        };

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

