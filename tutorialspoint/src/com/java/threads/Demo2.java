package com.java.threads;

class RunnableClass2 implements Runnable {
//	public int x;
	public static int x;
	Thread thrd;
	
	public RunnableClass2(String name) {
		thrd = new Thread(this,name);
		x = 1;
		thrd.start();
	}
	
	public void run() {
		System.out.println(thrd.getName() + "  is Started.");
		try {
			do {
				System.out.println("In " + thrd.getName() + " and x is :: " + x);
				Thread.sleep(1000);
				x++;
				System.out.println("X is :: " + x);
			} while (x<=10);
		} catch (InterruptedException e) {
			System.out.println(thrd.getName() + " interrupted");
		}
		
		System.out.println("Thread "  + thrd.getName() + "  END ");
	}
}

public class Demo2 {

	public static void main(String [] args) {
		RunnableClass2 obj1 = new RunnableClass2("CHETAN");
		RunnableClass2 obj2 = new RunnableClass2("RATAN");
		RunnableClass2 obj3 = new RunnableClass2("KARAN");
		RunnableClass2 obj4 = new RunnableClass2("HEMANT");
		
		do {
			System.out.println(Thread.currentThread().getName() + "  is running.");
			try {
//				System.out.println("In " + Thread.currentThread().getName() + " Thread.");
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + " interrupted");
			}
			
		} while (obj4.x < 11);
//		} while (obj1.thrd.isAlive() || obj2.thrd.isAlive() || obj3.thrd.isAlive() || obj4.thrd.isAlive());
//		NOTE: Both conditions produces the same output as before. The only difference is that it uses isAlive() to wait for the child threads to terminate. 
		System.out.println("Main thread terminated");
	}
}
