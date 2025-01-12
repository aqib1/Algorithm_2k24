package org.algorithms.io.bst;

import java.util.TreeSet;

public class ContainsNearbyAlmostDuplicate {

    public static void main(String[] args) {
       var c = new ContainsNearbyAlmostDuplicate();
        System.out.println(
                c.containsNearbyAlmostDuplicate(
                        new int[] {1,2,1,1},
                        1,
                        0
                )
        );
    }

    // Time complexity O(N*Log(K))
    // Space complexity O(K)
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            var redBlackTree = new TreeSet<Integer>();
            for(int i = 0; i < nums.length; i++) {
                // abs(nums[i] - nums[j]) <= valueDiff
                Integer successor = redBlackTree.ceiling(nums[i]);
                if(successor != null && Math.abs(nums[i] - successor) <= t)
                    return true;

                Integer predecessor = redBlackTree.floor(nums[i]);
                if(predecessor != null && Math.abs(predecessor - nums[i]) <= t)
                    return true;

                redBlackTree.add(nums[i]);
                if(redBlackTree.size() > k) {
                    redBlackTree.remove(nums[i - k]);
                }

            }
            return false;
    }
}
