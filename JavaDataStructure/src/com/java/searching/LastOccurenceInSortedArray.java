package com.java.searching;

public class LastOccurenceInSortedArray {

	/**
	 * Question: 47
	 * Page: 270
	 * @param args
	 */
	public static void main(String[] args) {
		
		int array[] = {1,1,2,2,2,2,3,3,3,4,4,5,6,7,8,8,8,8,8,8,8,9};
		int index = getLastOccurence(array, 2);
		
		if(index == -1) {
			System.out.println("No is not present");
		} else {
			System.out.println("NO. found : " + array[index] + ",  At index : " + index);
		}
	}
	
	public static int getLastOccurence(int a[], int data) {
		
		int left = 0, right = a.length-1,mid;
		while(left <= right) {
			mid = left+(right-left)/2;
			
			if((right==mid && a[mid] == data) || (a[mid] == data && a[mid+1] > data) ) {
				return mid;
			} else if(a[mid] <= data) {
				left = mid +1;
			} else  {
				right = mid-1;
			}
		}
		return -1;
	}
}
