package org.algorithms.io.dynamic_programming;

import java.util.Arrays;

public class KnapsackRecursion {
    public static void main(String[] args) {
        var knapsack = new KnapsackRecursion();
        System.out.println(
                knapsack.knapsack(4, new int[] {1, 2, 3}, new int[] {4, 5, 1})
        );
    }

    // Naive approach Time complexity O(2^n) and O(n) space
    public int knapsack(
            int w, int []val, int []wt
    ) {
        return knapsack(w, val, wt, val.length);
    }

    public int knapsack(int w, int []val, int []wt, int n) {
        if(w == 0 || n == 0)
            return 0;
        int pick = 0;
        if(wt[n - 1] <= w) {
            pick = val[n - 1] + knapsack(w - wt[n - 1], val, wt, n - 1);
        }

        int notPick = knapsack(w, val, wt, n - 1);

        return Math.max(pick, notPick);
    }
}
