package org.algorithms.io.searching;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySearch(
                new int[]{3, 1, 2, 11, 8, 12},
                123
        ));
    }

    public static int binarySearch(int[] container, int item) {
        Arrays.sort(container);
        int left = 0;
        int right = container.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (item == container[mid]) return item;

            if (item >= container[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
