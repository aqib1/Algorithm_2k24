package org.algorithms.io.interviewPrep2k25.hashing;

import java.util.HashSet;

public class ContainDuplicate {
    // Time complexity O(n) and space O(n)
    public boolean containsDuplicate(int[] nums) {
        var set = new HashSet<Integer>();
        for(int n: nums) {
            if(!set.add(n))
                return true;
        }
        return false;
    }
}
