package org.algorithms.io.backtracking;

public class KnightTourConfiguration {
    // Time complexity O(N!) & Space O(N)
    public static void main(String[] args) {
        var k = new KnightTourConfiguration();
        System.out.println(
                k.checkValidGrid(
                        new int[][] {
                                {0,11,16,5,20},
                                {17,4,19,10,15},
                                {12,1,8,21,6},
                                {3,18,23,14,9},
                                {24,2,13,7,22}
                        }
                )
        );
    }
    private static final int []X_MOVES = {1, 2, -1, 2, -2, 1, -2, -1};
    private static final int []Y_MOVES = {2, 1, 2, -1, 1, -2, -1, -2};
    private static final int MOVES = X_MOVES.length;
    private int[][] grid;
    private int gridSize;
    public boolean checkValidGrid(int[][] grid) {
        this.grid = grid;
        this.gridSize = grid.length * grid[0].length;
        return isValid(0, 0, 0);
    }

    private boolean isValid(int counter, int x, int y) {
        if(counter == gridSize) {
            return true;
        }
        if(grid[x][y] != counter) {
            return false;
        }
        for(int move = 0; move < MOVES; move++) {
            int newX = x + X_MOVES[move];
            int newY = y + Y_MOVES[move];

            if(valid(newX, newY)) {
                if(isValid(counter + 1, newX, newY)) {
                    return true;
                }
            }
        }
    return false;
    }

    private boolean valid(int newX, int newY) {
        return newX >= 0 && newX < grid.length
                && newY >= 0 && newY < grid[newX].length;
    }
}
