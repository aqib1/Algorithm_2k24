package org.algorithms.io.amazon2k24.revision;

import java.util.Arrays;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        return ((nums.length * (nums.length + 1)) / 2)  - Arrays.stream(nums).sum();
    }
}
