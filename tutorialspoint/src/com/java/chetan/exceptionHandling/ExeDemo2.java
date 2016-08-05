package com.java.chetan.exceptionHandling;

class ExeTest {
	static void fun() {
		int arr[] = new int[4];
		System.out.println("Before Exception");
		arr[7] = 8;
		System.out.println("After Exception");
	}
}

class ExeDemo2 {
	
	public static void main(String [] args) {
		try {
				System.out.println("In try block");
				ExeTest.fun();
				System.out.println("This comment wont display");
		} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Array Index Out Of Bounds Exception Exception found");
		}
		System.out.println("Out of catch block");
	}

}
