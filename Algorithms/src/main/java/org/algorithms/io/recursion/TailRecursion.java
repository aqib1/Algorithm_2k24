package org.algorithms.io.recursion;

public class TailRecursion {
    public static void main(String[] args) {
        var tailRecursion = new TailRecursion();
        tailRecursion.tail(5);
        // output = 5, 4, 3, 2, 1,
    }
    public void tail(int n) {
        if(n == 0)
            return;

        System.out.print(n + ", ");

        tail(n - 1);
    }
}
