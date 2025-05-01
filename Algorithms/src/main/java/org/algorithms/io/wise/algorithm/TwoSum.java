package org.algorithms.io.wise.algorithm;

import java.util.HashMap;

public class TwoSum {

    // Time O(n) and space O(n)
    public int[] twoSum(int[] nums, int target) {
        var deltaByIndex = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++) {
            int delta = target - nums[i];
            if(deltaByIndex.containsKey(delta)) {
                return new int[] {i, deltaByIndex.get(delta)};
            }

            deltaByIndex.put(nums[i], i);
        }

        return new int[] {};
    }
}
