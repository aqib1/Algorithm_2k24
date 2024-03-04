package org.algorithms.io.divide_and_conquer;

public class BinarySearch {
    public static void main(String[] args) {
        var b = new BinarySearch();
        System.out.println(
                b.find(
                        new int[] {0, 0, 0, 0, 0},
                        0,
                        4,
                        0
                )
        );
    }

    // Time complexity OLog(n) and space OLog(n)
    public int find(int [] container, int left, int right, int item) {
        if(left > right)
            return -1;

        int mid = left + (right - left) / 2;

        if(container[mid]  == item)
            return mid;

        if(item < container[mid]) {
            return find(container, left, mid - 1, item);
        } else
            return find(container, mid + 1, right, item);
    }

}
