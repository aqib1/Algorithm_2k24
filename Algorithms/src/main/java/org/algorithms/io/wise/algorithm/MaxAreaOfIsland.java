package org.algorithms.io.wise.algorithm;

public class MaxAreaOfIsland {
    private static final int[] DIRECTIONS = {-1, 0, 1, 0, -1};
    private int rows;
    private int columns;
    private int maxArea;
    private int currentArea;
    private int[][] grid;

    // Time complexity O(n + m) and space O(n + m)
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.columns = grid[0].length;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                if(grid[i][j] == 1) {
                    currentArea = 1;
                    dfs(i, j);
                    maxArea = Math.max(currentArea, maxArea);
                }
            }
        }
        return maxArea;
    }

    private void dfs(int row, int column) {
        grid[row][column] = 0;

        for(int d = 0; d < DIRECTIONS.length - 1; d++) {
            int newRow = row + DIRECTIONS[d];
            int newColumn = column + DIRECTIONS[d + 1];

            if(newRow >= 0 && newRow < rows
                && newColumn >= 0 && newColumn < columns && grid[newRow][newColumn] == 1) {
                currentArea++;
                dfs(newRow, newColumn);
            }
        }
    }
}
