package org.algorithms.io.amazon2k24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllPermutations {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3, 4}));
    }

    // Time complexity O(n!) and space complexity O(n)
    public static List<List<Integer>> permute(int[] nums) {
        if (nums == null) return new ArrayList<>();
        List<List<Integer>> permutation = new ArrayList<>();
        findPermutation(nums, permutation, 0, nums.length);
        return permutation;
    }

    private static void findPermutation(int[] nums, List<List<Integer>> permutation, int i, int j) {
        if (i == j)
            permutation.add(Arrays.stream(nums).boxed().toList());
        else
            for (int a = i; a < j; a++) {
                swap(nums, i, a);
                findPermutation(nums, permutation, i + 1, j);
                swap(nums, i, a);
            }
    }

    private static void swap(int[] nums, int i, int a) {
        var tmp = nums[i];
        nums[i] = nums[a];
        nums[a] = tmp;
    }
}
