package org.algorithms.io.revision;

import java.util.*;

public class ThreeSumWithoutSorting {
    public static void main(String[] args) {
        System.out.println(
                threeSum(new int[]{-1,0,1,2,-1,-4})
        );
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> capture = new HashSet<>();
        var seen = new HashSet<Integer>();
        var complementMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (seen.add(nums[i])) {
                for (int j = i + 1; j < nums.length; j++) {
                    int complement = -nums[i] - nums[j];

                    if (complementMap.containsKey(complement) &&
                            complementMap.get(complement) == i) {
                        var triplet = new ArrayList<>(
                                List.of(
                                        complement,
                                        nums[i],
                                        nums[j]
                                )
                        );
                        Collections.sort(triplet);
                        capture.add(triplet);
                    }

                    complementMap.put(nums[j], i);
                }
            }
        }

        return new ArrayList<>(capture);
    }
}
