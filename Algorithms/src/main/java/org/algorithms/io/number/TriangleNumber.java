package org.algorithms.io.number;

public class TriangleNumber {

    public static void main(String[] args) {
        var t = new TriangleNumber();
        System.out.println(t.triangle(
                7
        ));
    }

    public int triangle(int n) {
        if(n == 1) return 1;

        return n + triangle(n - 1);
    }

    public int squaresInTriangle(int n) {
        int squares = 0;
        int count = 1;
        for(int x=0; x<n; x++) {
            squares += count;
            count++;
        }

        return squares;
    }

}
