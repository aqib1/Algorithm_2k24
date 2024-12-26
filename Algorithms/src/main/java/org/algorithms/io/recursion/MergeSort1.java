package org.algorithms.io.recursion;

import java.util.Arrays;

public class MergeSort1 {
    public static void main(String[] args) {
        var merge = new MergeSort1();
        int []data = new int[] {278, 18, 0, -1, 22};
        merge.mergeSort(data);

        System.out.println(Arrays.toString(data));
    }

    // Time complexity OLog(n)
    // Space complexity O(n)
    public void mergeSort(int[] nums) {
        if(nums.length <= 1)
            return;
        int mid = nums.length / 2;
        int []left = new int[mid];
        int []right = new int[nums.length - mid];

        System.arraycopy(nums, 0, left, 0, mid);
        System.arraycopy(nums, mid, right, 0, right.length);

        mergeSort(left);
        mergeSort(right);

        merge(nums, left, right);
    }

    private void merge(int[] nums, int[] left, int[] right) {
        int l = 0, r = 0, p = 0;
        while(l < left.length && r < right.length) {
            if(left[l] < right[r]) {
                nums[p++]  = left[l++];
            } else {
                nums[p++]  = right[r++];
            }
        }

        while(l < left.length) {
            nums[p++]  = left[l++];
        }

        while(r < right.length) {
            nums[p++]  = right[r++];
        }
    }
}
