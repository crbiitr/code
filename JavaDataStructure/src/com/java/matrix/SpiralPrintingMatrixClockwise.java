package com.java.matrix;

/**
 * @author Chetan Raj
 * @implNote https://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
 * @since : 27/02/19
 */
public class SpiralPrintingMatrixClockwise {
    private static final int ROW = 3;
    private static final int COL = 6;

    public static void main(String[] args) {
        int matrix[][] = new int[ROW][COL];
        initialFillingTheMatrix(ROW, COL, matrix);
        printRowWise(ROW, COL, matrix);
        System.out.println("\nPrinting spiral matrix ==> \n");
        printSpiralFormClockwise(ROW, COL, matrix);

    }

    private static void printSpiralFormClockwise(int rowEndIndex, int colEndIndex, int[][] matrix) {
        int rowStartIndex = 0;
        int colStartIndex = 0;
        int i = 0;
        while (rowEndIndex > rowStartIndex && colEndIndex > colStartIndex) {

            // Print the first row from the remaining rows
            for (i = colStartIndex; i < colEndIndex; i++) {
                System.out.print(" " + matrix[rowStartIndex][i]);
            }
            rowStartIndex++;

            // Print the last column from the remaining columns
            for (i = rowStartIndex; i < rowEndIndex; i++) {
                System.out.print(" " + matrix[i][colEndIndex - 1]);
            }
            colEndIndex--;

            // Print the last row from the remaining rows */
            if (rowStartIndex < rowEndIndex) {
                for (i = colEndIndex-1; i >= colStartIndex; i--) {
                    System.out.print(" " + matrix[rowEndIndex - 1][i]);
                }
                rowEndIndex--;
            }

            // Print the first column from the remaining columns */
            if (colStartIndex < colEndIndex) {
                for (i = rowEndIndex-1; i >= rowStartIndex; i--) {
                    System.out.print(" " + matrix[i][colStartIndex]);
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
