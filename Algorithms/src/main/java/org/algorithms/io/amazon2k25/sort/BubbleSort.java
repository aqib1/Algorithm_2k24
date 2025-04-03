package org.algorithms.io.amazon2k25.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        var sort = new BubbleSort();
        var data = new int[] {5, 3, 1, 0, -5, 4};
        sort.sort(data);
        System.out.println(Arrays.toString(data));
    }

    // Time complexity O(n2) and space O(1)
    public void sort(int[] arr) {
        if(arr.length == 0)
            return;
        int limit = arr.length - 1;
        while(limit >= 0) {
            for(int i = 0; i < limit; i++) {
                if(arr[i] > arr[i + 1]) {
                    int tmp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = tmp;
                }
            }
            limit--;
        }
    }
}
