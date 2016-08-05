package com.java.searching;

public class BitonicSearch {

	/**
	 * Question: 37
	 * Page: 268
	 * @param args
	 */
	public static void main(String[] args) {
		
		int array[] = {15,16,19,20,25,24,22,18,14,13,10,9,5,3,2,1};
		System.out.println("Size of array is : " + array.length);
		System.out.println("Value return by method : " + GetLastIncreasingIndex(array));
	}
	
	static int GetLastIncreasingIndex(int a[]) {
		int index = -1;
		
		int first = 0, last = a.length-1;
		int mid;
		while(first <= last) {
			
			if(first == last) 
				return a[first];
			else if(first == last-1) 
				return Math.max(a[first], a[last]);
			else {
				mid = first+(last-first)/2;
				System.out.println("First : " + first + ", Last : " + last + ", and Mid :" + mid);
				if(a[mid-1] < a[mid] && a[mid] > a[mid+1]) {
					return a[mid];
				} else if(a[mid-1] < a[mid] && a[mid] < a[mid+1]) {
					first = mid +1;
				} else if(a[mid-1] > a[mid] && a[mid] > a[mid+1]) {
					last = mid -1;
				} else {
					return index;
				}
				
			}
			
		}
		
		return index;
	}

}
