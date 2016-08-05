package com.java.searching;

public class MissingNumber {

	public static void main(String[] args) {
		
		int array[] = {1,2,3,5,6,4,8};
		System.out.println("missing no is : " + getMissingNumber(array));
	}

	static int getMissingNumber(int []array) {
		int x = 0,y = 0;
		for(int i = 0; i < array.length; i++) {
			x^=array[i];
		}
		
		for(int i = 1; i <= array.length+1; i++) {
			y^=i;
		}
		
		return x^y;
		
	}
}
