package org.algorithms.io.interviewPrep2k25.arrays;

import java.util.HashMap;

public class TwoSum {
    // Time complexity O(n) and space O(n)
    public int[] twoSum(int[] nums, int target) {
        var deltaByIndexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int delta = target - nums[i];
            if (deltaByIndexMap.containsKey(delta)) {
                return new int[]{i, deltaByIndexMap.get(delta)};
            } else {
                deltaByIndexMap.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}
