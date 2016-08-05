package com.java.threads;

class RunnableClass3 extends Thread {
//	public int x;
	public static int x;
	
	public RunnableClass3(String name) {
		super(name);
		x = 1;
		start();
	}
	
	public void run() {
		System.out.println(getName() + "  is Started.");
		try {
			do {
				System.out.println("In " + getName() + " and x is :: " + x);
				Thread.sleep(1000);
				x++;
				System.out.println("X is :: " + x);
			} while (x<=10);
		} catch (InterruptedException e) {
			System.out.println(getName() + " interrupted");
		}
		
		System.out.println("Thread "  + getName() + "  END ");
	}
}

public class Demo3 {

	public static void main(String [] args) {
		RunnableClass3 obj1 = new RunnableClass3("CHETAN");
		RunnableClass3 obj2 = new RunnableClass3("RATAN");
		RunnableClass3 obj3 = new RunnableClass3("KARAN");
		RunnableClass3 obj4 = new RunnableClass3("HEMANT");
		
		do {
			System.out.println(Thread.currentThread().getName() + "  is running.");
			try {
//				System.out.println("In " + Thread.currentThread().getName() + " Thread.");
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + " interrupted");
			}
			
		} while (obj4.x < 11);
		System.out.println("Main thread terminated");
	}
}
