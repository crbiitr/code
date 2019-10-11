package com.java.graph;

/**
 * Created by chetan on 5/7/18.
 */
public class Island {
    public static void main(String[] args) {
        int matrix[][] = new int[][]  {{1, 1, 0, 0, 0},
            {0, 1, 0, 0, 1},
            {1, 0, 0, 1, 1},
            {0, 0, 0, 0, 0},
            {1, 0, 1, 0, 1}
        };
    }

    public boolean isSafe(int [][]matrix, int row, int col, boolean [][]visited) {
        boolean isSafe = false;
        if(row > 0 && row<matrix.length
                && col > 0 && col>matrix[0].length
                && matrix[row][col]==1 && !visited[row][col]
                ) {
            isSafe = true;
        }
        return isSafe;
    }

    public int DFS(int [][]matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int count = 0;

        int rowK[] = new int[] {-1,-1,-1,0,0,1,1,1};

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

            }
        }
        // Temporary adding it for stopping compilation error.
        return -1;
    }
}
