package com.java.dynamicProgramming;

public class Knapsack_0_1_withoutDP {

	public static void main(String[] args) {
		int val[] = {60,100,120};
		int wt[] = {10,20,30};
		
		int totalMaxValue = getMaxValue(50,wt,val, val.length);
		System.out.println("Max value is :: " + totalMaxValue);
	}
	
	static int getMaxValue(int W, int[] wt, int[] val, int n) {
		
		if(n==0||W==0) return 0;
		
		if(wt[n-1]>W) {
			return getMaxValue(W, wt, val, n-1);
		} else {
			return Math.max(val[n-1]+getMaxValue(W-wt[n-1], wt, val, n-1), getMaxValue(W, wt, val, n-1));
		}

	}

}
