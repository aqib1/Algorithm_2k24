package org.algorithms.io.amazon2k25.sort.quickSort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        var quickSort = new QuickSort();
        var data = new int[] {5, 4, 2, 1, 2, -8};
        quickSort.sort(data);

        System.out.println(Arrays.toString(data));
    }
    public void sort(int []data) {
        quickSort(data, 0, data.length - 1);
    }

    // Worst case O(N2) and Avg ON(logN) and space is O(1)
    public void quickSort(int[] data, int low, int high) {
        if(low < high) {
            int partition = lumotoPartition(data, low, high);

            quickSort(data, low, partition - 1);
            quickSort(data, partition + 1, high);
        }
    }

    private int lumotoPartition(int[] data, int low, int high) {
        int pivot = data[high];
        int i = low;

        for(int j = low; j <= high; j++) {
            if(data[j] < pivot) {
                swap(data, i, j);
                i++;
            }
        }

        swap(data, i, high);
        return i;
    }

    private void swap(int[] data, int i, int high) {
        int tmp = data[i];
        data[i] = data[high];
        data[high] = tmp;
    }
}
