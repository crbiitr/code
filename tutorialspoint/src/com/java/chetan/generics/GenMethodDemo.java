package com.java.chetan.generics;

public class GenMethodDemo {

	static <T ,V extends T> boolean arraysEqual(T[] x, V[] y) { // A Generic Method
		if(x.length != y.length) return false;
		for(int i = 0; i < x.length; i++) {
			if(x[i] != y[i]) return false;
		}
		return true;
	}

	public static void main(String[] args) {

		Integer nums[] = {1,2,3,4,5};
		Integer nums2[] = {1,2,3,4,5};
		Integer nums3[] = {1,2,3,4,5,3,4,5};
		Integer nums4[] = {1,4,5,4,6,7,9,3};
		
		if(arraysEqual(nums, nums))
			System.out.println("nums equals nums");
			if(arraysEqual(nums, nums2))
			System.out.println("nums equals nums2");
			if(arraysEqual(nums, nums3))
			System.out.println("nums equals nums3");
			if(arraysEqual(nums, nums4))
			System.out.println("nums equals nums4");

			// Create an array of Doubles
			Double dvals[] = { 1.1, 2.2, 3.3, 4.4, 5.5 };
			// This won't compile because nums and dvals are not of the same type.
			// if(arraysEqual(nums, dvals))
			// System.out.println("nums equals dvals");
	}

}
