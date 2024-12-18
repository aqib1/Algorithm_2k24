package org.algorithms.io.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        var sort = new SelectionSort();
        var arr = new int[] {5, 4, 11, 2, 0, 33};
        sort.selectionSort(arr);
        System.out.println(
                Arrays.toString(
                        arr
                )
        );
    }
    public void selectionSort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int smallestValue = arr[i];
            int targetIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < smallestValue) {
                    targetIndex = j;
                    smallestValue = arr[j];
                }
            }
            if(targetIndex != i) {
                var tmp = arr[i];
                arr[i] = arr[targetIndex];
                arr[targetIndex] = tmp;
            }
        }
    }
}
