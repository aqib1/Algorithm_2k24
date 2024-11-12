package org.algorithms.io.amazon2k24;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;
        while (start < end) {
            int sum = numbers[start] + numbers[end];
            if (sum == target)
                return new int[] { start + 1, end + 1 };
            if (sum > target) {
                end--;
            } else {
                start++;
            }
        }

        return null;
    }
}
