package org.algorithms.io.amazon2k24;

public class ClimbStairs {
    public int climbStairsRecursion(int n) {
        if(n == 1 || n == 2)
            return n;
        return climbStairsRecursion(n - 2) + climbStairsRecursion(n - 1);
    }


}
