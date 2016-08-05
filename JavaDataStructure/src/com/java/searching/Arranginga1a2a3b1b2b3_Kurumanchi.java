package com.java.searching;

public class Arranginga1a2a3b1b2b3_Kurumanchi {

	public static int count = 0;
	public static void main(String[] args) {

		String[] array = {"a1","a2","a3","a4","b1","b2","b3","b4"};
		System.out.print((++count) + " -->   ");printArray(array);
		Alternate(array,0,array.length-1);
		System.out.print((++count) + " -->   ");printArray(array);
		

	}
	
	static void swap(String a[], int l, int r) {
		String temp = a[l];
		a[l] = a[r];
		a[r] = temp;
	}

	static void printArray(String a[]) {
		for(String i:a) {
			System.out.print(i + "  ");
		}
		System.out.println();
	}

	static void Alternate(String []arr,int l,int r)
	{
		int c = (l+r)/2;
		int q = l + (l+c)/2;
		
		if(l==r) return;
		int i = q;
		for(int k=l; i<=c; i++,k++) {
			swap(arr,i,c+k);
			System.out.print((++count) + " -->   "); printArray(arr);
		}
		Alternate(arr, l, c);
		Alternate(arr, c+1, r);
	}

}
