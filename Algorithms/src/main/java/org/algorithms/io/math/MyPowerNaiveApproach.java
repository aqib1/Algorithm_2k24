package org.algorithms.io.math;

public class MyPowerNaiveApproach {
    // Time complexity O(n)
    // Space complexity O(1)
    public int pow(int a, int pow) {
        int x = a;
        for(int i = 2; i <= pow; i++)
            x *= a;
        return x;
    }
}
