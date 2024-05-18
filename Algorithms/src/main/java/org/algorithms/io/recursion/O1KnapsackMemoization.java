package org.algorithms.io.recursion;

public class O1KnapsackMemoization {
    // Time complexity and space O(w * n) with top-down approach
    public static int findKnapsack(int capacity, int[] weights, int[] values, int n) {
        int[][] memo = new int[n + 1][capacity + 1];
        return knapsack(capacity, weights, values, n, memo);
    }

    public static int knapsack(int w, int[] wt, int[] vt, int n, int[][] memo) {
        if(w == 0 || n == 0)
            return 0;
        if(memo[n][w] != 0)
            return memo[n][w];

        int pickValue = 0;
        if(wt[n - 1] <= w) {
            pickValue = vt[n - 1] + knapsack(w- wt[n - 1], wt, vt, n - 1, memo);
        }
        int notPick = knapsack(w, wt, vt, n - 1, memo);

        return memo[n][w] = Math.max(pickValue, notPick);
    }
}
