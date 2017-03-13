package com.java.backtracking;

/**
 * Created by chetan on 8/3/17.
 * http://www.geeksforgeeks.org/backtracking-set-7-suduku/
 */
public class Sudoku {

    public static void main(String[] args) {

        System.out.println("Solution of Sudoku");
        int grid[][] = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
        SudokuSolution sudoku = new SudokuSolution();
        sudoku.solveSudoku(grid);
    }
}

class SudokuSolution {
    public final static int ROW = 9;
    public final static int COL = 9;

    public boolean solveSudoku(int grid[][]) {
        if (solveSudokuUtils(grid) == false) {
            return false;
        }
        printSolution(grid);
        return true;
    }

    private boolean solveSudokuUtils(int[][] grid) {
        boolean isUnAssigned = false;
        int i = 0;
        int j = 0;
        for (i = 0; i < ROW; i++) {
            for (j = 0; j < COL; j++) {
                if (grid[i][j] == 0) {
                    isUnAssigned = true;
                    break;
                }
            }
            if (isUnAssigned) {
                break;
            }
        }

        // If you reached to the solution
        if(i==ROW && j == COL){
            return true;
        }

        // main logic
        for (int num = 1; num <= 9; num++) {
            if (isSafe(grid, i, j, num)) {
                grid[i][j] = num;
                if (solveSudokuUtils(grid)) {
                    return true;
                }
            }
            grid[i][j] = 0;
        }
        return false;
    }

    private boolean isSafe(int[][] grid, int row, int col, int num) {
        return (isVerticalOk(grid, col, num) && isHorizontalOk(grid, row, num)
                && canNumberBePlaceInBox(grid, row, col, num));
    }

    // For checking the unique no. in the 3x3 box
    private boolean canNumberBePlaceInBox(int[][] grid, int row, int col, int num) {
        int newRow = row - row % 3;
        int newCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i + newRow][j + newCol] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isHorizontalOk(int[][] grid, int row, int num) {
        for (int i = 0; i < COL; i++) {
            if (grid[row][i] == num) {
                return false;
            }
        }
        return true;
    }

    private boolean isVerticalOk(int[][] grid, int col, int num) {
        for (int i = 0; i < ROW; i++) {
            if (grid[i][col] == num) {
                return false;
            }
        }
        return true;
    }


    /* A utility function to print solution */
    void printSolution(int grid[][]) {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++)
                System.out.print(" " + grid[i][j] + " ");
            System.out.println();
        }
    }
}
