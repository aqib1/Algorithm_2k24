package org.algorithms.io.meta;

import java.util.*;

public class KthLargestUsingBS {

    public static void main(String[] args) {
        var kth = new KthLargestUsingBS(
                3,
                new int[] {4, 5, 8, 2}
        );

        System.out.println(kth.add(3));
        System.out.println(kth.add(5));
        System.out.println(kth.add(10));
        System.out.println(kth.add(9));
        System.out.println(kth.add(4));
    }

    private final int k;
    private final List<Integer> nums;

    public KthLargestUsingBS(int k, int[] nums) {
        this.k = k;
        this.nums = new ArrayList<>(Arrays.stream(nums).boxed().toList());
        this.nums.sort(Comparator.reverseOrder());
    }

    public int add(int val) {
        int index = binarySearch(val);
        nums.add(index, val);
        return nums.get(k - 1);
    }

    private int binarySearch(int val) {
        int left = 0;
        int right = nums.size() - 1;
        while(left <= right) {
            int mid =  left + (right - left) / 2;
            if(nums.get(mid) == val) {
                return mid;
            }

            if(nums.get(mid) < val) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
