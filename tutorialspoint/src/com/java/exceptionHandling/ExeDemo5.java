package com.java.exceptionHandling;

class ThrowExceptionText {
	
	public static void fun() {
		
		int array1[] = {1,2,3,4,5,6,7};
		int array2[] = {0,2,3,4,0};
		for (int i = 0; i < array1.length; i++) {
			
			try {
				System.out.println("Inside try of fun()");
				System.out.println(array1[i]+" / "+array2[i]+" is "+array1[i]/array2[i]);
			} catch (ArithmeticException e) {
				
				System.out.println("Arithmetic Exception found");	
			} catch(ArrayIndexOutOfBoundsException aiob) {
				
				System.out.println("Some Exception Occur");
				throw new ArrayIndexOutOfBoundsException();
			}
		}
	}
}

class ExeDemo5 {

	public static void main(String [] args) {
		try {
			System.out.println("Inside try of main()");
			ThrowExceptionText.fun();
		} catch (ArrayIndexOutOfBoundsException e) {

			System.out.println("Inside catch of main()");
			e.printStackTrace();
		}
	}
}
