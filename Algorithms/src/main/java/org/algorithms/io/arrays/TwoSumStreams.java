package org.algorithms.io.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSumStreams {
    private final Set<Integer> data;
    private final Map<Integer, Integer> valueCount;

    public TwoSumStreams() {
        this.data = new HashSet<>();
        this.valueCount = new HashMap<>();
    }

    public void add(int number) {
        this.valueCount.put(number, valueCount.getOrDefault(number, 0) + 1);
        this.data.add(number);
    }

    public boolean find(int value) {
        for(int v: data) {
            int diff = value - v;
            if((v == diff && valueCount.get(diff) > 1) || (v != diff && valueCount.containsKey(diff))) {
                return true;
            }
        }
        return false;
    }
}
