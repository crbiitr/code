package com.java.chetan.exceptionHandling;

/*class TimeTestingDemo {

	public static final long lenth = 100000000;
	public static void main(String [] args) {
		long stime = System.currentTimeMillis();
		
		int arr[] = new int[(int)lenth];
		try {
			for(int i = 0; i<=lenth; i++) {
				arr[i] = i;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Array Index out of bound");
		}
		long etime = System.currentTimeMillis();
		System.out.println("total time is :: " + (etime - stime));
	}
}*/

/*class TimeTestingDemo {

	public static final long lenth = 100000000;
	public static void main(String [] args) {
		long stime = System.currentTimeMillis();
		
		int arr[] = new int[(int)lenth];
		
		for(int i = 0; i<=lenth; i++) {
			try {
					arr[i] = i;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Array Index out of bound");
			}
		}
		long etime = System.currentTimeMillis();
		System.out.println("total time is :: " + (etime - stime));
	}
}*/

class TimeTestingDemo {

	public static final long lenth = 100000000;
	public static void main(String [] args) {
		long stime = System.currentTimeMillis();
		int i;
		int arr[] = new int[(int)lenth];
		try {
			 i = 1;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Array Index out of bound");
		}
		long etime = System.currentTimeMillis();
		System.out.println("total time is :: " + (etime - stime));
	}
}