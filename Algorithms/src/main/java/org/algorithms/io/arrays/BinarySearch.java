package org.algorithms.io.arrays;

public class BinarySearch {
    public static void main(String[] args) {
        var bs = new BinarySearch();

        System.out.println(bs.binarySearch(
                new int[] {-1, 0 , 3, 5, 9, 12},
                -1
        ));

    }
    public int binarySearch(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;
        int current = (start + end) / 2;

        while(start <= end) {
            if(array[current] == target)
                return current;

            if(array[current] > target) {
                end = current - 1;
            } else {
                start = current + 1;
            }
            current = (start + end) / 2;
        }

        return -1;
    }
}
