package org.algorithms.io.dynamic_programming;

public class FibonacciMemoization {
    public static void main(String[] args) {
        var f = new FibonacciMemoization();
        System.out.println(f.fib(0));
    }

    // Top Down Memoization approach
    // O(n) time and O(n) space
    public int fib(int n) {
        if(n == 0)
            return 0;
        int[] memoization = new int[n + 1];
        memoization[0] = 0;
        memoization[1] = 1;
        return fib(n, memoization);
    }

    public int fib(int n, int[] memoization) {
        if(n == 0 || n == 1)
            return n;
        if(memoization[n] != 0)
            return memoization[n];

        memoization[n] = fib(n - 1, memoization) + fib(n - 2, memoization);
        return memoization[n];
    }
}
