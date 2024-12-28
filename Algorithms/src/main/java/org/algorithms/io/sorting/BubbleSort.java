package org.algorithms.io.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        var sort = new BubbleSort();
        var arr = new int[] {5, 3, 1, 3, 11};
        sort.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // Time complexity O(n)2
    // Space complexity O(1)
    public void bubbleSort(int []arr) {
        int limit = arr.length - 1;
        while(limit >= 0) {
            for(int i = 0; i < limit; i++) {
                if(arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
            limit--;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
