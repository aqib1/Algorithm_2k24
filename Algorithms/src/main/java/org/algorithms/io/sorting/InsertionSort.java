package org.algorithms.io.sorting;


import java.util.Arrays;
import java.util.function.BiPredicate;

// Time complexity O(n)2
// Space complexity O(1)
public class InsertionSort {
    public static void main(String[] args) {
        var insertionSort = new InsertionSort();
        var data = new int[]{1, 2, 3, 4, 5};

        insertionSort.insertionSort(
                data,
                (a, b) -> a < b
        );

        System.out.println(
                Arrays.toString(data)
        );
    }


    public void insertionSort(int[] arr, BiPredicate<Integer, Integer> rule) {
        for(int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while(j >= 0 && rule.test(arr[j], key)) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    // Time complexity O(n)2
    public void reverseInsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    public void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }
}
