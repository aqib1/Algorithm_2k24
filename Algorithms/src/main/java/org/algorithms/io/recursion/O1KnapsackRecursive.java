package org.algorithms.io.recursion;

public class O1KnapsackRecursive {
    // Time complexity and space O(2^n)
    public static int findKnapsack(int w, int[] wt, int[] values) {
        return knapsack(w, wt, values, values.length);
    }

    public static int knapsack(int w, int[] wt, int[] values, int n) {
        if(n == 0 || w == 0)
            return 0;
        int pickValue = 0;
        if(wt[n - 1] <= w) {
            pickValue = values[n - 1] + knapsack(w - wt[n - 1], wt, values, n - 1);
        }

        int notPickValue = knapsack(w, wt, values, n - 1);

        return Math.max(pickValue, notPickValue);
    }
}
