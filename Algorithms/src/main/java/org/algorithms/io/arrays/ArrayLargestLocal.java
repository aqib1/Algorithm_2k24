package org.algorithms.io.arrays;

import java.util.Arrays;

public class ArrayLargestLocal {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(
                largestLocal(new int[][]{
                        {9, 9, 8, 1},
                        {5, 6, 2, 6},
                        {8, 2, 6, 4},
                        {6, 2, 2, 2}
                })
        ));
    }

    public static int maxValue(int[][] grid, int i, int j) {
        int max = Integer.MIN_VALUE;
        for (int pointerX = i; pointerX < i + 3; pointerX++) {
            for (int pointerY = j; pointerY < j + 3; pointerY++) {
                max = Math.max(max, grid[pointerX][pointerY]);
            }
        }
        return max;
    }

    public static int[][] largestLocal(int[][] grid) {
        if (grid.length < 3 || grid[0].length < 3) {
            throw new IllegalArgumentException("Grid must be at least 3x3");
        }

        var result = new int[grid[0].length - 2][grid.length - 2];
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[i].length - 2; j++) {
                result[i][j] = maxValue(grid, i, j);
            }
        }

        return result;
    }
}
