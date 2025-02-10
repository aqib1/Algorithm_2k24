package org.algorithms.io.sorting;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


public class FindKthLargestBigInteger {
    public static void main(String[] args) {
        var f = new FindKthLargestBigInteger();
        System.out.println(
            f.fastKthLargestNumber(
               new String[] {"3","6","7","10"},
               2
            )
        );
    }

    // Time complexity O(n) and space is O(k)
    public String fastKthLargestNumber(String[] nums, int k) {
        var queue = new PriorityQueue<String>(k, (a, b) -> {
            if(a.length() != b.length()) {
                return Integer.compare(a.length(), b.length());
            }
            return a.compareTo(b);
        });

        for(var num: nums) {
            queue.offer(num);
            if(queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }

    public String kthLargestNumber(String[] nums, int k) {
        if (k < 1 || k > nums.length)
            throw new IllegalArgumentException("k is out of bounds");

        List<BigInteger> data = new ArrayList<>(Arrays.stream(nums).map(BigInteger::new).toList());
        return quickSelect(data, 0, nums.length - 1, nums.length - k);
    }

    public static String quickSelect(List<BigInteger> nums, int start, int end, int k) {
        if(start == end) {
            return nums.get(start).toString();
        }

        int partition = lomutoPartition(nums, start, end, medianOfMedians(nums, start, end));

        if(partition == k) {
            return nums.get(partition).toString();
        }

        if(k < partition) {
            return quickSelect(nums, start, partition - 1, k);
        } else {
            return quickSelect(nums, partition + 1, end, k);
        }
    }

    public static void swap(List<BigInteger> nums, int i, int j) {
        BigInteger tmp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, tmp);
    }

    public static int lomutoPartition(List<BigInteger> nums, int low, int high, BigInteger pivotValue) {
        int pivotIndex = 0;
        for(int i = 0; i < nums.toArray().length; i++) {
            if(pivotValue.equals(nums.get(i))) {
                pivotIndex = i;
            }
        }
        swap(nums, pivotIndex, high);
        int i = low - 1;
        for(int j = low; j <= high; j++) {
            if(nums.get(j).compareTo(pivotValue) < 0) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, high);
        return i + 1;
    }

    public static void insertionSort(List<BigInteger> nums, int start, int end) {
        for(int ptr = start + 1; ptr <= end; ptr++) {
            var data = nums.get(ptr);
            int j = ptr - 1;
            while(j >= 0 && nums.get(j).compareTo(data) > 0) {
                nums.set(j + 1, nums.get(j));
                j--;
            }
            nums.set(j + 1, data);
        }
    }

    public static BigInteger medianOfMedians(List<BigInteger> nums, int start, int end) {
        int n = end - start + 1;
        if(n <= 5) {
            insertionSort(nums, start, end);
            return nums.get(start + n / 2);
        }

        int size = (n + 4) / 5;
        List<BigInteger> medians = new ArrayList<>(size);
        for(int i = 0; i < size; i++) {
            int subLeft = start + i * 5;
            int subEnd = Math.min(subLeft + 4, end);

            insertionSort(nums, subLeft, subEnd);

            medians.add(nums.get(subLeft + (subEnd - subLeft) / 2));
        }

        return medianOfMedians(medians, 0, size - 1);
    }
}
