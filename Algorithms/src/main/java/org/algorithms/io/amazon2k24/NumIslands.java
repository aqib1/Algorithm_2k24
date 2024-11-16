package org.algorithms.io.amazon2k24;

public class NumIslands {
    private static final int[] DIRECTIONS = new int [] {0, 1, 0, -1, 0};

   // O(N * M) where N is number of unique 1 and M is branches of one
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    captureIsland(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void captureIsland(char[][] grid, int i, int j) {

        grid[i][j] = '0';

        for(int d = 0; d < DIRECTIONS.length - 1; d++) {
            int newI = i + DIRECTIONS[d];
            int newJ = j + DIRECTIONS[d + 1];

            if(newI >= 0 && newI < grid.length && newJ >= 0 && newJ < grid[newI].length && grid[newI][newJ] == '1') {
                captureIsland(grid, newI, newJ);
            }
        }

    }
}
