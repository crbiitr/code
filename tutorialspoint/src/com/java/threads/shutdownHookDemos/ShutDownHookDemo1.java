package com.java.threads.shutdownHookDemos;

/**
 * Created by chetan on 10/1/18.
 * //Not able to understand this example
 */
public class ShutDownHookDemo1 extends Thread{
    public void run(){
        System.out.println("shut down hook task completed..");
    }
}

class TestShutdown1{
    public static void main(String[] args)throws Exception {

        System.out.println("Starting the Main process----->");
        Runtime r=Runtime.getRuntime();
        System.out.println("Adding ShutDownHookDemo1 thread");
        r.addShutdownHook(new ShutDownHookDemo1());
        System.exit(0);

        System.out.println("Now main sleeping... press ctrl+c to exit");
        try{Thread.sleep(5000);}catch (Exception e) {}
    }
}