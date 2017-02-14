package com.java.exceptionHandling;

class ExeDemo1 {
	
	public static void main(String [] args) {
		int arr[] = new int[5];
		try {
				System.out.println("In try block");
				arr[6] = 1;
				System.out.println("This comment wont display");
		} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Array Index Out Of Bounds Exception Exception found");
		}
		System.out.println("Out of catch block");
	}

}
