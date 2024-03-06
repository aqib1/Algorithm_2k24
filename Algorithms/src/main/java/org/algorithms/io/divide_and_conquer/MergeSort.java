package org.algorithms.io.divide_and_conquer;

import java.util.Arrays;

public class MergeSort {
    private int[] tempArray;
    private int[] array;

    // Time complexity OnLog(n) and space is O(n)
    public static void main(String[] args) {
        var merge = new MergeSort();
        var data = new int[] {3, 4, 1, 2, 0, 99};
        merge.mergeSort(data, 0, data.length);

        System.out.println(Arrays.toString(data));
    }

    void mergeSort(int arr[], int l, int r) {
        this.array = arr;
        this.tempArray = new int[arr.length];
        l = 0;
        r = this.array.length - 1;

        mergeSort(l, r);
    }

    void mergeSort(int start, int end) {
        if(start >= end)
            return;
        int mid = start + (end - start) / 2;
        mergeSort(start, mid);
        mergeSort(mid + 1, end);

        merge(start, mid, end);
    }

    void merge(int start, int mid, int end) {
        for(int i = start; i <= end; i++)
            tempArray[i] = array[i];
        int k = start;
        int i = start;
        int j = mid + 1;
        while(i <= mid && j <= end) {
            if(tempArray[i] < tempArray[j]) {
                array[k] = tempArray[i++];
            } else {
                array[k] = tempArray[j++];
            }
            k++;
        }

        while(i <= mid) {
            array[k++] = tempArray[i++];
        }

        while(j <= end) {
            array[k++] = tempArray[j++];
        }
    }
}
