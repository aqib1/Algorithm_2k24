package org.algorithms.io.wise.algorithm;

public class MaximalSquare {
    private int rows;
    private int columns;
    private int max;
    private char[][] matrix;
    private Integer[][] memo;
    public int maximalSquare(char[][] matrix) {
        this.rows = matrix.length;
        this.columns = matrix[0].length;
        this.memo = new Integer[rows][columns];
        this.matrix = matrix;

        helper(0, 0);

        return max * max;
    }

    private int helper(int row, int column) {
        if(row >= this.rows || column >= this.columns)
            return 0;

        if(memo[row][column] != null) {
            return memo[row][column];
        }

        int right = helper(row, column + 1);
        int diagonal = helper(row + 1, column + 1);
        int down = helper(row + 1, column);
        int min = Math.min(right, Math.min(diagonal, down));

        int currentValue = matrix[row][column] == '1' ? 1 : 0;
        if(currentValue == 1) {
            currentValue += min;
        }
        memo[row][column] = currentValue;
        max = Math.max(max, currentValue);

        return currentValue;
    }
}
