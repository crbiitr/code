package com.java.matrix;

/**
 * @author Chetan Raj
 * @implNote https://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/
 * @since : 21/02/19
 */
public class MatrixRotate90DegreeAntiClockwise {
    public static final int N = 4;

    public static void main(String[] args) {

        int[][] matrix = new int[N][N];
        fillTheMatrix(matrix);
        System.out.println("Before rotation:: ==> ");
        printTheMatrix(matrix);
        rotateMatrix90DegreeAntiClockwise(matrix);
        System.out.println("After rotation:: ==> ");
        printTheMatrix(matrix);
    }

    private static void rotateMatrix90DegreeAntiClockwise(int[][] matrix) {
        // Consider all squares one by one
        for (int x = 0; x < N / 2; x++) {
            // Consider elements in group of 4 in
            // current square
            for (int y = x; y < N - 1 - x; y++) {
                // store current cell in temp variable
                int temp = matrix[x][y];
                // move values from right to top
                matrix[x][y] = matrix[y][N - 1 - x];
                // move values from bottom to right
                matrix[y][N - 1 - x] = matrix[N - 1 - x][N - 1 - y];
                // move values from left to bottom
                matrix[N - 1 - x][N - 1 - y] = matrix[N - 1 - y][x];
                // assign temp to left
                matrix[N - 1 - y][x] = temp;
            }
        }
    }

    public static void fillTheMatrix(int[][] matrix) {
        int num = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = num++;
            }
        }
    }

    public static void printTheMatrix(int[][] matrix) {
        int num = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print("  " + matrix[i][j]);
            }
            System.out.println();
        }
    }
}