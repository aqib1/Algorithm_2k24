package org.algorithms.io.math;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int number = 0;
        for(int n: nums) number ^= n;
        return number;
    }
}
