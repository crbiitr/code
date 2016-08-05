package com.java.threads;


class NewThread implements Runnable {
	Thread t;
	public NewThread() {
		// TODO Auto-generated constructor stub
		t = new Thread(this, "Demo Thread ");
		System.out.println("Child Thread :: " + t);
		t.start();
	}
	public void run() {
		try {
			for (int i = 5; i>0 ; i--) {
				System.out.println("Child Thread :: " + i);
				Thread.sleep(500);
			}
		} catch(InterruptedException e) {
			System.out.println("Child Thread Interrrupt " + e);
		}
		System.out.println("Existing Child Thread ");
	}
	
}


public class ThreadDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new NewThread();
		try {
			for(int i=6; i > 0; i--) {
				System.out.println("Main Thread :: " + i);
				System.out.println(" Printing thread" + Thread.class.getName() );
				Thread.sleep(1000);
			}
			
		} catch ( InterruptedException e) {
			System.out.println("Main Thread Exception " + e);
		}
		System.out.println("Main Thread Existing ");

	}

}
