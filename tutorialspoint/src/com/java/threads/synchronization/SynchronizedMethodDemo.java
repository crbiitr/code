package com.java.threads.synchronization;

/**
 * Created by user on 2/1/17.
 */

//Program of synchronized method by using annonymous class
class Table1{
    synchronized void printTable(int n){//synchronized method
        for(int i=1;i<=5;i++){
            System.out.println(n*i);
            try{
                Thread.sleep(400);
            }catch(Exception e){System.out.println(e);}
        }

    }
}

public class SynchronizedMethodDemo{
    public static void main(String args[]){
        final Table1 obj = new Table1();//only one object

        Thread t1=new Thread(){
            public void run(){
                obj.printTable(5);
            }
        };
        Thread t2=new Thread(){
            public void run(){
                obj.printTable(100);
            }
        };

        t1.start();
        t2.start();
    }
}
