package org.algorithms.io.dynamic_programming;

import java.util.Arrays;

public class KnapsackUsingMemoization {
    // Top-down approach
    public int knapsackUsingMemoization(int w, int []val, int []wt) {
        int n = val.length;
        int [][] memo = new int[n + 1][w + 1];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }

        return knapsack(w, val, wt, n, memo);
    }

    // Time complexity O(n * w) and space O(n * w)
    public int knapsack(int w, int []val, int []wt, int n, int [][] memo) {
        if(w == 0 || n == 0)
            return 0;

        if(memo[n][w] != -1) {
            return memo[n][w];
        }

        int pick = 0;
        if(wt[n - 1] <= w) {
            pick = val[n - 1] + knapsack(w - wt[n - 1], val, wt, n - 1, memo);
        }

        int notPick = knapsack(w, val, wt, n - 1, memo);

        return memo[n][w] = Math.max(pick, notPick);
    }
}
