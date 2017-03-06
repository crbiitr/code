package com.java.threadPool.threadPoolUsingBlockingQueue;

/**
 * Created by chetan on 3/3/17.
 */
public class App {
    public static void main(String[] args) {
        ThreadPool threadPool =  new ThreadPool(7);
        for(int i=0;i<7;i++){
            Task task =  new Task(i+1);
            threadPool.execute(task);
        }
    }
}