package com.java.dynamicProgramming;

public class MaximumSubMatrixOf1s {

	public static int Row = 6;
	public static int Col = 5;
	public static void main(String[] args) {

		int[][] matrix = {
				{0,1,1,0,1},
				{1,1,0,1,0},
				{1,1,1,1,0},
				{1,1,1,1,0},
				{1,1,1,1,1},
				{0,0,0,0,0}
		};

		getMaximumMatrix(matrix);
	}

	public static void getMaximumMatrix(int matrix[][]) {

		int row = matrix.length;
		int col = matrix[0].length;

		int l[][] = new int[row][col];

		for(int j=0;j<col;j++) {
			l[0][j] = matrix[0][j];
		}

		for(int j=0;j<row;j++) {
			l[j][0] = matrix[j][0];
		}
		for(int i=1;i<row;i++) {
			for(int j=1;j<col;j++) {
				if(matrix[i][j]==1) {
					l[i][j] = getMinimumOfThree(l[i-1][j-1],l[i][j-1],l[i-1][j]) + 1;
				} else {
					l[i][j] = 0;
				}
			}
		}
		
		printMatrix(l);

		int maxOfMatrix = 0, maxOf_i = 0, maxOf_j = 0;
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(l[i][j]>maxOfMatrix) {
					maxOfMatrix = l[i][j];
					maxOf_i = i;
					maxOf_j = j;
				}
			}
		}

		System.out.println("\n\n" + maxOfMatrix +" : "+maxOf_i+" : "+maxOf_j+ "\n\n");
		for(int i=maxOf_i;i>maxOf_i-maxOfMatrix;i--) {
			for(int j=maxOf_j;j>maxOf_j-maxOfMatrix;j--) {
				System.out.print("  " + matrix[i][j]);
			}
			System.out.println();
		}
	}
	public static int getMinimumOfThree(int one, int two, int three) {
		return (one<two)?(one<three?one:three):(two<three?two:three);
	}

	public static void printMatrix(int[][]l) {
		int row = l.length;
		int col = l[0].length;
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				System.out.print("  " + l[i][j]);
			}
			System.out.println();
		}
	}
}
