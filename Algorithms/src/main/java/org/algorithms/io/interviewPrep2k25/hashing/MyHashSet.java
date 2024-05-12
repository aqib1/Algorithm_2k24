package org.algorithms.io.interviewPrep2k25.hashing;

import java.util.Arrays;

//0 <= key <= 10^6
public class MyHashSet {
    private static final int LIMIT = (int)Math.pow(10, 6) + 1;
    private final int[] set;
    // Time complexity O(10^6) and space O(10^6)
    public MyHashSet() {
        this.set = new int[LIMIT];
        Arrays.fill(set, -1);
    }

    // O(1)
    public void add(int key) {
        set[key] = key;
    }

    // O(1)
    public void remove(int key) {
        if(contains(key))
            set[key] = -1;
    }

    // O(1)
    public boolean contains(int key) {
        return set[key] != -1;
    }
}
