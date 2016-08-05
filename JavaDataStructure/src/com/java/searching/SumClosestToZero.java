package com.java.searching;

import java.util.Arrays;

public class SumClosestToZero {

	/**
	 * Question: 31, 
	 * Page: 266
	 * @param args
	 */
	public static void main(String[] args) {
		
		int array[] = {1,60,-10,70,-80,85};
		Arrays.sort(array); // Note: without sort this also will not work.
		GetClosestToZeroIndexs(array);
	}
	
	static void GetClosestToZeroIndexs(int a[]) {
		int sum = Integer.MAX_VALUE;
		int iTemp = -1, jTemp = -1;
		for(int i = 0,j = a.length-1; i<j;) {
			
			System.out.println(" Sum is : " + (a[i]+a[j]));
			if(Math.abs(a[i]+a[j]) < sum) {
				sum = Math.abs(a[i]+a[j]);
				iTemp = i;
				jTemp = j;
				
			}  
			if ((a[i]+a[j]) < 0) {
				i++;
			} else {
				j--;
			}
			
			
		}
		if(iTemp == -1 || jTemp == -1) {
			System.out.println("Elements did not found");
		} else
			System.out.println("Items Found : "+ a[iTemp] + " and " + a[jTemp] + " at indexs : " + iTemp + " and " + jTemp);
	}

}
