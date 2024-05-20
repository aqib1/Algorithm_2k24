package org.algorithms.io.dynamic_programming;

public class RodCuttingProblemMemoization {
    public static void main(String[] args) {
        var rod = new RodCuttingProblemMemoization();
        System.out.println(rod.rodCut(new int[] {1, 5, 8, 9, 10, 17, 17, 20}));
    }

    // Time complexity O(p * c) and space complexity O(p * c)
    public int rodCut(int[] prices) {
        int cuts = prices.length;
        int[] memo = new int[cuts];

        return rodCut(prices, memo, cuts);
    }

    public int rodCut(int[] prices, int[] memo, int cuts) {
        if(cuts == 0)
            return 0;

        if(memo[cuts - 1] != 0)
            return memo[cuts - 1];

        int max = 0;

        for(int j = 1; j <= cuts; j++) {
            max = Math.max(max, prices[j - 1] + rodCut(prices, memo, cuts - j));
        }

        return memo[cuts - 1] = max;
    }
}
