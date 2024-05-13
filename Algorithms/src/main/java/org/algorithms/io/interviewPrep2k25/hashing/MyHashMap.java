package org.algorithms.io.interviewPrep2k25.hashing;

import java.util.Arrays;

public class MyHashMap {
    private static final int LIMIT = (int)Math.pow(10, 6) + 1;
    private final int[] map;
    // Time O(10^6) and space O(10^6)
    public MyHashMap() {
        this.map = new int[LIMIT];
        Arrays.fill(map, - 1);
    }

    // O(1)
    public void put(int key, int value) {
        map[key] = value;
    }

    // O(1)
    public int get(int key) {
        return map[key];
    }

    // O(1)
    public void remove(int key) {
        if(map[key] != -1) {
            map[key] = -1;
        }
    }
}
