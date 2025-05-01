package org.algorithms.io.wise.algorithm;

public class MaximalSquareDp {

    // Time complexity O(n + m) and space complexity O(n + m)
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] dp = new int[row + 1][column + 1];
        int max = 0;

        for(int i = 1; i < row + 1; i++) {
            for(int j = 1; j < column + 1; j++) {
                if(matrix[i - 1][j - 1] == '1') {
                    int left = dp[i - 1][j];
                    int diagonal = dp[i - 1][j - 1];
                    int up = dp[i][j - 1];
                    int min = Math.min(left, Math.min(diagonal, up));

                    dp[i][j] = min + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max * max;
    }
}
