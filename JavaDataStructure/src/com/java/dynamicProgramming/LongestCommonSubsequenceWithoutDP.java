package com.java.dynamicProgramming;

public class LongestCommonSubsequenceWithoutDP {

	public static void main(String[] args) {
		String x[] = {"A","B","C","B","D","A","B"};
		String y[] = {"B","D","C","A","B","A"};

		long startTime = System.currentTimeMillis();
		int lengthOfCommonSubsequence = LCSLength(x,0,x.length,y,0,y.length);
		long endTime = System.currentTimeMillis();

		System.out.println("Length of common subsequence is : " + lengthOfCommonSubsequence);
		System.out.println("StartTime :: " + startTime + "ms,  EndTime :: " + endTime + "ms.");
		System.out.println("Total time taken for calculating this length is : " + (endTime-startTime) + " ms.");
	}

	static int LCSLength(String x[], int i, int m, String y[], int j, int n) {

		if(i==m || j==n) {
			return 0;
		} else if(x[i]==y[j]) {
			return (1+LCSLength(x, i+1, m, y, j+1, n));
		} else {
			return Math.max(LCSLength(x, i+1, m, y, j, n), LCSLength(x, i, m, y, j+1, n));
		}
	}
	
	

}
