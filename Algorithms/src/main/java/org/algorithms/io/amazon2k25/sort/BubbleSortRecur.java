package org.algorithms.io.amazon2k25.sort;

import java.util.Arrays;

public class BubbleSortRecur {

    public static void main(String[] args) {
        var b = new BubbleSortRecur();
        var data = new int[] {5, 6, 1, -1, 0, 22};
        b.sort(data);
        System.out.println(Arrays.toString(data));
    }

    public void sort(int []arr) {
        sort(arr, 0, arr.length - 1);
    }

    public void sort(int[] arr, int start, int end) {
        if(end < 0)
            return;
        if(start >= end)
            return;

        if(arr[start] > arr[start + 1]) {
            int tmp = arr[start + 1];
            arr[start + 1] = arr[start];
            arr[start] = tmp;
        }

        sort(arr, start + 1, end);
        sort(arr, 0, end - 1);
    }
}
