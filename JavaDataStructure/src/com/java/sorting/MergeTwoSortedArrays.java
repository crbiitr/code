package com.java.sorting;

public class MergeTwoSortedArrays {


	public static void main(String[] args) {
		
		int B[] = {2,4,7,9,10,86,87,89};
		int A[] = new int[B.length+6];
		A[0] = 1;A[1] = 2;A[2] = 3;A[3] = 5;A[4] = 7;A[5] = 9;
		System.out.println("Print A");print(A);
		System.out.println("Print b");print(B);
		Merge(A, 6, B, B.length);
		System.out.println("\nA.length::  "+ A.length);
		System.out.println("Print A after merge ");print(A);
	}

	static void Merge(int A[], int m, int B[], int n) {

		int mTemp = m-1;
		int nTemp = n-1;
		int currIndex = m+n-1;
		
		while(currIndex >= 0 && mTemp >= 0 && nTemp >= 0) {
			if(A[mTemp] >= B[nTemp]) {
				A[currIndex] = A[mTemp];
				mTemp--;currIndex--;
			} else {
				A[currIndex] = B[nTemp];
				nTemp--;currIndex--;
			}
		}
		
		while(mTemp >= 0) {
			A[currIndex] = A[mTemp];
			mTemp--;currIndex--;
		}
		
		while(nTemp >= 0) {
			A[currIndex] = B[nTemp];
			nTemp--;currIndex--;
		}

	}

	static void print(int A[]) {
		for(int i : A) {
			System.out.print(i + "  ");
		}
		System.out.println();
	}
}
