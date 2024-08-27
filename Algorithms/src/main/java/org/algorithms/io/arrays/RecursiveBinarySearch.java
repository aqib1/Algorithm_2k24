package org.algorithms.io.recursion;

public class RecursiveBinarySearch {
    public static void main(String[] args) {
        System.out.println(
                search(
                        new int[] {-1,0,3,5,9,12},
                        9
                )
        );
    }
    public static int search(int[] array, int target) {
        return search(array, 0, array.length - 1, target);
    }

    // Time complexity O(n * Log(n)) and space complexity O(n * Log(n)) due to method storage in stack
    public static int search(int[] array, int start, int end, int target) {
        if(start > end) return -1;
        int mid = (start + end) / 2;

        if(array[mid] == target)
            return mid;
        else if(array[mid] > target) {
            return search(array, start, mid - 1, target);
        } else {
            return search(array, mid + 1, end, target);
        }
    }
}
