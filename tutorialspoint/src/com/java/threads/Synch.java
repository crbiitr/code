package com.java.threads;

public class Synch {
	
	public static void main(String[] args) {

		Callme target = new Callme();
		Caller ob1 = new Caller(target, "Hello");
		Caller ob2 = new Caller(target, "Synchronised");
		Caller ob3 = new Caller(target, "World");
		System.out.println("Current Thread in main :: " + Thread.currentThread());
		System.out.println(" Thread Count :: " + Thread.activeCount());
		try {
			System.out.println("\nCurrent Thread in try block :: " + ob1.t.currentThread());
			ob1.t.join();
			ob2.t.join();
			ob3.t.join();
		} catch(InterruptedException e) {
			System.out.println("Main class Interrupted");
		}
		
	}
}
