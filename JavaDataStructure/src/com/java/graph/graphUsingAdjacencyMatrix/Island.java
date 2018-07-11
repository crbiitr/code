package com.java.graph.graphUsingAdjacencyMatrix;

public class Island {

    private final int ROW = 5;
    private final int COL = 5;

    public static void main(String[] args) {
        int matrix[][] = {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };

        Island island = new Island();
        int count = island.totalNumberOfIslandUsingDFS(matrix);
        System.out.println("Total no of Island are: " + count);
    }

    public boolean isSafe(int[][] matrix, int row, int col, boolean[][] visited) {
        boolean isSafe = false;
        if (row >= 0 && row < ROW
                && col >= 0 && col < COL
                && matrix[row][col] == 1
                && Boolean.FALSE.equals(visited[row][col])) {
            isSafe = true;
        }
        return isSafe;
    }

    public int totalNumberOfIslandUsingDFS(int[][] matrix) {
        int count = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1 && Boolean.FALSE.equals(visited[i][j])) {
                    totalNumberOfIslandUtils(matrix, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private void totalNumberOfIslandUtils(int[][] matrix, int row, int col, boolean[][] visited) {
        int[] rowAround = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colAround = {-1, 0, 1, -1, 1, -1, 0, 1};

        visited[row][col] = true;

        //Very important, I have done 1 mistake here and tried to run two loops for rowAround and colAround
        for (int k = 0; k < rowAround.length; k++) {
            if (isSafe(matrix, row + rowAround[k], col + colAround[k], visited)) {
                totalNumberOfIslandUtils(matrix, row + rowAround[k], col + colAround[k], visited);
            }
        }
    }
}
