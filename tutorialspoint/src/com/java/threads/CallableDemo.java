package com.java.threads;

import java.util.concurrent.*;

/**
 * Created by user on 12/17/16.
 */
public class CallableDemo implements Callable<String> {

    private static final int THREAD_POOL_SIZE = 2;

    // Method where the thread execution takes place
    @Override
    public String call() {
        return Thread.currentThread().getName() + " executing...";
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // Create a pool of two threads
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        Future<String> future1 = executor.submit(new CallableDemo());
        Future<String> future2 = executor.submit(new CallableDemo());

        System.out.println(Thread.currentThread().getName() + "Executing...");

        //asynchronously get from the worker threads
        System.out.println(future1.get());
        System.out.println(future2.get());
        
        executor.shutdown();

    }
}
