package org.algorithms.io.recursion;

public class TowerOfHanoi2 {
    private int count;

    // Time complexity
    public int towerOfHanoi(int n, int from, int to, int aux) {
        if(n == 0) return count;

        // O(n-1) * O(n-1) + 1
        // 2 * O(n-1) + 1
        // O(2^n)
        towerOfHanoi(n - 1, from, aux, to);
        // O(1)
        count++;
        //System.out.println("move disk " + n + " from rod " + from + " to rod " + to);
        towerOfHanoi(n - 1, aux, to, from);

        return count;
    }
}
