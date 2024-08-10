package org.algorithms.io.arrays;

import java.util.HashMap;

public class MaxOperations {
    public static void main(String[] args) {
        var maxOp = new MaxOperations();
        System.out.println(
                maxOp.maxOperations(new int[]{
                        2, 5, 4, 4, 1, 3, 4, 4, 1, 4, 4, 1, 2, 1, 2, 2, 3, 2, 4, 2
                }, 3)
                // 2, 1
                // 1, 2
                // 1, 2
                // 1, 2
        );
    }

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
