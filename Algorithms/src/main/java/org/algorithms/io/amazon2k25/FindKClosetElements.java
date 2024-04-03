package org.algorithms.io.amazon2k25;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKClosetElements {
    public static void main(String[] args) {
        var findK = new FindKClosetElements();
        System.out.println(
                findK.findClosestElementsUsingBinarySearch(
                        new int[] {1,2,3,4,5},
                        4,
                        3
                )
        );
    }

    // Time complexity On(logn) and space O(n)
    public List<Integer> findClosestElements(
            int[] arr,
            int k,
            int x
    ) {
            var res = new ArrayList<Integer>();
            var minHeap = new PriorityQueue<Integer>((a, b) -> {
                int a_abs = Math.abs(a - x);
                int b_abs = Math.abs(b - x);
                if(a_abs == b_abs)
                    return a - b;
                else return a_abs - b_abs;
            });

            for(int a: arr) {
                minHeap.offer(a);
            }

            for(int i = 0; i < k; i++) {
                res.add(minHeap.poll());
            }

            return res.stream().sorted().toList();
    }

    // Time complexity O(k) and space O(1)
    public List<Integer> findClosestElementsUsingBinarySearch(
            int[] arr, int k, int x) {
        var response = new ArrayList<Integer>(k);
        int left = 0;
        int right = arr.length - k;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        for(int i = left; i < left + k; i++) {
            response.add(arr[i]);
        }

        return response;
    }
}
