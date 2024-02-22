package org.algorithms.io.backtracking;

import java.util.Arrays;

public class KnightMove {
    // Time complexity O(n!) and space O(n)
    public static void main(String[] args) {
        var k = new KnightMove();

        System.out.println(
                k.checkValidGrid(
                        5
                )
        );
    }

    private static final int [] X_MOVES = {2, 1, -2, 1, -1, 2, -1, -2};
    private static final int [] Y_MOVES = {1, 2, 1, -2, 2, -1, -2, -1};
    private static final int MOVES = X_MOVES.length;
    private int[][] grid;
    private int boardSize;
    public boolean checkValidGrid(int size) {
        this.grid = new int[size][size];
        this.boardSize = size * size;
        initGrid();
        grid[0][0] = 0;
         if(knightMove(1, 0, 0)) {
             printKnightMove();
             return true;
         } else {
             return false;
         }
    }

    private void initGrid() {
        for (int[] its : grid) {
            Arrays.fill(its, Integer.MIN_VALUE);
        }
    }

    public boolean knightMove(int stepCount, int x, int y) {
        if(stepCount == boardSize) {
            return true;
        }

        for(int move = 0; move < MOVES; move++) {
            int newX = x + X_MOVES[move];
            int newY = y + Y_MOVES[move];

            if(isValid(newX, newY)) {
                grid[newX][newY] = stepCount;
                if(knightMove(stepCount + 1, newX, newY)) {
                    return true;
                }
                grid[newX][newY] = Integer.MIN_VALUE;
            }
        }

        return false;
    }

    private boolean isValid(int newX, int newY) {
        if(newX < 0 || newX >= grid.length
                || newY < 0 || newY >= grid[newX].length)
            return false;

        return grid[newX][newY] == Integer.MIN_VALUE;
    }

    private void printKnightMove() {
        for (int[] ints : grid) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
