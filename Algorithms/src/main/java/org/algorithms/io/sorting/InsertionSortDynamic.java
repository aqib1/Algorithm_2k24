package org.algorithms.io.sorting;

import java.util.Arrays;
import java.util.function.BiPredicate;

public class InsertionSortDynamic {
    public static void main(String[] args) {
        var i = new InsertionSortDynamic();
        int[] data = {3, 1, -2, 8, -6, 2, 188};
        i.insertionSort(data, (a, b) -> a > b);

        System.out.println(Arrays.toString(data));
    }

    // Time complexity O(n)2
    // Space complexity O(1)
    public void insertionSort(int[] arr, BiPredicate<Integer, Integer> comp) {
        for (int a = 1; a < arr.length; a++) {
            int tmp = arr[a];
            int b = a - 1;
            while (b >= 0 && comp.test(arr[b], tmp)) {
                arr[b + 1] = arr[b];
                b--;
            }
            arr[b + 1] = tmp;
        }
    }
}
