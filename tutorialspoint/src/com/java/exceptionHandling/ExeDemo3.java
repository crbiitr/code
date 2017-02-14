package com.java.exceptionHandling;

class ExeTest1 {
	static void fun() {
		int arr[] = new int[4];
		try {
			System.out.println("Before Exception");
			arr[7] = 8;
			System.out.println("After Exception");
			
		} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Array Index Out Of Bound Exception in fun()");
		}
	}
}

class ExeDemo3 {
	
	public static void main(String [] args) {
		try {
				System.out.println("In try block");
				ExeTest1.fun();
				System.out.println("This comment wont display");
		} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Array Index Out Of Bounds Exception Exception found");
		}
		System.out.println("Out of catch block");
	}

}
