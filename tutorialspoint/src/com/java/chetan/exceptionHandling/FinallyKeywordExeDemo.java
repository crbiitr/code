package com.java.chetan.exceptionHandling;

class UseFinally {
	public static void getException(int what) {
		
		int t;
		int arr[] = new int[4];
		try {
			switch(what) {
			case 0:
				t = 10/what;
				break;
			case 1:
				arr[5] = 1;
				break;
			case 2:
				return;
			}
			
		}catch(ArithmeticException e) {
			System.out.println("Can't divide by zero");
			return;
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Array Index Out Of Bound");
		}
		finally {
			System.out.println("Leaving try of getException()");
		}
	}
}
class FinallyKeywordExeDemo {
	public static void main(String args[]) {
		try {
			
			for (int i = 0; i < 3; i++) {
				UseFinally.getException(i);
			}
			
		} catch (Throwable e) {
			System.out.println("Inside catch of main()");
		}
		finally {
			System.out.println("will it run?");
		}
	}

}
