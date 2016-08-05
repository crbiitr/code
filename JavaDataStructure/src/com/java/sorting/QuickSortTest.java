package com.java.sorting;

public class QuickSortTest {

	public static void main(String[] args) {

		int Array[] = {3,5,2,8,9,1,23,4,5,22,45,78,74,29,11,20,38,82,44,0};
		System.out.println("Before QuickSort -->");
		print(Array);
		quickSort(Array, 0, Array.length-1);
		System.out.println("After QuickSort -->");
		print(Array);


	}

	static void quickSort(int A[], int low, int high) {
		int pivot;
		if(low < high) {
			pivot = getPivotIndex(A, low, high);
			print(A);
//			if(pivot > 1)
				quickSort(A, low, pivot-1);
			
//			if(pivot+1 < high)
				quickSort(A, pivot+1, high);
		}
	}
	
	static int getPivotIndex(int A[], int low, int high) {
		int pivotItem = A[low];
		int right = high;
		int left = low;
		while(low < high) {
			
			while((low < right) && (A[low] <= pivotItem)) low++;
			while((high >left) && (A[high] >= pivotItem)) high--;
			
			if(low < high) swap(A,low,high);
		}
		
		A[left] = A[high];
		A[high] =  pivotItem;
		
		return high;
	}
	
	static void swap(int A[], int l, int r) {
		int temp = A[l];
		A[l] = A[r];
		A[r] = temp;
	}
	
	static void print(int A[]) {
		for(int i : A) {
			System.out.print(i + "  ");
		}
		System.out.println();
	}
}
