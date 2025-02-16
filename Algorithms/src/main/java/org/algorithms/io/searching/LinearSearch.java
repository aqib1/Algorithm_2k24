package org.algorithms.io.searching;

public class LinearSearch {
    // Time O(n)
    // Space O(1)
    public int find(int[] container, int item) {
        for(int i = 0; i < container.length; i++) {
            if(container[i] == item)
                return i;
        }

        return -1;
    }
}
