package com.java.backtracking;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by chetan on 7/3/17.
 * http://www.geeksforgeeks.org/backtracking-set-3-n-queen-problem/
 * The N Queen is the problem of placing N chess queens on an N×N chessboard.
 *
 * NOTE: PLEASE CHECK THIS ALSO- http://www.geeksforgeeks.org/printing-solutions-n-queen-problem/
 */
public class NQueenProblem {
    final int N;
    NQueenProblem(int n){
        N = n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noOfQueens = scanner.nextInt();
        NQueenProblem queen = new NQueenProblem(noOfQueens);
        queen.solveNQ();
    }

    boolean solveNQ() {
        /*
        int board[][] ={{0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0} };

        */

        int board[][] = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(board[i], 0);
        }

        if(!solveNQUtil(board,0)) {
            System.out.println("Solution does not exist");
            return false;
        }
        printSolution(board);
        return true;
    }

    boolean solveNQUtil(int [][] board, int col) {

        if (col >= N) return true;

        for (int i = 0; i < N; i++) {
            if (isSafe(board,i,col)) {
                board[i][col] = 1;

                if (solveNQUtil(board,col+1)) {
                    return true;
                }

                board[i][col] = 0; // BACKTRACK
            }
        }

        return false;
    }

    boolean isSafe(int[][] board, int row, int col) {
        int i,j;
        for (i = 0; i < col ; i++) {
            if (board[row][i] == 1)
                return false;
        }

        for (i = 0, j = col; i >= 0 && j >= 0 ; i--,j--) {
            if (board[i][j] == 1)
                return false;
        }

        for (i = 0, j = col; i < N && j >= 0 ; i++,j--) {
            if (board[i][j] == 1)
                return false;
        }
        return true;
    }

    /* A utility function to print solution */
    void printSolution(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j] + " ");
            System.out.println();
        }
    }



}
