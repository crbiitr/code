package com.java.threads;

class RunnableClass implements Runnable {
//	public int x;
	public static int x;
	public String threadName;
	
	public RunnableClass(String name) {
		x = 1;
		threadName = name;
	}
	
	public void run() {
		System.out.println(threadName + "  is Started.");
		try {
			do {
				System.out.println("In " + threadName + " and x is :: " + x);
				Thread.sleep(1000);
				x++;
				System.out.println("X is :: " + x);
			} while (x<=10);
		} catch (InterruptedException e) {
			System.out.println(threadName + " interrupted");
		}
		
		System.out.println("Thread "  + threadName + "  END ");
	}
}

public class Demo1 {

	public static void main(String [] args) {
		RunnableClass obj1 = new RunnableClass("CHETAN");
		RunnableClass obj2 = new RunnableClass("RATAN");
		RunnableClass obj3 = new RunnableClass("KARAN");
		RunnableClass obj4 = new RunnableClass("HEMANT");
		
		Thread threadObj1 = new Thread(obj1);
		Thread threadObj2 = new Thread(obj2);
		Thread threadObj3 = new Thread(obj3);
		Thread threadObj4 = new Thread(obj4);
		
		threadObj1.start();
		threadObj2.start();
		threadObj3.start();
		threadObj4.start();
		
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
