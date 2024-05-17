package org.algorithms.io.recursion;

public class O1KnapsackUsingTabularization {
    // Time complexity O(n * w) and space O(n * w)
    public int knapsack(int w, int[] wt, int[] vt, int n) {
        int[][] dp = new int[n + 1][w + 1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= w; j++) {
                if(j < wt[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(
                            dp[i - 1][j],
                            vt[i - 1] + dp[i - 1][j - wt[i - 1]]
                    );
                }
            }
        }

        return dp[n][w];
    }
}
