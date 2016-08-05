package com.java.dynamicProgramming;
//This program is not working
public class LongestPelidromSubsequence {

	public static void main(String[] args) {

		String a = "GEEKS FOR GEEKS";
		char[] A = a.toCharArray();
		int len = getLongestPalindromSubsequence(A, A.length);
		System.out.println(len);

	}

	public static int getLongestPalindromSubsequence(char[] a, int n) {

		int max = 0;
		for(int i=0;i<n;i++) {
			int tempLeft = i, tempRight = i, tempsum = 0;
			for(int j=i+1;j<n;j++) {

				int left = i, right=j;
				int innerMax = 0;
				
				while(left>=0 && right<n) {
					if(left<tempLeft && tempRight<right) {
						innerMax = tempsum;
					}
					System.out.println(" \nloop1-->     L=" + left + " ," + "R=" + right + 
							", tempLeft=" + tempLeft + ", tempRight=" + tempRight + ", tempSum=" + tempsum);
					if(a[left]==a[right]) {

						System.out.print(" \nloop1-->i=" + i +", L=" + left + " ," + "R=" + right + " ," + "LV=" + a[left] + " ," + "LV=" + a[right]);
						tempLeft = left;
						tempRight = right;
						innerMax += 2;
						tempsum = innerMax;
						left--;
						right++;
						System.out.println(" ,iM=" + innerMax);
						
					}else {
						left--;
					}

				}
				if(innerMax>max) {
					max = innerMax;
				}
				System.out.println("Max=" + max);
			}
		}
		return max;
	}

}
