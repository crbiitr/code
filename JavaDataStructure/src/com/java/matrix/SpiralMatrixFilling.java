package com.java.matrix;

public class SpiralMatrixFilling {

    public static void main(String[] args) {
        int[][] matrix = generateMatrix(3);
        printTheMatrix(matrix);
    }

    public static int[][] generateMatrix(int n) {
        int num = 1, rowStart = 0, rowEnd = n, colStart = 0, colEnd = n;
        int matrix[][] = new int[n][n];
        while (rowStart<rowEnd && colStart<colEnd) {
            //Row
            for (int i = colStart; i < colEnd; i++) {
                matrix[rowStart][i] = num++;
            }
            rowStart++;

            //Last Col
            for (int row = rowStart; row < rowEnd; row++) {
                matrix[row][colEnd-1] = num++;
            }
            colEnd--;

            // End Row
            for (int col = colEnd-1; col >= colStart; col--) {
                matrix[rowEnd-1][col] = num++;
            }
            rowEnd--;

            // first col
            for (int row = rowEnd-1; row >= rowStart; row--) {
                matrix[row][colStart] = num++;
            }
            colStart++;
        }
        return matrix;
    }

    public static void printTheMatrix(int[][] matrix) {
        int N = matrix.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print("  " + matrix[i][j]);
            }
            System.out.println();
        }
    }
}
