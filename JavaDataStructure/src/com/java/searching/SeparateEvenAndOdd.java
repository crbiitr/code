package com.java.searching;

public class SeparateEvenAndOdd {

	public static void main(String[] args) {
		
		int array[] = {1,2,6,3,8,56,3,54,33,89,54,23,56,23,43,33,55,88};
		printArray(array);
		seprateEvenOdd(array);
		printArray(array);

	}

	static void seprateEvenOdd(int a[]) {
		
		for(int i=0, j=a.length-1; i<j;) {
			
			while(a[i]%2 == 0) 
				i++;
			
			while(a[j]%2 != 0) 
				j--;
			
			if(i<j) swap(a,i,j);
		}
	}
	
	static void swap(int a[], int l, int r) {
		int temp = a[l];
		a[l] = a[r];
		a[r] = temp;
	}
	
	static void printArray(int a[]) {
		for(int i:a) {
			System.out.print(i + "  ");
		}
		System.out.println();
	}
}
