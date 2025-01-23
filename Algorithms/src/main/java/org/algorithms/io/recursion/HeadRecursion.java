package org.algorithms.io.recursion;

public class HeadRecursion {
    public static void main(String[] args) {
        var headRecursion = new HeadRecursion();

        headRecursion.head(5);
        // output = 1, 2, 3, 4, 5,
    }
    public void head(int n) {
        if(n == 0)
            return;

        head(n - 1);
        System.out.print(n + ", ");
    }
}
