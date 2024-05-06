package org.algorithms.io.amazon2k25.sort.mergeSort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        var m = new MergeSort();
        var data = new int[] {5, 3, 1, 8, 9, 0, 10};
        m.sort(data);
        System.out.println(Arrays.toString(data));
    }

    private int[] data;
    private int[] tmp;
    public void sort(int [] data) {
        this.data = data;
        this.tmp = new int[data.length];

        mergeSort(data, 0, data.length - 1);
    }

    public void mergeSort(int[] data, int start, int end) {
        if(start >= end)
            return;

        int mid = start + (end - start) / 2;
        mergeSort(data, start, mid);
        mergeSort(data, mid + 1, end);

        merge(start, mid, end);
    }

    public void merge(int start, int mid, int end) {
        if (end + 1 - start >= 0)
            System.arraycopy(data, start, tmp, start, end + 1 - start);

        int i = start;
        int k = start;
        int j = mid + 1;

        while(i <= mid && j <= end) {
            if(tmp[i] <= tmp[j]) {
                data[k++] = tmp[i++];
            } else {
                data[k++] = tmp[j++];
            }
        }

        while(i <= mid) {
            data[k++] = tmp[i++];
        }

        while(j <= end) {
            data[k++] = tmp[j++];
        }
    }
}
