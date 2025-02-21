package org.algorithms.io.amazon2k24;

public class ClimbStairs {
    // Time complexity O(2^n)
    // Space complexity O(n)
    public int climbStairsRecursion(int n) {
        if(n == 1 || n == 2)
            return n;
        return climbStairsRecursion(n - 2) + climbStairsRecursion(n - 1);
    }

    // Using memorization technique of dynamic programming
    // Time complexity O(n)
    // Space complexity O(n)
    public int climbStairsMemorization(int n) {
        var memorization = new Integer[n + 1];
        return climbStairsMemorization(n, memorization);
    }

    public int climbStairsMemorization(int n, Integer[] memorization) {
        if(n == 1 || n == 2)
            return n;
        if(memorization[n] != null)
            return memorization[n];

        memorization[n] = climbStairsMemorization(n - 1, memorization) + climbStairsMemorization(n - 2, memorization);
        return memorization[n];
    }

    // Using Tabularization dynamic programming.
    // Time complexity O(n)
    // Space O(n)
    public int climbStairsTabularization(int n) {
        if(n == 1)
            return 1;
        var dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <=n ; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }
}
