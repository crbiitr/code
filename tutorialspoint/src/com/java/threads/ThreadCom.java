package com.java.threads;

class TickTock {
	synchronized void tick(boolean running) {
		if(!running) {
			notify();
			return;
		}
	
		System.out.print(" Tick ");
		notify();
		try {
			wait();
			Thread.sleep(1000);
		} catch (InterruptedException exc) {
			System.out.println(" Thread Interrupted. ");
		}
	}
	
	synchronized void tock(boolean running) {
		if(!running) {
			notify();
			return;
		}
		System.out.println("Tock ");
		notify();
		try {
			wait();
			Thread.sleep(1000);
		} catch(InterruptedException exc) {
			System.out.println("Thread is Interrupted. ");
		}
	}
}

class MyThreadss implements Runnable {
	TickTock tito;
	Thread thrd;
	
	public MyThreadss(String name, TickTock tt) {
		thrd = new Thread(this, name);
		tito = tt;
		thrd.start();
	}
	
	public void run() {
		if(thrd.getName().compareTo("Tick") == 0) {
			for(int i=0; i<5; i++) 
				tito.tick(true);
			tito.tick(false);
		} else {
			for(int i=0; i<5; i++) 
				tito.tock(true);
			tito.tock(false);
		}
	}
}

public class ThreadCom {

	public static void main(String [] args) {
		TickTock tt = new TickTock();
		MyThreadss mt1 = new MyThreadss("Tick", tt);
		MyThreadss mt2 = new MyThreadss("Tock", tt);
		
//		try {
//			mt1.thrd.join();
//			mt2.thrd.join();
//		} catch(InterruptedException exc) {
//			System.out.println(" Main Thread is Interrupted ");
//		}
	}
}
