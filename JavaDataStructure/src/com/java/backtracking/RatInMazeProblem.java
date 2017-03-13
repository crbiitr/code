package com.java.backtracking;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by chetan on 7/3/17.
 * http://www.geeksforgeeks.org/backttracking-set-2-rat-in-a-maze/
 * In this problem, The rat can move only in two directions: forward and down.
 */
public class RatInMazeProblem {

    final int N = 4;
    /*RatInMazeProblem(int n){
        N = n;
    }*/

    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        int noOfQueens = scanner.nextInt();*/
        RatInMazeProblem rat = new RatInMazeProblem();
        int maze[][] = {{1, 1, 1, 1},
                {0, 0, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };

        /*
          int maze[][] = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
                };
        */

        rat.solveMaze(maze);
    }

    boolean solveMaze(int[][] maze) {
        int solution[][] = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(solution[i], 0);
        }

        if(!solveMazeUtil(maze,0,0,solution)) {
            System.out.println("Solution does not exist");
            return false;
        }
        printSolution(solution);
        return true;
    }

    boolean solveMazeUtil(int maze[][], int i, int j, int[][] solution) {
        if (i == N-1 && j == N-1) {
            solution[i][j] = 1;
            return true;
        }

        // Check if maze[x][y] is valid
        if (i>=0 && j>=0 && isSafe(maze, i, j)) {
            // mark x,y as part of solution path
            solution[i][j] = 1;

            /* Move forward in x direction */
            if (solveMazeUtil(maze,i+1,j,solution))
                return true;

            /* If moving in x direction doesn't give
               solution then  Move down in y direction */
            if (solveMazeUtil(maze,i,j+1,solution))
                return true;

            // Other all directions
/*
            if (solveMazeUtil(maze,i-1,j-1,solution))
                return true;
            if (solveMazeUtil(maze,i-1,j,solution))
                return true;
            if (solveMazeUtil(maze,i-1,j+1,solution))
                return true;
            if (solveMazeUtil(maze,i,j-1,solution))
                return true;
            if (solveMazeUtil(maze,i+1,j-1,solution))
                return true;
            if (solveMazeUtil(maze,i+1,j+1,solution))
                return true;

*/

            /* If none of the above movements work then
               BACKTRACK: unmark i,j as part of solution
               path */
            solution[i][j] = 0;
            return false;
        }
        return false;
    }

    boolean isSafe(int[][] maze, int row, int col) {
        return  (row >= 0 && col >= 0 && row < N  && col < N && maze[row][col] == 1);
    }

    /* A utility function to print solution */
    void printSolution(int maze[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + maze[i][j] + " ");
            System.out.println();
        }
    }

}
