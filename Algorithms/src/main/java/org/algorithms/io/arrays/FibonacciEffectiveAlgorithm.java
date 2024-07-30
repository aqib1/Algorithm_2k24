package org.algorithms.io.arrays;

public class FibonacciEffectiveAlgorithm {
    public static void main(String[] args) {
        var f = new FibonacciEffectiveAlgorithm();

        System.out.println(f.fibonacci(9));
    }

    // Time complexity O(n)
    // Space complexity O(n)
    public int fibonacci(int n) {
        int [] fibonacci = new int[n];
        fibonacci[0] = 0;
        fibonacci[1] = 1;

        for(int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        return fibonacci[n - 1];
    }
}
