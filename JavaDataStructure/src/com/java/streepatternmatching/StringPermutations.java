package com.java.streepatternmatching;

public class StringPermutations {
	public static void main(String[] args) {
		char[] c = {'a','b','c'};
		printPermutation(c, 0, c.length-1);
	}

	public static void printPermutation(char[] c, int i, int n) {

		if(i==n) {
			System.out.print("\ni=" + i + ", c[i]=" + c[i] + " :: ");
			PrintArray(c);
		} else {

			for(int j=i;j<=n;j++){
				System.out.print("\ni=" + i + ", j=" + j + ", c[i]=" + c[i] + ", c[j]=" + c[j] + "\n");
				swap(c,i,j);
				System.out.println("After 1st swap, i=" + i + ", j=" + j + ", c[i]=" + c[i] + ", c[j]=" + c[j] + "\n");PrintArray(c);
				printPermutation(c, i+1, n);
				swap(c,i,j);
				System.out.println("After Backtrac, i=" + i + ", j=" + j + ", c[i]=" + c[i] + ", c[j]=" + c[j] + "\n");PrintArray(c);
			}
		}
	}

	public static void swap(char[] c, int l, int r) {
		char temp = c[l];
		c[l] = c[r];
		c[r] = temp;
	}

	public static void PrintArray(char[] c) {
		for(char a:c) {
			System.out.print("  " + a);
		}
		System.out.println();
	}
}
