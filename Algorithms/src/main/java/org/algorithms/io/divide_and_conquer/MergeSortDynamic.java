package org.algorithms.io.divide_and_conquer;

import java.util.Arrays;
import java.util.function.BiPredicate;

public class MergeSortDynamic {
    private int[] data;
    private int[] temp;
    private BiPredicate<Integer, Integer> rule;

    // Time complexity O
    public static void main(String[] args) {
        var m = new MergeSortDynamic();
        var data = new int[] {5, 3, 1, 8, 9, 0, 10};
        m.mergeSort(data, (a, b) -> a > b);
        System.out.println(Arrays.toString(data));
    }

    public void mergeSort(int[] data, BiPredicate<Integer, Integer> rule) {
        this.data = data;
        this.temp = new int[data.length];
        this.rule = rule;
        mergeSort(0, data.length - 1);
    }

    public void mergeSort(int left, int right) {
        if(left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(left, mid);
        mergeSort(mid + 1, right);

        merge(left, mid, right);
    }

    public void merge(int left, int mid, int right) {
        for(int i = left; i <= right; i++) {
            temp[i] = data[i];
        }
        int i = left;
        int k = left;
        int j = mid + 1;

        while(i <= mid && j <= right) {
            if(rule.test(temp[i], temp[j])) {
                data[k++] = temp[i++];
            } else {
                data[k++] = temp[j++];
            }
        }

        while(i <= mid) {
            data[k++] = temp[i++];
        }

        while(j <= right) {
            data[k++] = temp[j++];
        }
    }
}
