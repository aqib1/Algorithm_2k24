package org.algorithms.io.meta;

public class IsPowerTwo {
    public static void main(String[] args) {
        var is = new IsPowerTwo();
        System.out.println(is.isPowerOfTwo(14));
    }

    // Time complexity OLong(n)
    // Space complexity O(1)
    public boolean isPowerOfTwo(int n) {
        if(n == 0)
            return false;

        while(n % 2 == 0) n /= 2;

        return n == 1;
    }
}
