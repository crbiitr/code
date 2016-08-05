package com.java.dynamicProgramming;

public class LongestCommonSubsequence {


	public static void main(String[] args) {
		String x[] = {"A","B","C","B","D","A","B"};
		String y[] = {"B","D","C","A","B","A"};
		
		int LCS[][] = new int[x.length+1][y.length+1];
		String[] LCS_String = new String[x.length];
		long startTime = System.currentTimeMillis();
		int lengthOfCommonSubsequence = LCSLength(x,x.length,y,y.length,LCS);
		long endTime = System.currentTimeMillis();
		
		System.out.println("Length of common subsequence is : " + lengthOfCommonSubsequence);
		System.out.println("Total time taken for calculating this length is : " + (endTime-startTime) + " ms.");
		int index = GetLCSString(LCS, x, x.length, y, y.length, LCS_String);
		PrintArray(LCS_String, index);
		System.out.println("\nLCS Matrix is :: ");
		Print2DMatrix(LCS, x.length+1, y.length+1);
	}
	
	static int LCSLength(String x[], int m, String y[], int n, int LCS[][]) {
		
		for(int i=0; i<=m; i++) {
			LCS[i][n]=0;
		}
		for(int j=0; j<=n; j++) {
			LCS[m][j]=0;
		}
		
		for(int i=m-1;i>=0;i--) {
			for(int j=n-1;j>=0;j--) {
				LCS[i][j]=LCS[i+1][j+1];
				
				if(x[i]==y[j]) LCS[i][j]++;
				
				if(LCS[i][j+1]>LCS[i][j]) {
					LCS[i][j]=LCS[i][j+1];
				} else if(LCS[i+1][j]>LCS[i][j]) {
					LCS[i][j]=LCS[i+1][j];
				}
			}
		}
		
		return LCS[0][0];
	}
	
	static int GetLCSString(int LCS[][],String x[], int m, String y[], int n, String LCS_String[]) {
		
		int i=0,j=0,index=0;
		while(i<m && j<n) {
			if(x[i]==y[j]) {
				LCS_String[index] = x[i];
				i++;j++;index++;
			} else if(LCS[i+1][j] > LCS[i][j+1]) {
				i++;
			} else {
				j++;
			}
		}
		return index;
	}
	
	static void PrintArray(String arr[], int n) {
		for(int i=0;i<n;i++) {
			System.out.print("  " + arr[i]);
		}
		System.out.println();
	}
	
	static void Print2DMatrix(int matrix[][], int m, int n) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print( "  " + matrix[i][j]);
			}
			System.out.println();
		}
	}

}
