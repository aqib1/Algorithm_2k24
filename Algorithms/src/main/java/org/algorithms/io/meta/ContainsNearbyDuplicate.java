package org.algorithms.io.meta;

import java.util.HashMap;

public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length == 1) return false;
        var map = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]) && Math.abs(i - map.get(nums[i])) <= k) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }

        return false;
    }
}
