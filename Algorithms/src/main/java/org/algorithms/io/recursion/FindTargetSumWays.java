package org.algorithms.io.recursion;

public class FindTargetSumWays {
    // Time & space complexity O(2^n)
    public int findTargetSumWays(int[] nums, int target) {
        return find(nums, target, 0);
    }

    public int find(int[] nums, int target, int n) {
        if(n == nums.length) {
            if(target == 0)
                return 1;
            else
                return 0;
        }

        return find(nums, target + nums[n], n + 1)
                + find(nums, target - nums[n], n + 1);
    }
}
