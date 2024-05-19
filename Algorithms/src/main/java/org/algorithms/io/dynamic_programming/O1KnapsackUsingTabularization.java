package org.algorithms.io.dynamic_programming;

public class O1KnapsackUsingTabularization {
    // Bottom up approach
    // time capacity O(n * w) and space is O(n * w)
    public int knapsack(int w, int[] val, int[] wt) {
        int n = val.length;
        var bucket = new int[n + 1][w + 1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <=w; j++) {
                if(wt[i - 1] > j) {
                    bucket[i][j] = bucket[i - 1][j];
                } else {
                    bucket[i][j] = Math.max(
                            bucket[i - 1][j],
                            bucket[i - 1][j - wt[i - 1]] + val[i - 1]
                    );
                }
            }
        }



        return bucket[n][w];
    }
}
