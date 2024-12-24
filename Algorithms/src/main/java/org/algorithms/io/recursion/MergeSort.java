package org.algorithms.io.recursion;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        var merge = new MergeSort();
        int []aa = new int[] {3, 4, 1};
        merge.sortArray(aa);
        System.out.println(
                Arrays.toString(aa)
        );
    }
    public void sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int start, int end) {
        if(start >= end)
            return;
        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int f = mid - start + 1;
        int s = end - mid;
        int[] left = new int[f];
        int[] right = new int[s];

        for(int i = 0; i < f; i++) {
            left[i] = nums[i + start];
        }

        for(int i = 0; i < s; i++) {
            right[i] = nums[i + mid + 1];
        }

        int l = 0, r = 0, a = start;
        while(l < f && r < s) {
            if(left[l] < right[r]) {
                nums[a++] = left[l++];
            } else {
                nums[a++] = right[r++];
            }
        }

        while(l < f) {
            nums[a++] = left[l++];
        }

        while(r < s) {
            nums[a++] = right[r++];
        }
    }
}
