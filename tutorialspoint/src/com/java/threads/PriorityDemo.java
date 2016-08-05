package com.java.threads;

class Priority implements Runnable{
	int count;
	Thread thr;
	
	static boolean stop = false;
	static String currentName;
	
	Priority(String name) {
		thr = new Thread(this,name);
		count = 0;
		currentName = name;
	}
	
	public void run() {
		System.out.println(thr.getName() + " Starting " );
		do {
			count++;
			if( currentName.compareTo(thr.getName()) != 0) {
				currentName = thr.getName();
				System.out.println("In " + thr.getName() + " and count is : " + count );
			}
		} while(stop == false && count < 10000000);
		stop = true;
		System.out.println("\n " + thr.getName() + " Terminating ");
	}
}

public class PriorityDemo {

	public static void main(String [] args) {
		Priority mt1 = new Priority("High Priority");
		Priority mt2 = new Priority("Low Priority");
		
		mt1.thr.setPriority(Thread.NORM_PRIORITY +2);
		mt2.thr.setPriority(Thread.NORM_PRIORITY -2);
		
		mt1.thr.start();
		mt2.thr.start();
		
		try {
			mt1.thr.join();
			mt2.thr.join();
		} catch ( InterruptedException exc ) {
			System.out.println("Main Thread is interrupted");
		}

		System.out.println("Priority of mt1 object is :: " + mt1.thr.getPriority());
		System.out.println("Priority of mt2 object is :: " + mt2.thr.getPriority());
		System.out.println("\nHigh Priority thread counted to " + mt1.count);
		System.out.println("\nLow Priority thread counted to " + mt2.count);
	}
}
