package org.algorithms.io.dynamic_programming;

import java.util.Arrays;

public class FindTargetSumWaysMemoizationUsing2DArray {

    // Time O(2^n) and space is O(N * Sums(N))
    public static void main(String[] args) {
        var find = new FindTargetSumWaysMemoizationUsing2DArray();
        System.out.println(
                find.findTargetSumWays(
                        new int[] {1,1,1,1,1},
                        3
                )
        );
    }

    private int[][] dp;
    private int totalSum;
    public int findTargetSumWays(int[] nums, int target) {
        totalSum = Arrays.stream(nums).sum();
        dp = new int[nums.length][(totalSum * 2) + 1];
        for(int[] its : dp) {
            Arrays.fill(its, Integer.MIN_VALUE);
        }

        return find(nums, 0, 0, target);
    }

    public int find(int[] nums, int index, int current, int target) {
        if(index == nums.length) {
            return current == target ? 1 : 0;
        }
        if(dp[index][totalSum + current] != Integer.MIN_VALUE) {
            return dp[index][totalSum + current];
        }

        int sum = find(
                nums,
                index + 1,
                current + nums[index],
                target
        );

        int sub = find(
                nums,
                index + 1,
                current - nums[index],
                target
        );
        return dp[index][totalSum + current] = sum + sub;
    }
}
