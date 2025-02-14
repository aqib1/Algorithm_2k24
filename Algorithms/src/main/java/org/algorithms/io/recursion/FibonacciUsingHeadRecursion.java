package org.algorithms.io.recursion;

public class FibonacciUsingHeadRecursion {
    public static void main(String[] args) {
        System.out.println(fibonacci(9));
    }
    public static int fibonacci(int n) {
        if(n == 0 || n == 1)
            return n;

        int last = fibonacci(n - 1);
        int secondLast = fibonacci(n - 2);

        return last + secondLast;
    }
}
