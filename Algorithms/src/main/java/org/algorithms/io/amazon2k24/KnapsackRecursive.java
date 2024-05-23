package org.algorithms.io.amazon2k24;


public class KnapsackRecursive {
    public static void main(String[] args) {
        var k = new KnapsackRecursive();
        System.out.println(
                k.knapsack(4, new int[] {1, 2, 3}, new int[] {4, 5, 1})
        );
    }

    // Time complexity O(2^n) and space O(2^n) - Top-down approach
    public int knapsack(int w, int[] val, int[] wt) {
        return knapsack(w, val, wt, val.length);
    }

    public int knapsack(int w, int[] val, int[] wt, int n) {
        if(w == 0 || n == 0)
            return 0;

        int pickValue = 0;
        if(wt[n - 1] <= w) {
            pickValue = val[n - 1] + knapsack(w - wt[n - 1], val, wt, n - 1);
        }

        int notPick = knapsack(w, val, wt, n - 1);

        return Math.max(pickValue, notPick);
    }
}
