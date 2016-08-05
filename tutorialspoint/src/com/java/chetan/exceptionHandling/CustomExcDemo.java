package com.java.chetan.exceptionHandling;

class NonIntResultException extends Exception {
	int a,b;
	public NonIntResultException(int i, int j) {
		a=i;
		b=j;
	}
	public String toString() {
		return "result of " + a + " / " + b + " is not Integer";
	}
}

class CustomExcDemo {
	public static void main(String [] args) {
		int arr1[] = {4, 8, 15, 32, 64, 127, 256, 512};
		int arr2[] = { 2, 0, 4, 4, 0, 8 };
		
		for (int i = 0; i < arr1.length; i++) {
			try {
				if((arr1[i]%2) != 0) {
					throw new NonIntResultException(arr1[i], arr2[i]);
				}
				System.out.println(arr1[i] + " / " + arr2[i] + " = " + arr1[i]/arr2[i]);
			} catch (ArithmeticException e) {
				System.out.println("Can't divide by Zero!");
			} catch (IndexOutOfBoundsException e) {
				System.out.println("No matching element found.");
			} catch (NonIntResultException e) {
				System.out.println("case1------------------>");
				System.out.println(e);
			}
		}
	}

}
