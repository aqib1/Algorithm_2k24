package org.algorithms.io.interviewPrep2k25.sorting;


import java.util.Arrays;
import java.util.function.BiPredicate;

public class MergeSortDynamic {
    // Time complexity O(nLogn) and space complexity O(n)
    public static void main(String[] args) {
        var m = new MergeSortDynamic();
        var data = new int[] {5, 3, 1, 8, 9, 0, 10};
        m.mergeSort(data, (a, b) -> a < b);
        System.out.println(Arrays.toString(data));
    }

    private BiPredicate<Integer, Integer> test;
    private int[] data;
    private int[] tmp;
    public void mergeSort(
            int[] data,
            BiPredicate<Integer, Integer> test
    ) {
        this.data = data;
        this.tmp = new int[data.length];
        this.test = test;
        mergeSort(0, data.length - 1);
    }

    public void mergeSort(int start, int end) {
        if(start >= end)
            return;

        int mid = start + (end - start) / 2;
        mergeSort(start, mid);
        mergeSort(mid + 1, end);

        merge(start, mid, end);
    }

    public void merge(int start, int mid, int end) {
        for(int i = start; i <= end; i++) {
            tmp[i] = data[i];
        }

        int i = start;
        int k = start;
        int j = mid + 1;

        while(i <= mid && j <= end) {
            if(test.test(tmp[i], tmp[j])) {
               data[k++] =  tmp[i++];
            } else {
                data[k++] =  tmp[j++];
            }
        }

        while(i <= mid) {
            data[k++] =  tmp[i++];
        }

        while(j <= end) {
            data[k++] =  tmp[j++];
        }
    }
}
