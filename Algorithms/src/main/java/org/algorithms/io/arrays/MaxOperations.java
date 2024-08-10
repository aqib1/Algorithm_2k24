package org.algorithms.io.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class MaxOperations {
    public static void main(String[] args) {
        var maxOp = new MaxOperations();
        System.out.println(
                maxOp.maxOperationsWithoutExtraSpace(new int[]{
                        2, 5, 4, 4, 1, 3, 4, 4, 1, 4, 4, 1, 2, 1, 2, 2, 3, 2, 4, 2
                }, 3)
        );
    }

    // Time complexity NLog(N)
    // Space complexity O(1)
    public int maxOperationsWithoutExtraSpace(int[] nums, int k) {
        if(Objects.isNull(nums) || (nums.length == 1 && nums[0] < k)) {
            return 0;
        }
        Arrays.sort(nums);
        int pairs = 0, start = 0, end = nums.length - 1;
        while(start < end) {
            int sum = nums[start] + nums[end];
            if(sum == k) {
                pairs++;
                start++;
                end--;
            } else if(sum < k) {
                start++;
            } else {
                end--;
            }
        }
        return pairs;
    }

    // Time complexity O(N) + O(N) = O2(N) = O(N)
    // Space complexity O(N)
    public int maxOperations(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        int pair = 0;
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        var keys = map.keySet();
        for (int i : nums) {
            int diff = k - i;
            if (map.get(i) > 0 && ((diff == i && map.get(diff) > 1) ||
                    (diff != i && keys.contains(diff) && map.get(diff) > 0))
            ) {
                pair++;
                map.put(diff, map.get(diff) - 1);
                map.put(i, map.get(i) - 1);

            }
        }

        return pair;
    }
}
