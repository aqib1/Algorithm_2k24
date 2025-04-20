package org.algorithms.io.interviewPrep2k25.arrays;

import java.util.HashSet;

public class IntersectionArray {
    // Time complexity O(n) and space O(n)
    public int[] intersection(int[] nums1, int[] nums2) {
        var response = new HashSet<Integer>();
        var map = new HashSet<Integer>();

        for(int i: nums1) map.add(i);
        for(int i: nums2) if(map.contains(i)) response.add(i);

        var res = new int[response.size()];
        int index = 0;

        for(int i : response) res[index++] = i;

        return res;
    }
}
