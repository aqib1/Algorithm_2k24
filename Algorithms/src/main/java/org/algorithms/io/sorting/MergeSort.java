package org.algorithms.io.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        var m = new MergeSort();
        var data = new int[] {7, 9 , 11, 0, 3, 2};
        m.mergeSort(
                data, 0, data.length
        );

        System.out.println(
                Arrays.toString(data)
        );
    }

    // Time complexity OnLog(n)
    // Space complexity O(n)
    public void mergeSort(int []arr, int l, int r) {
        mergeSort(arr);
    }

    public void mergeSort(int []arr) {
        if(arr.length <= 1) return;

        int mid = arr.length / 2;
        int []left = new int[mid];
        int []right = new int[arr.length - mid];

        System.arraycopy(arr, 0, left, 0, left.length);
        System.arraycopy(arr, mid, right, 0, right.length);

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    private void merge(int[] arr, int[] left, int[] right) {
        int l = 0, r = 0, a = 0;
        while(l < left.length && r < right.length) {
            if(left[l] < right[r]) {
                arr[a++] = left[l++];
            } else {
                arr[a++] = right[r++];
            }
        }

        while (l < left.length) {
            arr[a++] = left[l++];
        }

        while (r < right.length) {
            arr[a++] = right[r++];
        }
    }
}
