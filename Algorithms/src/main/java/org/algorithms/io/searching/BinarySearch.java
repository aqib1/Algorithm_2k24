package org.algorithms.io.searching;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySearchRec(
                new int[]{3, 1, 2, 11, 8, 12},
                2
        ));
    }

    public static int binarySearchRec(int[] container, int item) {
        Arrays.sort(container);

        return binarySearchRec(container, item, 0, container.length - 1);
    }

    public static int binarySearchRec(int[] container, int item, int left, int right) {
        if(right < left)
            return -1;
        int mid = left + (right - left) / 2;
        if(container[mid] == item) return item;

        if(item >= container[mid])
            return binarySearchRec(container, item, mid + 1 , right);
        else return binarySearchRec(container, item, left, mid - 1);
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
