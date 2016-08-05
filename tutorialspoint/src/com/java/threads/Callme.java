package com.java.threads;

public class Callme {

	public void call (String msg) {
		System.out.print("[" + msg + "-->" + Thread.class.getName());
		try {
			Thread.sleep(1000);
			System.out.println("   \nCurrent Thread in Callme :: " + Thread.currentThread());
			
		} catch(InterruptedException e) {
			System.out.println("Callme Interrupted");
		}
		System.out.println("]");
	}
}
