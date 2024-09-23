package org.algorithms.io.number;

public class FindKthNumber {
    public static void main(String[] args) {
        System.out.println(
                findKthNumber(804289384, 42641503)
        );
    }

    public static int findKthNumber(int n, int k) {
        int current = 1;
        k--;

        while(k > 0) {
            var steps = stepCount(n + 1, current);
            if(steps <= k) {
                current += 1;
                k -= steps;
            } else {
                // move down
                current *= 10;
                k--;
            }
        }

        return current;
    }

    public static int stepCount(int limit, int current) {
        long curr = current;
        long next = current + 1;
        int count = 0;

        while(curr <= limit) {
            count += Math.min(limit, next) - curr;
            next *= 10;
            curr *= 10;
        }
        return count;
    }
}
