package org.algorithms.io.amazon2k24;

public class LongestSubsequentIncreasingOrderDp {
    public static void main(String[] args) {
        var l = new LongestSubsequentIncreasingOrderDp();
        System.out.println(l.lengthOfLIS(new int[] {10, 22, 9, 33, 21, 50, 41, 60, 80, 3}));
    }

    // Space is O(n)
    // Time is O(n2)
    public int lengthOfLIS(int[] nums) {
        var dp = new int[nums.length];
        var response = 0;

        for(int i = 0; i < dp.length; i++) {
            int len = 0;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    len = Math.max(len, dp[j]);
                }
            }

            dp[i] = len + 1;
            response = Math.max(response, dp[i]);
        }

        return response;
    }
}
