package com.java.searching;

// all numbers occur even no. of time only one element occur odd no. of times.

public class FindOddOccuringNumber {

	public static void main(String[] args) {

		int array[] = {1,2,3,2,3,1,3};
		System.out.println("Odd Occuring No is : " + getOddOccuringNumber(array));
	}

	static int getOddOccuringNumber(int []array) {
		
		int x = 0;
		for(int i = 0; i < array.length; i++) {
			x^=array[i];
		}

		return x;

	}

}
