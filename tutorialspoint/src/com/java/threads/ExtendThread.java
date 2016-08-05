package com.java.threads;

class NewThreads extends Thread {
	Thread t;
	public NewThreads() {
		// TODO Auto-generated constructor stub
		//super(this); Use super constructor then you don't need to define the Thread t
		t = new Thread(this, "Demo Thread ");
		System.out.println("Child Thread :: " + t);
		t.start();
		t.setName("Chetan");
		System.out.println("Changed Thread Name :: " + t.getName());
	}
	public void run() {
		try {
			for (int i = 5; i > 0 ; i--) {
				System.out.println("Child Thread :: " + i);
				Thread.sleep(500);
			}
		} catch(InterruptedException e) {
			System.out.println("Child Thread Interrrupt " + e);
		}
		System.out.println("Existing Child Thread ");
	}
}


public class ExtendThread {

	public static void main(String[] args) {
		new NewThreads();
		try {
			for(int i=6; i > 0; i--) {
				System.out.println("Main Thread :: " + i);
				Thread.sleep(1000);
			}
		} catch ( InterruptedException e) {
			System.out.println("Main Thread Exception " + e);
		}
		System.out.println("Main Thread Existing ");
	}

}
