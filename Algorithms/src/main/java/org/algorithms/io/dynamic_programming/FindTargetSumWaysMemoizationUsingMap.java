package org.algorithms.io.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class FindTargetSumWaysMemoizationUsingMap {
    private Map<String, Integer> memo;

    // Time & space complexity O(2^n)
    public int findTargetSumWays(int[] nums, int target) {
        memo = new HashMap<>();
        return find(nums, target, 0);
    }

    private int find(int[] nums, int target, int index) {
        if (index == nums.length)
            return target == 0 ? 1 : 0;

        var key = target + " , " + index;
        if(memo.containsKey(key))
            return memo.get(key);

        int sum = find(nums, target + nums[index], index + 1)
                + find(nums, target - nums[index], index + 1);
        memo.put(key, sum);
        return sum;
    }
}
