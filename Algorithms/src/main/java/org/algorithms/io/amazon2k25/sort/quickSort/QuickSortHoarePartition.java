package org.algorithms.io.amazon2k25.sort.quickSort;

import java.util.Arrays;

public class QuickSortHoarePartition {
    public static void main(String[] args) {
        var quick = new QuickSortHoarePartition();
        var data = new int[]{5, 1, 3, 2, 4, -7};
        quick.sort(data);

        System.out.println(Arrays.toString(data));
    }

    public void sort(int[] data) {
        sort(data, 0, data.length - 1);
    }

    public void sort(int[] data, int left, int right) {
        if (left < right) {
            int partition = hoarePartition(data, left, right);

            sort(data, left, partition - 1);
            sort(data, partition + 1, right);
        }
    }

    private int hoarePartition(int[] data, int left, int right) {
        int pivot = data[left];
        int i = left;
        int j = right;

        while (true) {
            while (data[i] < pivot) i++;
            while (data[j] > pivot) j--;

            if (i >= j)
                return j;

            swap(data, i, j);
        }
    }

    private void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
