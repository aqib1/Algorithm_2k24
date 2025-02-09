package org.algorithms.io.sorting;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

// Find kth the largest integer using quick-select algorithm
// Time-complexity
// Best-case O(n)
// Worst-case O(n^2)
// Average-case O(n)
// Space complexity O(1)
public class FindKthLargestInteger {
    public static void main(String[] args) {
        System.out.println(kthLargestNumber(
                new String[] {"2","21","12","1"},
                3
        ));
    }

    public static String kthLargestNumber(String[] nums, int k) {
        List<BigInteger> data = Arrays.stream(nums).map(BigInteger::new).toList();
        return quickSelect(data,nums.length - k, 0, nums.length - 1);
    }

    private static String quickSelect(List<BigInteger> nums, int k, int low, int high) {
        int pivot = lomutoPivot(nums, low, high);

        if(pivot == k) {
            return nums.get(pivot).toString();
        }

        if(pivot < k) {
            return quickSelect(nums, k, pivot + 1, high);
        } else
            return quickSelect(nums, k, low, pivot - 1);
    }

    private static int lomutoPivot(List<BigInteger> nums, int low, int high) {
        var pivot = nums.get(high);// move pivot to high index
        int i = low - 1;
        for (int j = low; j <= high; j++) {
            if(nums.get(j).compareTo(pivot) < 0) {
                i++;
                swap(nums, i, j);
            }
        }

        swap(nums, i + 1, high);
        return i + 1;
    }

    private static void swap(List<BigInteger> nums, int i, int j) {
        var tmp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, tmp);
    }
}
