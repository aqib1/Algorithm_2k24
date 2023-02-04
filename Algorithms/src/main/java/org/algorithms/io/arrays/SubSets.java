package org.algorithms.io.arrays;

import java.util.ArrayList;
import java.util.List;

public class SubSets {

    private int limit;
    private final List<List<Integer>> output = new ArrayList<>();
    public List<List<Integer>> subSets(int[] data) {
        this.limit = data.length;
        List<Integer> currentCombo = new ArrayList<>();
        createSubsetsUsingBacktracking(0, currentCombo, data);
        return output;
    }

    private void createSubsetsUsingBacktracking(int current, List<Integer> currentCombo, int[] data) {
        output.add(new ArrayList<>(currentCombo));
        for(int i = current; i < limit; i++) {
            currentCombo.add(data[i]);
            createSubsetsUsingBacktracking(i + 1, currentCombo, data);
            currentCombo.removeLast();
        }
    }
}
