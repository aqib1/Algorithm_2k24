package org.algorithms.io.dynamic_programming;

public class RodCuttingProblemRecursive {
    public static void main(String[] args) {
        var rod = new RodCuttingProblemRecursive();
        System.out.println(rod.cutRod(new int[] {1, 5, 8, 9, 10, 17, 17, 20}));
    }

    public int cutRod(int[] price) {
        return cutRod(price, price.length);
    }

    // Time complexity O(2^n) and space is O(2^n)
    public int cutRod(int[] price, int cuts) {
        if(cuts == 0)
            return cuts;
        int max = 0;

        for(int j = 1; j <= cuts; j++) {
            max = Math.max(max, price[j - 1] + cutRod(price, cuts - j));
        }

        return max;
    }
}
