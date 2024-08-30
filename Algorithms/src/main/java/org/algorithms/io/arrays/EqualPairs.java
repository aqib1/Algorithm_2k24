package org.algorithms.io.arrays;

import java.util.Arrays;

public class EqualPairs {

    public static void main(String[] args) {
        System.out.println(equalPairs(
                new int[][] {
                        {3}
                }
        ));
    }

    // Time complexity O(n2)
    // Space complexity O(n2)
    public static int equalPairs(int[][] grid) {
        int len = grid.length;
        if(len == 0)
            return 0;

        int[][] rows = new int[len][];
        int[][] columns = new int[len][];
        int count = 0;

        for(int row = 0; row < len; row++) {
            rows[row] = grid[row];
            int []col = new int[len];
            for(int column = 0; column < len; column++) {
                col[column] = grid[column][row];
            }
            columns[row] = col;
        }

        for (int[] row : rows) {
            for (int[] column : columns) {
                if (Arrays.equals(row, column)) {
                    count++;
                }
            }
        }

        return count;
    }
}
