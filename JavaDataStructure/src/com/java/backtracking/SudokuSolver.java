package com.java.backtracking;

import java.util.*;
/**
 * Created by chetan on 27/1/18.
 */
class SudokuSolver {

    public static void main(String[] args) {
/*
        int[][] matrix = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
        */

        int[][] matrix = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        long startTime = System.currentTimeMillis();
        boolean result = solveSudoku(matrix);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime-startTime));
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.print("\n");
        }
    }

    public static boolean solveSudoku(int[][] matrix){

        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if (matrix[i][j]==0) {
                    boolean result = false;
                    int k = 1;
                    while(!result){
                        if (k==10){
                            matrix[i][j] = 0;
                            return false;
                        }
                        matrix[i][j] = k;
                        k++;
                        result = testRow(matrix,i,j)&&testColumn(matrix,i,j)&&testBlock(matrix,i,j);
                        if (!result)
                            continue;
                        result = solveSudoku(matrix);
                    }
                }
            }
        }
        return true;
    }

    public static boolean testRow(int[][] matrix, int i,int j){
        int key = matrix[i][j];

        for (int k=0; k<9; k++) {
            if (k==j)
                continue;
            if (key==matrix[i][k])
                return false;
        }

        return true;
    }

    public static boolean testColumn(int[][] matrix, int i, int j){

        int key = matrix[i][j];

        for (int k=0; k<9; k++) {
            if (k==i)
                continue;
            if (key==matrix[k][j])
                return false;
        }

        return true;
    }

    public static boolean testBlock(int[][] matrix, int i, int j){

        int key = matrix[i][j];

        int k_gap = 3*(i/3);
        int l_gap = 3*(j/3);

        for (int k=0; k<3; k++) {
            for (int l=0; l<3;l++) {
                if (i==k_gap+k&&j==l_gap+l)
                    continue;
                if (matrix[k_gap+k][l_gap+l]==key)
                    return false;
            }
        }
        return true;
    }
}



