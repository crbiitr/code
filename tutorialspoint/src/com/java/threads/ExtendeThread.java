package com.java.threads;

//this program is from 
//[Herbert_Schildt]_Java_A_Beginner’s_Guid

class MyThread implements Runnable{
	int count;
	Thread thr;
	MyThread(String name) {
		thr = new Thread(this, name);
		count = 0;
		thr.start();
	}
	
	public void run() {
		System.out.println(thr.getName() + "  Starting  ");
		try {
			do {
				Thread.sleep(1000);
				System.out.println("In " + thr.getName() + ", count is " + count);
				count++;
			}while(count<10);
			System.out.println(thr.getName() + "  Terminating");
			
		} catch(InterruptedException e) {
			System.out.println(thr.getName() + "  Interrupted  ");
		}
	}
}

public class ExtendeThread {

	public static void main(String[] args) {

		System.out.println("In main thread");
		MyThread mt2 = new MyThread("Child #2");
		MyThread mt1 = new MyThread("Child #1");
		MyThread mt3 = new MyThread("Child #3");
		try {
			do {
				System.out.print(".");
				Thread.sleep(100);
			} while(mt1.count < 10 || mt2.count < 10 || mt3.count < 10);
//		  while(mt1.thr.isAlive() || mt2.thr.isAlive() || mt3.thr.isAlive())
			System.out.println("Main thread Ending");
		} catch(InterruptedException e) {
			System.out.println("Main thread Interrupted");
		}
	}

}







/*class MyThread extends Thread{
	int count;
	MyThread(String name) {
		super(name);
		count = 0;
		start();
	}
	
	public void run() {
		System.out.println(getName() + "  Starting  ");
		try {
			do {
				sleep(500);
				System.out.println("In " + getName() + ", count is " + count);
				count++;
			}while(count<10);
			
		} catch(InterruptedException e) {
			System.out.println(getName() + "  Interrupted  ");
		}
	}
}

public class ExtendeThread {

	public static void main(String[] args) {

		System.out.println("In main thread");
		MyThread mt = new MyThread("chetan");
		try {
			do {
				System.out.print(".");
				Thread.sleep(100);
			} while(mt.count < 10);
			System.out.println("Main thread Ending");
		} catch(InterruptedException e) {
			System.out.println("Main thread Interrupted");
		}
	}

}
*/