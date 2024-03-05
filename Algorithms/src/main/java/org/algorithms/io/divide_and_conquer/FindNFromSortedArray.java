package org.algorithms.io.divide_and_conquer;

public class FindNFromSortedArray {
    public static void main(String[] args) {
        var f = new FindNFromSortedArray();
        System.out.println(
                f.binarysearch(
                        new int[] {0, 0, 1, 2, 3},
                        1
                )
        );
    }

    // Time complexity OLog(n) and space OLog(n)
    public int binarysearch(int[] arr, int k) {
        int start = 0, end = arr.length - 1;
        int found = -1;
        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(arr[mid] == k)
                found = mid;

            if(k <= arr[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }

        return found;
    }
}
