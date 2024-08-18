package org.algorithms.io.amazon2k24;

import java.util.HashMap;

public class MajorityElement {
    public static void main(String[] args) {
    }

    // Time complexity O(n)
    // Space complexity O(n)
    public int majorityElement(int[] nums) {
        int moreThan = nums.length / 2;
        var count = new HashMap<Integer, Integer>();
        for(int i : nums) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }

        for(var key: count.keySet()) {
            var val = count.get(key);
            if(val > moreThan) {
                return key;
            }
        }

        return 0;
    }
}
