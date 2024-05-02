package org.algorithms.io.top150;

import java.util.Arrays;

public class MergeSortedArray {
    // [1, 2, 3, 0, 0, 0]
    // [4, 5, 6]
    public static void main(String[] args) {
        var a1 = new int []{7, 8, 9, 0, 0, 0};
        var a2 = new int[] {4, 5, 6};

        merge(a1, 3, a2, 3);
        System.out.println(Arrays.toString(a1));
    }

    // Time complexity O(k) where k = m + n and space is O(1)
    public static void merge(int []arr, int m, int []arr1, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while(k >= 0) {
            if(j < 0)
                break;
            if(i >= 0 && arr[i] > arr1[j]) {
                arr[k] = arr[i--];
            } else {
                arr[k] = arr1[j--];
            }
            k--;
        }
    }
}
