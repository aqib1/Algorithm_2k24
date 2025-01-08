package org.algorithms.io.revision;

import java.util.Arrays;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        return ((nums.length * (nums.length + 1)) / 2)  - Arrays.stream(nums).sum();
    }
}
