package com.java.sorting;

public class MergeSortTest {

	public static void main(String[] args) {

		int Array[] = {3,5,2,8,9,1,23,4,5,22,45,78,74,29,11,20,38,82,44,0};
//		int Array[] = {3,5,2,8};
		int temp[] = new int[Array.length];
		System.out.println("Before MergSort -->");
		print(Array);
		MergeSort(Array, temp, 0, Array.length-1);
		System.out.println("After MergSort -->");
		print(Array);

	}
	
	static void MergeSort(int A[], int temp[], int left, int right) {
		int mid;
		if(left < right) {
			mid = (left+right)/2;
			MergeSort(A, temp, left, mid);
			MergeSort(A, temp, mid+1, right);
			Merge(A, temp, left, mid+1, right);
		}
	}
	
	static void Merge(int A[], int temp[], int left, int mid, int right) {
		int leftEnd = mid-1;
		int size = right-left+1;
		int currIndex = left;
		
		while((left <= leftEnd) && (mid <= right)) {
			if(A[left] <= A[mid]) {
				temp[currIndex] = A[left];
				left++;
				currIndex++;
			} else {
				temp[currIndex] = A[mid];
				mid++;
				currIndex++;
			}
		}
		
		while(left<=leftEnd) {
			temp[currIndex] = A[left];
			left++;
			currIndex++;
		}
		
		while(mid<=right) {
			temp[currIndex] = A[mid];
			mid++;
			currIndex++;
		}
		
		for(int i = 0; i<size; i++) {
			A[right] = temp[right];
			right--;
		}
	}

	
	static void print(int A[]) {
		for(int i : A) {
			System.out.print(i + "  ");
		}
		System.out.println();
	}

}
