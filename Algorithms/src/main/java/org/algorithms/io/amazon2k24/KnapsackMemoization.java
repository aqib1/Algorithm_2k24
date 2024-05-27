package org.algorithms.io.amazon2k24;

public class KnapsackMemoization {
    // Time complexity O(n * w) and space complexity O(n * w)
    public int knapsack(int w, int[] val, int[] wt) {
        int n = val.length;
        int[][] memo = new int[n + 1][w + 1];
        return knapsack(w, val, wt, n, memo);
    }

    public int knapsack(int w, int[] val, int[] wt, int n, int[][] memo) {
        if(w == 0 || n == 0)
            return 0;
        if(memo[n][w] != 0)
            return memo[n][w];

        int pickValue = 0;
        if(wt[n - 1] <= w) {
            pickValue = val[n - 1] + knapsack(w - wt[n - 1], val, wt, n - 1, memo);
        }

        int notPick = knapsack(w, val, wt, n - 1, memo);

        return memo[n][w] = Math.max(pickValue, notPick);
    }
}
