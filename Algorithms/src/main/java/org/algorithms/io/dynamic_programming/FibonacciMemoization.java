package org.algorithms.io.dynamic_programming;

public class FibonacciMemoization {
    public static void main(String[] args) {
        var f = new FibonacciMemoization();
        System.out.println(f.fib(5));
        System.out.println(f.fibTabulation(5));
    }

    // Top Down Memoization approach
    // O(n) time and O(n) space
    public int fib(int n) {
        if(n == 0)
            return 0;
        int[] memoization = new int[n + 1];
        memoization[0] = 0;
        memoization[1] = 1;
        return fibMemoization(n, memoization);
    }

    public int fibMemoization(int n, int[] memoization) {
        if(n == 0 || n == 1)
            return n;
        if(memoization[n] != 0)
            return memoization[n];

        memoization[n] = fibMemoization(n - 1, memoization) + fibMemoization(n - 2, memoization);
        return memoization[n];
    }

    public int fibTabulation(int n) {
        if(n == 0)
            return n;

        var tabulation = new int[n + 1];
        tabulation[0] = 0;
        tabulation[1] = 1;

        for(int i = 2; i <= n; i++) {
            tabulation[i] = tabulation[i - 1] + tabulation[i - 2];
        }

        return tabulation[n];
    }
}
