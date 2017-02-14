package com.java.exceptionHandling;

class ExeDemo4 {

	public static void main(String [] args) {
		int array1[] = {1,2,3,4,5,6,7};
		int array2[] = {0,2,3,4,0};
		for (int i = 0; i < array1.length; i++) {
			
			try {
				System.out.println("case1");
				System.out.println(array1[i]+" / "+array2[i]+" is "+array1[i]/array2[i]);
				System.out.println("case2");
			} catch (ArithmeticException e) {
				System.out.println("Arithmetic Exception found");	
			} catch(Throwable t) {
				System.out.println("Some Exception Occur");
			}
		}
	}
}
