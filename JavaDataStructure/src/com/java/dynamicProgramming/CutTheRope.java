package com.java.dynamicProgramming;

public class CutTheRope {

	public static void main(String[] args) {
		int[] a = {0,1,5,8,9,10,17,17,20};
		
		getMaximumPrice(a);
		PrintArray(a);
	}
	
	public static void getMaximumPrice(int[]a) {
		for(int i=1;i<a.length;i++) {
			
			for(int j=i-1;j>=i/2;j--) {
				int secondIndex = i-j;
				int tempSum = a[j] + a[secondIndex];
				if(tempSum>a[i]) {
					a[i] = tempSum;
				}
			}
		}
	}
	public static void PrintArray(int[] c) {
		int count = 0;
		for(int a:c) {
			System.out.println("a[" + count++ +"]=" + a);
		}
		System.out.println();
	}

}
