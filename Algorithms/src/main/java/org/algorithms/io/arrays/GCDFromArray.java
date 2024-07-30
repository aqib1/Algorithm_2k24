package org.algorithms.io.arrays;

import java.util.Arrays;

public class GCDFromArray {
    public static void main(String[] args) {
        var gcd = new GCDFromArray();
        System.out.println(
                gcd.findGCD(
                        new int [] {
                                2, 5, 6, 9, 10
                        }
                )
        );
    }

    // Time complexity O(N+M) = O2(N) = O(N)
    // Space complexity O(1)
    public int findGCD(int[] nums) {
        var min = Arrays.stream(nums).min().orElse(-1);
        var max = Arrays.stream(nums).max().orElse(-1);
        var gcd = 0;
        for(int d = 1; d < (min + max); d++) {
            if((min % d == 0) && (max % d == 0)) {
                if(d > gcd)
                    gcd = d;
            }
        }
        return gcd;
    }
}
