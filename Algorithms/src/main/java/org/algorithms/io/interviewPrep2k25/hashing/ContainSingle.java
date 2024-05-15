package org.algorithms.io.interviewPrep2k25.hashing;

import java.util.HashMap;
import java.util.Map;

public class ContainSingle {
    // Time complexity O(n) and space complexity O(n)
    public int singleNumber(int[] nums) {
        var count = new HashMap<Integer, Integer>();
        for(int i: nums)
            count.put(i, count.getOrDefault(i, 0) + 1);
        return count.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(-1);
    }
}
