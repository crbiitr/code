package com.java.threadPool;

import java.util.concurrent.*;

/**
 * Created by chetan on 10/1/18.
 *
 * This not able to find out ExecutorService  library
 */
public class EasyThreadPoolByTpoint {
    public static void main(String[] args) {
        /*ExecutoService executor = Executors.newFixedThreadPool(5);//creating a pool of 5 threads
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker);//calling execute method of ExecutorService
        }
        executor.shutdown();
        while (!executor.isTerminated()) {   }

        */System.out.println("Finished all threads");
    }

}
