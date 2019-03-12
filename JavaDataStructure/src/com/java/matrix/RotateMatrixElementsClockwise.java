package com.java.matrix;

/**
 * @author Chetan Raj
 * @implNote https://www.geeksforgeeks.org/rotate-matrix-elements/
 * @since : 05/03/19
 */
public class RotateMatrixElementsClockwise {
    private static final int ROW = 3;
    private static final int COL = 6;

    public static void main(String[] args) {
        int matrix[][] = new int[ROW][COL];
        initialFillingTheMatrix(ROW, COL, matrix);
        System.out.println("\nPrinting before element rotations ==> \n");
        printRowWise(ROW, COL, matrix);

        rotateMatrixElementsClockwise(ROW, COL, matrix);
        System.out.println("\nPrinting after element rotations ==> \n");
        printRowWise(ROW, COL, matrix);

    }

    private static void rotateMatrixElementsClockwise(int rowEndIndex, int colEndIndex, int[][] matrix) {
        int rowStartIndex = 0;
        int colStartIndex = 0;
        int prev;
        int curr;
        int iterator;
        while (rowEndIndex > rowStartIndex && colEndIndex > colStartIndex) {

            // NOTE: Break the flow if only single row or single column left in next level
            if(rowStartIndex==rowEndIndex-1 || colStartIndex==colEndIndex-1)
                break;

            prev = matrix[rowStartIndex+1][colStartIndex];

            // Print the first row from the remaining rows
            for (iterator = colStartIndex; iterator < colEndIndex; iterator++) {
                curr = matrix[rowStartIndex][iterator];
                matrix[rowStartIndex][iterator] = prev;
                prev = curr;
            }
            rowStartIndex++;

            // Print the last column from the remaining columns
            for (iterator = rowStartIndex; iterator < rowEndIndex; iterator++) {
                curr = matrix[iterator][colEndIndex - 1];
                matrix[iterator][colEndIndex - 1] = prev;
                prev = curr;
            }
            colEndIndex--;

            // Print the last row from the remaining rows */
            if (rowStartIndex < rowEndIndex) {
                for (iterator = colEndIndex-1; iterator >= colStartIndex; iterator--) {
                    curr = matrix[rowEndIndex - 1][iterator];
                    matrix[rowEndIndex - 1][iterator] = prev;
                    prev = curr;
                }
                rowEndIndex--;
            }

            // Print the first column from the remaining columns */
            if (colStartIndex < colEndIndex) {
                for (iterator = rowEndIndex-1; iterator >= rowStartIndex; iterator--) {
                    curr = matrix[iterator][colStartIndex];
                    matrix[iterator][colStartIndex] = prev;
                    prev = curr;
                }
                colStartIndex++;
            }
        }
    }

    private static void initialFillingTheMatrix(int row, int col, int[][] matrix) {
        int num = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = num++;
            }
        }
    }

    private static void printRowWise(int row, int col, int[][] matrix) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
    }
}
