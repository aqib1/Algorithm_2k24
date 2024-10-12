package org.algorithms.io.number;


public class KthFactor {
    public static void main(String[] args) {
        System.out.println(kthFactor(6, 4));
    }

    // time complexity O(N / 2) and space is O(1)
    public static int kthFactor(int n, int k) {
        if(k == 1) return 1;
        k--;

        for(int i = 2; i < (n + 2) / 2; i++) {
            if(n % i == 0) {
                if(--k == 0) return i;
            }
        }

        if(k == 1) return n;

        return -1;
    }
}
