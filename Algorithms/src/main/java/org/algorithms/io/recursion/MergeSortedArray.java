package org.algorithms.io.recursion;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {
        var m = new MergeSortedArray();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        m.mergeRecursively(nums1, 3, nums2, 3);

        System.out.println(
                Arrays.toString(
                        nums1
                )
        );
    }

    public void mergeRecursively(int[] nums1, int m, int[] nums2, int n) {
        int[] merge = new int[nums1.length];

        mergeRecursively(merge, nums1, nums2, 0, 0, 0, m, n);

        System.arraycopy(merge, 0, nums1, 0, merge.length);
    }

    // Time complexity O(n+m) and space O(n+m)
    public void mergeRecursively(int[] merge, int[] nums1, int[] nums2, int i, int j, int index, int m, int n) {
        if (i >= m || j >= n) {
            while (j < n) {
                merge[index++] = nums2[j++];
            }

            while (i < m) {
                merge[index++] = nums1[i++];
            }

            return;
        }

        if (nums1[i] < nums2[j]) {
            merge[index++] = nums1[i++];
        } else {
            merge[index++] = nums2[j++];
        }

        mergeRecursively(merge, nums1, nums2, i, j, index, m, n);
    }

    // Time complexity O(n+m) and space O(n+m)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] merge = new int[nums1.length];
        int i = 0, j = 0, pointer = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                merge[pointer++] = nums1[i++];
            } else {
                merge[pointer++] = nums2[j++];
            }
        }

        while (i < m) {
            merge[pointer++] = nums1[i++];
        }

        while (j < n) {
            merge[pointer++] = nums2[j++];
        }

        System.arraycopy(merge, 0, nums1, 0, merge.length);
    }
}
