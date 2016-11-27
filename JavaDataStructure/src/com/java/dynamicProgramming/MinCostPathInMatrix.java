package com.java.dynamicProgramming;

/**
 * Created by user on 11/16/16.
 */
public class MinCostPathInMatrix {

    public static void main(String[] args) {
        int cost[][] = {{1,2,3},{4,8,2},{1,5,3}};

        System.out.println("Min cost is :: " + minCost(cost));
    }

    public static int minCost(int cost[][]) {
        int row = cost.length;
        int col = cost[0].length;
        if (row<0 || col < 0) return Integer.MIN_VALUE;
        int minCostMaticx[][] = new int[row][col];
        minCostMaticx[0][0] = cost[0][0];
        for (int i = 1; i < row; i++) {
            minCostMaticx[i][0] = minCostMaticx[i-1][0] + cost[i][0];
        }
        for (int j = 1; j < col; j++) {
            minCostMaticx[0][j] = minCostMaticx[0][j-1] + cost[0][j];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                minCostMaticx[i][j] = getMin(minCostMaticx[i-1][j-1],
                                                minCostMaticx[i-1][j],
                                                minCostMaticx[i][j-1]) + cost[i][j];
            }
        }
        return minCostMaticx[row-1][col-1];
    }

    public static int getMin(int x, int y, int z) {
        if (x < y) {
            return (x < z ? x : z);
        } else
            return (y < z ? y : z);
    }

    /* Recursive method, Returns cost of minimum cost path from (0,0) to (m, n) in mat[][]*/
    public static int minCost(int cost[][], int m, int n)
    {
        if (n < 0 || m < 0)
            return Integer.MAX_VALUE;
        else if (m == 0 && n == 0)
            return cost[m][n];
        else
            return cost[m][n] + getMin( minCost(cost, m-1, n-1),
                    minCost(cost, m-1, n),
                    minCost(cost, m, n-1) );
    }
}
