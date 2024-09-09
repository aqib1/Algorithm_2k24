package org.algorithms.io.amazon2k24;

public class Fib {

    // O(2^n) O(2 x 2 x 2 x 2 x 2) = 32 times
    // O(n)
    public int fibRec(int n) {
        if(n == 0 || n == 1)
            return n;

        return fibRec(n - 1) + fibRec(n - 2);
    }

    // time complexity is O(n), 5 times
    // O(n + 1) = O(n)
    public int fib(int n) {
        if(n == 0)
            return n;

        var memoization = new int[n + 1];
        memoization[0] = 0;
        memoization[1] = 1;
        for(int i = 2; i <= n; i++) {
            memoization[i] = memoization[i - 2] + memoization[i - 1];
        }

        return memoization[n];
    }
}
