package org.algorithms.io.amazon2k24.revision;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        var diffMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if(diffMap.containsKey(diff)) {
                return new int[] { diffMap.get(diff) , i };
            }

            diffMap.put(nums[i], i);
        }
        return null;
    }
}
