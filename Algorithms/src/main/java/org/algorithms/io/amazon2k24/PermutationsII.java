package org.algorithms.io.amazon2k24;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PermutationsII {

  // Time complexity O(n!) and space O(n)
  public List<List<Integer>> permuteUnique(int[] nums) {
        var unique = new HashSet<List<Integer>>();
        permutation(unique, nums, 0, nums.length);
        return unique.stream().toList();
    }

    private void permutation(HashSet<List<Integer>> unique, int[] nums, int start, int end) {
        if(start == end) {
            unique.add(Arrays.stream(nums).boxed().toList());
        } else {
            for(int i = start; i < end; i++) {
                swap(nums, start, i);
                permutation(unique, nums, start + 1, end);
                swap(nums, start, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        var tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
