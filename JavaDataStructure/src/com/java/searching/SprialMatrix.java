package com.java.searching;

public class SprialMatrix {

	public static void main(String [] args) {

		int a[][] = {
				{1,2,3,4,5},
				{6,7,8,9,10},
				{11,12,13,14,15}
		};
		doTheJob(a);

	}

	static void doTheJob(int [][]a) {
		int rEnd = a.length;
		int cEnd = a[0].length;

		int rStart = 0;
		int cStart = 0;
		int i;
		System.out.println(rStart + ",  " + rEnd + ",  " + cStart + ",  " + cEnd);
		while (rStart < rEnd && cStart < cEnd) {

			// Printing first row
			for(i = cStart; i < cEnd; i++) {
				System.out.print("  " + a[rStart][i]);
			}
			rStart++;

			// Printing first column
			for(i = rStart; i < rEnd; i++) {
				System.out.print("  " + a[i][cEnd-1]);
			}
			cEnd--;

			// Printing last row from remaining matrix
			if(rStart < rEnd) {
				for(i = cEnd-1; i >=cStart; i--) {
					System.out.print("  " + a[rEnd-1][i]);
				}
				rEnd--;

			}

			// Printing last Column from remaining matrix
			if(cStart < cEnd) {

				for(i = rEnd-1; i >=rStart; i--) {
					System.out.print("  " + a[i][cStart]);
				}
				cStart++;
			}

		}
	}

}
