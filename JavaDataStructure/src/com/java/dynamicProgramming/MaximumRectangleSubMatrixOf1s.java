package com.java.dynamicProgramming;

import java.util.Stack;

public class MaximumRectangleSubMatrixOf1s {

	public static int Row = 6;
	public static int Col = 5;
	public static void main(String[] args) {

		int[][] matrix = {
				{0,1,1,0,1},
				{1,1,0,1,0},
				{1,1,1,1,0},
				{1,1,1,1,0},
				{1,1,1,1,1},
				{0,0,0,1,0}
		};

		getMaximumMatrix(matrix);
	}
	public static void getMaximumMatrix(int matrix[][]) {

		int row = matrix.length;
		int col = matrix[0].length;
		System.out.println("row : " + row + ",  col : " + col);
		int l[][] = new int[row][col];

		for(int j=0;j<col;j++) {
			l[0][j] = matrix[0][j];
		}

		for(int j=0;j<row;j++) {
			l[j][0] = matrix[j][0];
		}

		for(int i=1;i<row;i++) {
			for(int j=0;j<col;j++) {
				matrix[i][j]+=matrix[i-1][j];
			}
		}
		
		int startRow = -1, startCol=-1, endRow=-1, endCol=-1;
		
		int maxArea = 0;
		for(int i=1;i<row;i++) {
			int j=0;
			Stack<Integer> s = new Stack<Integer>();
			int l_col = -1, r_col = -1, start_i_value=0;
			int area_top = 0;
			while(j<col) {
				if(s.isEmpty() || matrix[i][s.peek()]<=matrix[i][j]) {
					s.push(j);
					j++;
				} else {
					int top = s.peek();
					s.pop();
					area_top = matrix[i][top]*(s.isEmpty()?j:j-s.peek()-1);
					
					start_i_value = matrix[i][top];
					if(s.isEmpty()) {
						r_col = j-1;
						l_col = 0;
					} else {
						r_col = j-1;
						l_col = s.peek()+1;
					}
				}
				
				if(maxArea<=area_top) {
					maxArea = area_top;
					startCol = l_col;
					endCol = r_col;
					startRow= i - start_i_value +1;
					endRow = i;
				}
			}
			
			while(!s.isEmpty()) {
				int top = s.peek();
				s.pop();
				area_top = matrix[i][top]*(s.isEmpty()?j:j-s.peek()-1);
				
				start_i_value = matrix[i][top];
				if(s.isEmpty()) {
					r_col = j-1;
					l_col = 0;
				} else {
					r_col = j-1;
					l_col = s.peek()+1;
				}
				
				if(maxArea<=area_top) {
					maxArea = area_top;
					startCol = l_col;
					endCol = r_col;
					startRow= i - start_i_value + 1;
					endRow = i;
				}
			}
		}
		System.out.println("start row : " + startRow + ", end row : " + endRow 
				+ ", startCol : " + startCol +", endCol : " + endCol);
		
		for(int i=row-1;i>0;i--) {
			for(int j=0;j<col;j++) {
				matrix[i][j]-=matrix[i-1][j];
			}
		}
	
		for(int i=startRow;i<endRow;i++) {
			for(int j=startCol;j<=endCol;j++) {
				System.out.print("  " + matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println("\n\n");
		printMatrix(matrix);

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
