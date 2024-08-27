package org.algorithms.io.recursion;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int []merge = new int[nums1.length];
        int i = 0, j = 0, pointer = 0;
        while(i < m && j < n) {
            if(nums1[i] < nums2[j]) {
                merge[pointer++] = nums1[i++];
            } else {
                merge[pointer++] = nums2[j++];
            }
        }

        while(i < m) {
            merge[pointer++] = nums1[i++];
        }

        while(j < n) {
            merge[pointer++] = nums2[j++];
        }

        System.arraycopy(merge, 0, nums1, 0, merge.length);
    }
}
