package com.java.graph.competitiveProblems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/explore/learn/card/graph/622/single-source-shortest-path-algorithm/3952/
// Note: Can use Binary Search
public class PathWithMinimumEffort {

    public static int[][] DIRECTION = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    // Using Dijkstra Algo
    // Time Complexity : O(m⋅nlog(m⋅n))
    public int minimumEffortPath(int[][] heights) {
        int rowCount = heights.length;
        int colCount = heights[0].length;

        //Visited matrix
        boolean[][] visited = new boolean[rowCount][colCount];
        /*for (int i = 0; i < rowCount; i++) {
            Arrays.fill(visited[0],false);
        }*/

        // Difference matrix
        int[][] diff = new int[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            Arrays.fill(diff[0], Integer.MAX_VALUE);
        }

        PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(c -> c.difference));

        diff[0][0] = 0;
        pq.add(new Cell(0, 0, diff[0][0]));

        while (!pq.isEmpty()) {
            Cell currentCell = pq.poll();
            visited[currentCell.x][currentCell.y] = true;

            if (currentCell.x == rowCount - 1 || currentCell.y == colCount - 1) {
                return currentCell.difference;
            }

            for (int[] direction : DIRECTION) {
                int adjX = currentCell.x + direction[0];
                int adjY = currentCell.y + direction[1];

                if (isValidDirection(adjX, adjY, rowCount, colCount) && !visited[adjX][adjY]) {
                    int curDiff = Math.abs(heights[adjX][adjY] - heights[currentCell.x][currentCell.y]);
                    int maxDiff = Math.max(curDiff, diff[currentCell.x][currentCell.y]);

                    if (maxDiff < diff[adjX][adjY]) {
                        diff[adjX][adjY] = maxDiff;
                        pq.add(new Cell(adjX, adjY, maxDiff));
                    }
                }
            }
        }

        return diff[rowCount - 1][colCount - 1];
    }

    public boolean isValidDirection(int x, int y, int row, int col) {
        if (x < 0 || x > row - 1 || y < 0 || y > col - 1) {
            return false;
        }
        return true;
    }


    // Solution by LeetCode Using Modified Dijkstra
    public int minimumEffortPath1(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        int[][] differenceMatrix = new int[row][col];
        for (int[] eachRow : differenceMatrix)
            Arrays.fill(eachRow, Integer.MAX_VALUE);
        differenceMatrix[0][0] = 0;
        PriorityQueue<Cell> queue = new PriorityQueue<>(Comparator.comparingInt(c -> c.difference));
        boolean[][] visited = new boolean[row][col];
        queue.add(new Cell(0, 0, differenceMatrix[0][0]));

        while (!queue.isEmpty()) {
            Cell curr = queue.poll();
            visited[curr.x][curr.y] = true;
            if (curr.x == row - 1 && curr.y == col - 1)
                return curr.difference;
            for (int[] direction : DIRECTION) {
                int adjacentX = curr.x + direction[0];
                int adjacentY = curr.y + direction[1];
                if ( isValidDirection(adjacentX, adjacentY, row, col) && !visited[adjacentX][adjacentY]) {
                    int currentDifference = Math.abs(heights[adjacentX][adjacentY] - heights[curr.x][curr.y]);
                    int maxDifference = Math.max(currentDifference, differenceMatrix[curr.x][curr.y]);
                    if (differenceMatrix[adjacentX][adjacentY] > maxDifference) {
                        differenceMatrix[adjacentX][adjacentY] = maxDifference;
                        queue.add(new Cell(adjacentX, adjacentY, maxDifference));
                    }
                }
            }
        }
        return differenceMatrix[row - 1][col - 1];
    }

    static class Cell {
        int x;
        int y;
        int difference;

        public Cell(int x, int y, int difference) {
            this.x = x;
            this.y = y;
            this.difference = difference;
        }
    }

    public static void main(String[] args) {
        //int[][] heights = {{1, 2, 1, 1, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 1, 1, 2, 1}};
        int[][] heights = {{1,2,3},{3,8,4},{5,3,5}};
        PathWithMinimumEffort pathWithMinimumEffort = new PathWithMinimumEffort();
        int result = pathWithMinimumEffort.minimumEffortPath(heights);
        System.out.println("Result: " + result);
    }

}
