package com.java.recursion;

public class IsArraySortedUsingRecursion {


	public static void main(String[] args) {
		
		int array[] = new int []{1,2,3,4,5,6,7,8,2};
		boolean sorted = isSorted(array,0,array.length);
		if(sorted) {
			System.out.println("Sorted");
		} else {
			System.out.println("Not Sorted");
		}
	}

	public static boolean isSorted(int []a, int i, int n) {
		if(i == n-1) return true;
		
		if(a[i] <= a[i+1]) { 
			return isSorted(a,i+1,n);
		} else {
			return false;	
		}
	}
}
