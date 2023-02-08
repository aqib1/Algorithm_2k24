package org.algorithms.io.interviewPrep2k25.arrays;

public class MaximumSquare {

    private int row;
    private int col;
    private int max;
    private char[][] matrix;
    private Integer[][] memo;
    // using memoization approach
    public int maximalSquare(char[][] matrix) {
        row = matrix.length;
        col = matrix[0].length;
        memo = new Integer[row][col];
        this.matrix = matrix;

        helper(0, 0);

        return max * max;
    }

    // Time O(N * M) and space O(N * M)
    private int helper(int row, int col) {
        if(row >= this.row || col >= this.col)
            return 0;

        if(memo[row][col] != null) return memo[row][col];

        int right = helper(row, col + 1);
        int diagonal = helper(row + 1, col + 1);
        int down = helper(row + 1, col);

        int min = Math.min(right, Math.min(diagonal, down));
        int currentValue = matrix[row][col] == '1' ? 1 : 0;
        if(currentValue == 1) {
            currentValue += min;
        }
        memo[row][col] = currentValue;
        max = Math.max(max, currentValue);
        return currentValue;
    }
}
