package org.algorithms.io.amazon2k24;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        var minCost = new MinCostClimbingStairs();
        System.out.println(
                minCost.minCostClimbingStairs(
                        new int[] {1, 3, 2, 5, 6, 10, 4}
                )
        );
    }


    public int minCostClimbingStairs(int[] cost) {
        if(cost.length < 3) {
            return Math.min(cost[0], cost[1]);
        }
        var dp = new int[cost.length + 1];
        for(int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }

        return dp[cost.length];
    }
}
