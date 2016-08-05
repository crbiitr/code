package com.java.threads;

class SuspendResumeStopThread implements Runnable{
	Thread thr;
	volatile boolean suspended;
	volatile boolean stoped;
	
	SuspendResumeStopThread(String name) {
		thr = new Thread(this, name);
		suspended = false;
		stoped = false;
		thr.start();
	}
	
	//Stop the thread
	synchronized void myStop() {
		stoped = true;
		//Following is for suspended thread to be stoped
		suspended = false;
		notify();
	}
	//Suspend the thread
	synchronized void mySuspend() {
		suspended = true;
	}
	//Resume the thread
	synchronized void myResume() {
		suspended = false;
		notify();
	}
	
	public void run() {
		System.out.println(thr.getName() + " Starting");
		try {
			for(int i = 1; i < 1000; i++ ) {
				System.out.print(i + "  ");
				if((i%10) == 0) {
					System.out.println();
					Thread.sleep(500);
				}
				//Used synchronized block to check suspend and stopped
				synchronized (this) {
					while (suspended) {
						wait();
					}
					if(stoped) break;
				}
			}
			
		} catch (InterruptedException e) {
			System.out.println(thr.getName() + " Interrupted");
		}
		System.out.println(thr.getName() + " Terminated");
	}
}

public class SuspendAndStopThread {
	public static void main(String [] args) {
		SuspendResumeStopThread thread = new SuspendResumeStopThread("MyThread");
		try {
			Thread.sleep(1000);
			
			thread.mySuspend();
			System.out.println("1Suspending Thread");
			Thread.sleep(1000);
			
			thread.myResume();
			System.out.println("1Resuming Thread");
			Thread.sleep(1000);
			
			thread.mySuspend();
			System.out.println("2Suspending Thread");
			Thread.sleep(1000);
			
			thread.myResume();
			System.out.println("2Resuming Thread");
			Thread.sleep(1000);

			/*thread.mySuspend();
			System.out.println("Stoping Thread");
			thread.myStop();*/
			thread.mySuspend();
			System.out.println("3Suspending Thread");
			Thread.sleep(1000);
			
			thread.myResume();
			System.out.println("3Resuming Thread");
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			System.out.println("Main Thread Interrupted");
		}
		
		try {
			thread.thr.join();
		} catch (InterruptedException e) {
			System.out.println("Main thread interrupted in join");
		}
		System.out.println("Main thread terminated");
	}

}
