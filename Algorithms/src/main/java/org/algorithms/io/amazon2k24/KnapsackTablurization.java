package org.algorithms.io.amazon2k24;

public class KnapsackTablurization {

    // Time complexity O(n * w) and space O(n * w) with bottom-up approach
    public int knapsack(int w, int[] val, int[] wt) {
        int n = val.length;
        int[][] tab = new int[n + 1][w + 1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= w; j++) {
                if(j < wt[i - 1]) {
                    // get number from one row up
                    tab[i][j] = tab[i - 1][j];
                } else {
                    // use formula
                    tab[i][j] = Math.max(tab[i - 1][j], val[i - 1] + tab[i - 1][j - wt[i - 1]]);
                }
            }
        }

        return tab[n][w];
    }
}
