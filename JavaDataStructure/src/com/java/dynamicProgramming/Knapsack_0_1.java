//Its DP Solution
package com.java.dynamicProgramming;

public class Knapsack_0_1 {

	public static void main(String[] args) {
		int val[] = {60,100,120};
		int wt[] = {10,20,30};
		
		int totalMaxValue = getMaxValue(val, val.length, wt, 50);
		System.out.println("Max value is :: " + totalMaxValue);
	}
	
	static int getMaxValue(int[] val, int n, int[] wt, int W) {
		int[][] k = new int[n+1][W+1];
		
		for(int i=0;i<=n;i++) {
			for(int w=0;w<=W;w++) {
				if(i==0||w==0) 
					k[i][w]=0;
				else if(wt[i-1]<=w)
					k[i][w]=Math.max(val[i-1]+k[i-1][w-wt[i-1]], k[i-1][w]);
				else
					k[i][w]=k[i-1][w];
			}
		}
		
		return k[n][W];
	}

}
