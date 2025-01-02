package org.algorithms.io.arrays;

import java.util.HashMap;

public class CountSubArrays {
    public static void main(String[] args) {
        var count = new CountSubArrays();
        System.out.println(
                count.countSubarrays(
                        new int[] {10, 2, -2, -20, 10},
                        -10
                )
        );
    }

    // time complexity O(n)
    // space complexity O(n)
    public int countSubarrays(int []arr, int k) {
        int count = 0;
        int sum = 0;
        var prefixSum = new HashMap<Integer, Integer>();
        for (int j : arr) {
            prefixSum.put(
                    sum,
                    prefixSum.getOrDefault(sum, 0) + 1
            );
            sum += j;
            if(prefixSum.containsKey(sum - k))
                count += prefixSum.get(sum - k);
        }
        return count;
    }
}
