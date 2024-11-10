package org.algorithms.io.amazon2k24;

import java.util.Arrays;

public class MyHashMap {
    private static final int LIMIT = (int)Math.pow(10, 6);
    private final int[] map;
    public MyHashMap() {
        this.map = new int[LIMIT];
        Arrays.fill(map, -1);
    }

    public void put(int key, int value) {
        this.map[key] = value;
    }

    public int get(int key) {
        return this.map[key];
    }

    public void remove(int key) {
        this.map[key] = -1;
    }
}
