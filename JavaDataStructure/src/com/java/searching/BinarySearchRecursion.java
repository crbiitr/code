package com.java.searching;

public class BinarySearchRecursion {

	public static void main(String[] args) {
		
		int array[] = {1,2,3,4,5,6,7,8,9,12,23,45,67,89};
		int SearchElementIndex = BinarySearch(array, 7, 0, array.length-1);
		if(SearchElementIndex == -1) {
			System.out.println("Element not present");
		} else {
			System.out.println("Element is present and index is :: " + SearchElementIndex);
		}

	}
	
	public static int BinarySearch(int a[], int data, int left, int right) {
		
		if(left <= right) {
			int mid = left + (right-left)/2;
			if(a[mid] == data) 
				return mid;
			else if(a[mid] < data) 
				return BinarySearch(a, data, mid+1, right);
			else 
				return BinarySearch(a, data, left, mid-1);
			
		} else return -1;
	}

}
