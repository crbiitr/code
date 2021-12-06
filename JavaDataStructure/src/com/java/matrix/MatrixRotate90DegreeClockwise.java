package com.java.matrix;

/**
 * @author Chetan Raj
 * @implNote https://www.geeksforgeeks.org/rotate-a-matrix-by-90-degree-in-clockwise-direction-without-using-any-extra-space/
 * @since : 21/02/19
 */
public class MatrixRotate90DegreeClockwise {
    public static final int N = 3;

    public static void main(String[] args) {

        System.out.println("Approach 1:: ==>> ");
        int[][] matrix = new int[N][N];
        fillTheMatrix(matrix);
        System.out.println("Before rotation:: ==> ");
        printTheMatrix(matrix);
        // rotateMatrix90DegreeClockwise(matrix);
        rotateMatrix90DegreeClockwiseDifferentApproach(matrix);
        System.out.println("After rotation:: ==> ");
        printTheMatrix(matrix);

        System.out.println("\nApproach 2:: ==>> ");
        int[][] matrix2 = new int[N][N];
        fillTheMatrix(matrix2);
        System.out.println("Before rotation:: ==> ");
        printTheMatrix(matrix2);
        // rotateMatrix90DegreeClockwise(matrix);
        rotate(matrix2);
        System.out.println("After rotation:: ==> ");
        printTheMatrix(matrix2);
    }

    /**
     * Reverse logic of Anti Clockwise algorithm
     *
     * @param matrix
     */
    private static void rotateMatrix90DegreeClockwise(int[][] matrix) {
        for (int x = 0; x < N / 2; x++) {
            for (int y = x; y < N - 1 - x; y++) {

                int temp = matrix[N - 1 - y][x];

                matrix[N - 1 - y][x] = matrix[N - 1 - x][N - 1 - y];

                matrix[N - 1 - x][N - 1 - y] = matrix[y][N - 1 - x];

                matrix[y][N - 1 - x] = matrix[x][y];

                matrix[x][y] = temp;
            }
        }
    }

    /**
     * GFG approach
     *
     * @param matrix
     */
    private static void rotateMatrix90DegreeClockwiseDifferentApproach(int[][] matrix) {
        for (int x = 0; x < N / 2; x++) {
            for (int y = x; y < N - 1 - x; y++) {

                int temp = matrix[x][y];

                matrix[x][y] = matrix[N - 1 - y][x];

                matrix[N - 1 - y][x] = matrix[N - 1 - x][N - 1 - y];

                matrix[N - 1 - x][N - 1 - y] = matrix[y][N - 1 - x];

                matrix[y][N - 1 - x] = temp;
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

    // Another solution using reverse and Transpose
    public static void rotate(int[][] matrix) {

        //transpose
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][ i] = temp;
            }
        }

        System.out.println("\ntranspose:: ==> ");
        printTheMatrix(matrix);

        //reverse row-wise
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[0].length - 1 - j];
                matrix[i][matrix[0].length - 1 - j] = temp;
            }
        }
    }
}
