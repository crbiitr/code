package com.java.threads;


//this program is from 
//[Herbert_Schildt]_Java_A_Beginner’s_Guid

/*class MyThread implements Runnable{
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
				Thread.sleep(500);
				System.out.println("In " + thr.getName() + ", count is " + count);
				count++;
			}while(count<10);
			System.out.println(thr.getName() + "  Terminating");
			
		} catch(InterruptedException e) {
			System.out.println(thr.getName() + "  Interrupted  ");
		}
	}
}*/

public class JoinThreads {

	public static void main(String[] args) {

		System.out.println("In main thread");
		MyThread mt1 = new MyThread("Child #1");
		MyThread mt2 = new MyThread("Child #2");
		MyThread mt3 = new MyThread("Child #3");
		try {
			mt1.thr.join();
			System.out.println("Child #1 is joined");
			mt2.thr.join(3000);
			System.out.println("Child #2 is joined");
			mt3.thr.join();
			System.out.println("Child #3 is joined");
		} catch(InterruptedException e) {
			System.out.println("Main thread Interrupted");
		}
	}

}
