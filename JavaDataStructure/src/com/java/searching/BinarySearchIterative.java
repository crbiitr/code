package com.java.searching;

public class BinarySearchIterative {

	public static void main(String[] args) {
		
		int array[] = {1,2,3,4,5,6,7,8,9,12,23,45,67,89};
		int SearchElementIndex = BinarySearch(array, 0);
		if(SearchElementIndex == -1) {
			System.out.println("Element not present");
		} else {
			System.out.println("Element is present and index is :: " + SearchElementIndex);
		}

	}
	
	static int BinarySearch(int a[], int data) {
		if(a.length <= 0) return -1;
		int left = 0;
		int right = a.length-1;
		
		while(left <= right) {
			int mid = left + (right-left)/2;
			if(a[mid] == data) 
				return mid;
			else if(a[mid] > data) 
				left = mid+1;
			else 
				right = mid -1;
		}
		
		return -1;
	} 

}
