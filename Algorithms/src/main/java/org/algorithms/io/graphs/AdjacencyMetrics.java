package org.algorithms.io.graphs;

import java.util.Arrays;

public class AdjacencyMetrics {
    private static final int[][] metrics = new int[][] {
            {0, 2, 4, 0},
            {0, 0, 0, 3},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
    };

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(metrics));
    }
}
