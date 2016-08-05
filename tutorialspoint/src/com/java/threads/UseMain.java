package com.java.threads;

public class UseMain {
	public static void main(String [] args) {
		Thread thrd;
		thrd = Thread.currentThread();
		System.out.println(thrd.getName() + "  Started ");
		System.out.println("Priority of " +thrd.getName() + " is " + thrd.getPriority());
		System.out.println();
		System.out.println("Setting the name and priority of main thread.");
		thrd.setName("Thread #1");
		thrd.setPriority(Thread.NORM_PRIORITY+3);
		System.out.println("Main thread is now called " + thrd.getName());
		System.out.println("Priority of main thread is now " + thrd.getPriority());
		
	}
}
