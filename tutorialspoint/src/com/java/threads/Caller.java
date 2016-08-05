package com.java.threads;

public class Caller implements Runnable{

	String msg;
	Callme target;
	Thread t;
	public Caller(Callme tar, String s) {
		target = tar;
		msg = s;
		t = new Thread(this);
		t.start();
	}
	
	public void run() {
		synchronized (target) {
			target.call(msg);
		}
	}
}
