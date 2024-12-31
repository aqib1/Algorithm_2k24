package org.algorithms.io.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        var sort = new QuickSort();
        int[] data = new int[]{5, 2, 1, 2, 11, 0};
        sort.quickSort(data);
        System.out.println(Arrays.toString(data));
    }

    public void quickSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    // Time complexity OnLog(n)
    // Space complexity O(n)
    public void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);

            sort(arr, low, pivot - 1);
            sort(arr, pivot + 1, high);
        }
    }

    // lomuto partition
    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j <= high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
