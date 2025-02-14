package org.algorithms.io.recursion;

public class FibonacciUsingTailRecursion {
    public static int tail(int n, int a, int b) {
        if(n == 0)
            return a;
        if(n == 1)
            return b;

        return tail(n - 1, b, a + b);
    }

    public static void main(String[] args) {
        int n = 9;
        System.out.println(
                tail(n, 0, 1)
        );
    }
}
