package com.java.threads;

//Here we are sysnchronizing the method
/*class SumArray {
	private int sum;
	
	synchronized int sumArray(int a[]) {
		System.out.println(" In sumArray method ");
		sum = 0;
		for (int i =0; i< a.length; i++) {
			sum += a[i];
			System.out.println("Running Total for  " + Thread.currentThread().getName() + "  is  " + sum);
		}
		try {
			Thread.sleep(10);
		}catch (InterruptedException exc) {
			System.out.println("Thread is interrupted");
		}
		return sum;
	}
}

class MyThreads implements Runnable {
	
	Thread thr;
	int a[];
	static SumArray sa = new SumArray();
	int answer;
	
	public MyThreads(String name, int [] args) {
		thr = new Thread(this, name);
		a = args;
		thr.start();
	}
	
	public void run() {
		int sum;
		System.out.println(thr.getName() + "  starting  ");
		answer = sa.sumArray(a);
		System.out.println("Sum for " + thr.getName() + " is " +answer);
		System.out.println(thr.getName() + " is terminating ");
	}		
}

public class Sync {

	public static void main(String [] args) {
		int a[] = {1,2,3,4,5,6};
		int b[] = {1,2,3,4,5,6,7};
		MyThreads mt1 = new MyThreads("Child #1", a);
		MyThreads mt2 = new MyThreads("Child #2", b);
		MyThreads mt3 = new MyThreads("Child #3", b);
		
	}
}

*/
//Here we are using synchronized statement
class SumArray {
	private int sum;
	
	int sumArray(int a[]) {
		System.out.println(" In sumArray method ");
		sum = 0;
		for (int i =0; i< a.length; i++) {
			sum += a[i];
			System.out.println("Running Total for  " + Thread.currentThread().getName() + "  is  " + sum);
		}
		try {
			Thread.sleep(10);
		}catch (InterruptedException exc) {
			System.out.println("Thread is interrupted");
		}
		return sum;
	}
}

class MyThreads implements Runnable {
	
	Thread thr;
	int a[];
	static SumArray sa = new SumArray();
	int answer;
	
	public MyThreads(String name, int [] args) {
		thr = new Thread(this, name);
		a = args;
		thr.start();
	}
	
	public void run() {
		int sum;
		System.out.println(thr.getName() + "  starting  ");
		synchronized (sa) {
			answer = sa.sumArray(a);
		}
		System.out.println("Sum for " + thr.getName() + " is " +answer);
		System.out.println(thr.getName() + " is terminating ");
	}		
}

public class Sync {

	public static void main(String [] args) {
		int a[] = {1,2,3,4,5,6};
		int b[] = {1,2,3,4,5,6,7};
		MyThreads mt1 = new MyThreads("Child #1", a);
		MyThreads mt2 = new MyThreads("Child #2", b);
		MyThreads mt3 = new MyThreads("Child #3", b);
		
		/*try {
			mt1.thr.join();
			mt2.thr.join();
			mt3.thr.join();
			
		} catch(InterruptedException exc) {
			System.out.println("Main Thread Interrupted");
		}*/
	}
}

